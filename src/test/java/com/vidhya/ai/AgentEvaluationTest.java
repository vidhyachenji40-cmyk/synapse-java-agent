package com.vidhya.ai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AgentEvaluationTest {

    @Autowired
    private ConsultantService consultantService;

    @Test
    public void testAIConfidenceThreshold() {
        String response = consultantService.processRequest("How do I optimize Synapse?");
        
        double confidenceScore = 0.0;
        // Search for "Confidence Score:" anywhere in the text
        if (response.contains("Confidence Score:")) {
            String[] parts = response.split("Confidence Score:");
            if (parts.length > 1) {
                // Extract the numbers (like 0.95)
                String scorePart = parts[1].trim().replaceAll("[^0-9.]", "");
                if (!scorePart.isEmpty()) {
                    confidenceScore = Double.parseDouble(scorePart);
                }
            }
        }

        System.out.println("AI Evaluation - Detected Confidence: " + confidenceScore);
        assertTrue(confidenceScore >= 0.8, "AI Confidence is too low: " + confidenceScore);
    }
}
