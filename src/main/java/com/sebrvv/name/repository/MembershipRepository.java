package com.sebrvv.name.repository;

import com.sebrvv.name.model.entity.Membership;
import com.sebrvv.name.model.enums.MembershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    List<Membership> findByMembershipType(MembershipType membershipType);
}
