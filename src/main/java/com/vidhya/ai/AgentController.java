package com.vidhya.ai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    private final ConsultantService consultantService;

    // Standard Constructor Injection
    public AgentController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @GetMapping("/ask-consultant")
    public String ask(@RequestParam(value = "q") String q) throws Exception {
        return consultantService.getAdvice(q);
    }
}