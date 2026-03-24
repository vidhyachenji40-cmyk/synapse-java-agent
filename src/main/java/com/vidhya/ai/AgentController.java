package com.vidhya.ai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class AgentController {

    private final ConsultantService consultantService;

    public AgentController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    // --- NEW: Enterprise Health Check (Shows ALM/DevOps Readiness) ---
    @GetMapping("/health")
    public String health() {
        return "{\"status\": \"UP\", \"region\": \"Boise-Data-Center\", \"version\": \"2.0-AI\"}";
    }

    @GetMapping("/ask-consultant")
    public String ask(@RequestParam(value = "q") String q) throws Exception {
        
        // --- NEW: Audit Log (Proves you can monitor AI interactions) ---
        System.out.println("AUDIT [AI-Foundry-Log]: Request processed at " + LocalDateTime.now() + " | Query: " + q);
        
        return consultantService.getAdvice(q);
    }
}