package com.sebrvv.name.service.impl;
import com.sebrvv.name.dto.MembershipRequestDTO;
import com.sebrvv.name.dto.MembershipResponseDTO;
import com.sebrvv.name.dto.MembershipStatisticsDTO;
import com.sebrvv.name.exception.MembershipNotFoundException;
import com.sebrvv.name.model.entity.Membership;
import com.sebrvv.name.model.enums.MembershipType;
import com.sebrvv.name.repository.MembershipRepository;
import com.sebrvv.name.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final ModelMapper modelMapper;

    @Override
    public MembershipResponseDTO createMembership(MembershipRequestDTO requestDTO) {
        Membership membership = modelMapper.map(requestDTO, Membership.class);
        membership.setMonthlyVisits(0);
        membership.setMonthsRemaining(requestDTO.getMonthsSubscribed());
        Membership saved = membershipRepository.save(membership);
        return modelMapper.map(saved, MembershipResponseDTO.class);
    }

    @Override
    public MembershipResponseDTO registerVisit(Long membershipId) {
        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new MembershipNotFoundException("Membresía no encontrada"));
        membership.setMonthlyVisits(membership.getMonthlyVisits() + 1);
        Membership updated = membershipRepository.save(membership);
        return modelMapper.map(updated, MembershipResponseDTO.class);
    }

    @Override
    public List<MembershipResponseDTO> getMembershipsByType(MembershipType membershipType) {
        List<Membership> memberships = (membershipType == null)
                ? membershipRepository.findAll()
                : membershipRepository.findByMembershipType(membershipType);
        return memberships.stream()
                .map(m -> modelMapper.map(m, MembershipResponseDTO.class))
                .toList();
    }

    @Override
    public MembershipStatisticsDTO getStatistics() {
        long total = membershipRepository.count();
        double totalIncome = membershipRepository.findAll().stream()
                .mapToDouble(Membership::getMembershipPrice)
                .sum();
        return new MembershipStatisticsDTO(total, totalIncome);
    }

    @Override
    public void deleteMembership(Long membershipId) {
        if (!membershipRepository.existsById(membershipId)) {
            throw new MembershipNotFoundException("Membresía no encontrada");
        }
        membershipRepository.deleteById(membershipId);
    }
}