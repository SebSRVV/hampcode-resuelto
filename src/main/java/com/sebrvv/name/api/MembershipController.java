package com.sebrvv.name.api;

import com.sebrvv.name.dto.MembershipRequestDTO;
import com.sebrvv.name.dto.MembershipResponseDTO;
import com.sebrvv.name.dto.MembershipStatisticsDTO;
import com.sebrvv.name.model.enums.MembershipType;
import com.sebrvv.name.service.MembershipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("memberships")
@RequiredArgsConstructor
public class MembershipController {
    private final MembershipService membershipService;

    // Crear una nueva membresía
    @PostMapping
    public ResponseEntity<MembershipResponseDTO> createMembership(@RequestBody MembershipRequestDTO requestDTO) {
        MembershipResponseDTO createdMembership = membershipService.createMembership(requestDTO);
        return new ResponseEntity<>(createdMembership, HttpStatus.CREATED);
    }

    // Registrar una visita para una membresía existente
    @PutMapping("/{membershipId}/visit")
    public ResponseEntity<MembershipResponseDTO> registerVisit(@PathVariable Long membershipId) {
        MembershipResponseDTO updatedMembership = membershipService.registerVisit(membershipId);
        return ResponseEntity.ok(updatedMembership);
    }

    // Obtener membresías, opcionalmente filtradas por tipo
    @GetMapping
    public ResponseEntity<List<MembershipResponseDTO>> getMembershipsByType(
            @RequestParam(required = false) MembershipType membershipType) {
        List<MembershipResponseDTO> memberships = membershipService.getMembershipsByType(membershipType);
        return ResponseEntity.ok(memberships);
    }

    // Obtener estadísticas de membresías
    @GetMapping("/statistics")
    public ResponseEntity<MembershipStatisticsDTO> getStatistics() {
        MembershipStatisticsDTO statistics = membershipService.getStatistics();
        return ResponseEntity.ok(statistics);
    }

    // Eliminar una membresía por ID
    @DeleteMapping("/{membershipId}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Long membershipId) {
        membershipService.deleteMembership(membershipId);
        return ResponseEntity.noContent().build();
    }

}
