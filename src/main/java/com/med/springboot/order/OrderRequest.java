package com.med.springboot.order;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderRequest{
    private Long clientId;
    private List<Long> engineerIds;  // IDs of team members
    private String projectName;
    private Integer estimatedDays;
    private LocalDate startDate;
    private LocalDate deadline;
}
