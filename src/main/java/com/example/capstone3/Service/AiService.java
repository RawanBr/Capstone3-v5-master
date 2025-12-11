package com.example.capstone3.Service;

import com.example.capstone3.DTO_in.HealthRecordDTO;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AiService {
//    @Value("${spring.ai.openai.api-key}")
//    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

//    public CampaignHealthRiskResponse predictRisk(List<HealthRecordDTO> records) {
//
//        String prompt = buildPrompt(records);
//
//        Map<String, Object> requestBody = Map.of(
//                "model", "gpt-4o-mini",
//                "messages", List.of(
//                        Map.of("role", "system", "content", "You are a medical risk analysis assistant."),
//                        Map.of("role", "user", "content", prompt)
//                ),
//                "temperature", 0.2
//        );
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(apiKey);
//
//        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<Map> response = restTemplate.postForEntity(
//                "https://api.openai.com/v1/chat/completions",
//                request,
//                Map.class
//        );
//
//        String aiText = extractContent(response.getBody());
//
//        return parseToResponse(aiText);
//    }

    private String buildPrompt(List<HealthRecordDTO> records) {

        StringBuilder sb = new StringBuilder();
        sb.append("Analyze these health records of pilgrims and predict overall risks:\n");

        for (HealthRecordDTO r : records) {
            sb.append("Diabetic: ").append(r.getDiabetic()).append(", ")
                    .append("HighBloodPressure: ").append(r.getHighBloodPressure()).append(", ")
                    .append("Asthma: ").append(r.getAsthma()).append(", ")
                    .append("HeartDisease: ").append(r.getHeartDisease()).append(", ")
                    .append("FoodAllergy: ").append(r.getFoodAllergy()).append(", ")
                    .append("Details: ").append(r.getAllergyDetails()).append("\n");
        }

        sb.append("""
    Respond in JSON with format:
    {
      "campaignRisk": "",
      "expectedProblems": [],
      "recommendations": []
    }
    """);

        return sb.toString();
    }

    }