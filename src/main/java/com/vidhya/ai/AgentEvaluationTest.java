package com.vidhya.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AgentEvaluationTest {

    @Autowired
    private ConsultantService consultantService;

    @Test
    void testAIConfidenceThreshold() throws Exception {
        // 1. Ask a highly technical Synapse question
        String query = "How do I optimize a 5TB table with Hash Distribution?";
        String response = consultantService.getAdvice(query);

        // 2. Extract the score (e.g., 0.95) from the AI's response text
        String scoreTicker = "Technical Confidence Score:";
        double score = Double.parseDouble(response.split(scoreTicker)[1].trim().replace("*", ""));

        // 3. Automation Gate: Fail the test if confidence is under 80%
        System.out.println("EVALUATION RESULT: AI Confidence is " + score);
        assertTrue(score >= 0.8, "AI Confidence is too low for a production environment!");
    }
}