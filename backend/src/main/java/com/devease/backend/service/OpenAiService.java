package com.devease.backend.service;

import com.openai.client.OpenAIClient;
import com.openai.models.ChatCompletionCreateParams;
import com.openai.models.ChatCompletion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenAiService {

    private final OpenAIClient client;
    private final String model;

    public OpenAiService(OpenAIClient client,
                         @Value("${openai.model:gpt-4o-mini}") String model) {
        this.client = client;
        this.model = model;
    }

    public String explainError(String errorText) {
        String prompt = """
                Explain the following programming error to a beginner developer.

                Return your answer in this format:
                1. What it means
                2. Why it happened
                3. How to fix it

                Error:
                %s
                """.formatted(errorText);

        return chat(prompt);
    }

    public String explainCode(String code) {
        String prompt = """
                Explain the following code in simple language.
                Assume the reader is a beginner.

                Explain:
                - What the code does
                - How it works step by step

                Code:
                %s
                """.formatted(code);

        return chat(prompt);
    }

    public String intentPlan(String intent) {
        String prompt = """
                User intent:
                %s

                Return:
                1. Step-by-step plan
                2. Suggested classes
                3. ONE simple main class skeleton (optional)

                Keep it concise and beginner-friendly.
                """.formatted(intent);

        return chat(prompt);
    }

    private String chat(String prompt) {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)
                .addUserMessage(prompt)
                .build();

        ChatCompletion response = client.chat().completions().create(params);

        return response.choices().get(0).message().content();
    }
}