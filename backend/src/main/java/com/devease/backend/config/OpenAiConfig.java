package com.devease.backend.config;

import com.openai.client.OpenAIClient;
import com.openai.client.OpenAIClientImpl;
import com.openai.client.OpenAIConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAiConfig {

    @Bean
    public OpenAIClient openAIClient(@Value("${openai.api.key}") String apiKey) {
        OpenAIConfig config = OpenAIConfig.builder()
                .apiKey(apiKey)
                .build();
        return new OpenAIClientImpl(config);
    }
}