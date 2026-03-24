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
        String response = consultantService.askConsultant("How do I optimize Synapse?");
        
        // Find the "Confidence Score:" text and get the number after it
        double confidenceScore = 0.0;
        if (response.contains("Confidence Score:")) {
            String scorePart = response.split("Confidence Score:")[1].trim();
            // Remove any trailing stars or characters
            scorePart = scorePart.replaceAll("[^0-9.]", "");
            confidenceScore = Double.parseDouble(scorePart);
        }

        System.out.println("AI Evaluation - Detected Confidence: " + confidenceScore);
        assertTrue(confidenceScore >= 0.8, "AI Confidence is too low: " + confidenceScore);
    }
}
