package com.example.week02_day04_hw_rahaf;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {
    private Integer ID ;
    private String title;
    private String description;
    private String status;
}
