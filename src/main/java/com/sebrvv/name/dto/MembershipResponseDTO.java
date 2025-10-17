package com.sebrvv.name.dto;

import com.sebrvv.name.model.enums.MembershipType;
import lombok.Data;

// DTO para responder con los detalles de una membresía
@Data
public class MembershipResponseDTO {
    private Long id;
    private String memberName;
    private MembershipType membershipType;
    private int monthsSubscribed;
    private int monthsRemaining;
    private Double membershipPrice;
    private int monthlyVisits;
    private String description;
}
