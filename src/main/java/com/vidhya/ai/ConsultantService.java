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

    public ConsultantService(AnthropicChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getAdvice(String message) {
        try {
            String tips = new String(expertTips.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            
            // 1. Define the AI's Identity
            SystemMessage systemMessage = new SystemMessage(
                "You are a Senior Azure Synapse Architect. Always provide advice that is " +
                "highly technical, includes SQL examples where relevant, and prioritizes " +
                "cost-efficiency and performance. Use the following context: " + tips
            );

            // 2. Add the User's Question
            UserMessage userMessage = new UserMessage(message);

            // 3. Send the complete prompt
            return chatModel.call(new Prompt(List.of(systemMessage, userMessage)))
                            .getResult().getOutput().getContent();
                            
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}