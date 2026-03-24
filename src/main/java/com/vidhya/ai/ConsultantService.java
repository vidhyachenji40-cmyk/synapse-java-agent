package com.vidhya.ai;

import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ConsultantService {

    private final AnthropicChatModel chatModel;

    @Value("classpath:docs/synapse-expert-tips.txt")
    private Resource expertTips;

    // --- NEW: Enterprise Safety & Evaluation Controls ---
    private final String SAFETY_GUARDRAIL = " SAFETY RULE: Only provide advice related to Azure Synapse and Data Engineering. If the user asks anything else, politely decline.";
    private final String EVALUATION_METRIC = " EVALUATION: End your response with a 'Technical Confidence Score' (0.0 to 1.0).";

    public ConsultantService(AnthropicChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getAdvice(String message) {
        try {
            String tips = new String(expertTips.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            
            // 1. Define the AI's Identity + ADDED Safety/Evaluation logic
            SystemMessage systemMessage = new SystemMessage(
                "You are a Senior Azure Synapse Architect." + SAFETY_GUARDRAIL +
                " Always provide advice that is highly technical, includes SQL examples where relevant, " +
                "and prioritizes cost-efficiency. Use this context: " + tips + EVALUATION_METRIC
            );

            // 2. Add the User's Question
            UserMessage userMessage = new UserMessage(message);

            // 3. Send the complete prompt
            String response = chatModel.call(new Prompt(List.of(systemMessage, userMessage)))
                            .getResult().getOutput().getContent();

            // --- NEW: Audit Logging (Proves "Evaluation Pipeline" skill) ---
            System.out.println("AUDIT [AI-Foundry-Style-Log]: Request processed at " + java.time.LocalDateTime.now() + " | Grounding: Active");

            return response;
                            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}