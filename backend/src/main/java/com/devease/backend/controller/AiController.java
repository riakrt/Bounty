package com.devease.backend.controller;

import com.devease.backend.dto.AiResponse;
import com.devease.backend.dto.ExplainRequest;
import com.devease.backend.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AiController {

    private final OpenAiService openAiService;

    public AiController(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    @PostMapping("/explain-error")
    public AiResponse explainError(@RequestBody ExplainRequest request) {
        try {
            String out = openAiService.explainError(request.getText());
            return new AiResponse(out);
        } catch (Exception e) {
            return new AiResponse("AI service temporarily unavailable. Please try again.");
        }
    }

    @PostMapping("/explain-code")
    public AiResponse explainCode(@RequestBody ExplainRequest request) {
        try {
            String out = openAiService.explainCode(request.getText());
            return new AiResponse(out);
        } catch (Exception e) {
            return new AiResponse("AI service temporarily unavailable. Please try again.");
        }
    }

    @PostMapping("/intent-plan")
    public AiResponse intentPlan(@RequestBody ExplainRequest request) {
        try {
            String out = openAiService.intentPlan(request.getText());
            return new AiResponse(out);
        } catch (Exception e) {
            return new AiResponse("AI service temporarily unavailable. Please try again.");
        }
    }
}