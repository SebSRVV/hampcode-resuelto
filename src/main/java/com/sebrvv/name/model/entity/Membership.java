package com.sebrvv.name.model.entity;

import com.sebrvv.name.model.enums.MembershipType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entidad que representa una membresía en el sistema
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_type", nullable = false)
    private MembershipType membershipType;

    @Column(name = "months_subscribed", nullable = false)
    private int monthsSubscribed;

    @Column(name = "months_remaining", nullable = false)
    private int monthsRemaining;

    @Column(name = "membership_price", nullable = false)
    private Double membershipPrice;

    @Column(name = "monthly_visits", nullable = false)
    private int monthlyVisits = 0;

    @Column(name = "description", nullable = false, length = 255)
    private String description;
}
