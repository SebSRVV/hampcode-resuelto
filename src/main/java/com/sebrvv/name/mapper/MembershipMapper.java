package com.sebrvv.name.mapper;

import com.sebrvv.name.dto.MembershipRequestDTO;
import com.sebrvv.name.dto.MembershipResponseDTO;
import com.sebrvv.name.model.entity.Membership;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

// Mapper para Membership
@Component
@RequiredArgsConstructor
public class MembershipMapper {

    private final ModelMapper modelMapper;

    public Membership toEntity(MembershipRequestDTO dto) {
        return modelMapper.map(dto, Membership.class);
    }

    public MembershipResponseDTO toDTO(Membership entity) {
        return modelMapper.map(entity, MembershipResponseDTO.class);
    }
}
