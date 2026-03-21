package com.vidhya.ai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
public class AgentController {

    @GetMapping("/run-agent")
    public String runAgent() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./synapse_db", "sa", "")) {
            // This is where your Agent logic lives
            return "🚀 AI Agent Triggered! Scanning Azure Synapse Metadata...";
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}