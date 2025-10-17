package com.sebrvv.name.service;

import com.sebrvv.name.dto.MembershipRequestDTO;
import com.sebrvv.name.dto.MembershipResponseDTO;
import com.sebrvv.name.dto.MembershipStatisticsDTO;
import com.sebrvv.name.model.enums.MembershipType;

import java.util.List;

public interface MembershipService {
    MembershipResponseDTO createMembership(MembershipRequestDTO requestDTO);
    MembershipResponseDTO registerVisit(Long membershipId);
    List<MembershipResponseDTO> getMembershipsByType(MembershipType membershipType);
    MembershipStatisticsDTO getStatistics();
    void deleteMembership(Long membershipId);
}
