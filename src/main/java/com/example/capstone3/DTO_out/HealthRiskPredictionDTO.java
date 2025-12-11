package com.example.capstone3.DTO_out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthRiskPredictionDTO {
    private String riskLevel;
    private List<String> expectedProblems;
    private List<String> recommendation;
}
