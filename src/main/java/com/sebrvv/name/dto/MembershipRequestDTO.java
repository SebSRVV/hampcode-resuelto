package com.sebrvv.name.dto;

import com.sebrvv.name.model.enums.MembershipType;
import lombok.Data;

// DTO para crear o actualizar una membresía
@Data
public class MembershipRequestDTO {
    private String memberName;
    private MembershipType membershipType;
    private int monthsSubscribed;
    private Double membershipPrice;
    private String description;
}
