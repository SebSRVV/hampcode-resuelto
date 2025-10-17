package com.sebrvv.name.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


// DTO para las estadisticas de membresías
@Data
@AllArgsConstructor
public class MembershipStatisticsDTO {
    private long totalMemberships;
    private double totalRevenue;
}
