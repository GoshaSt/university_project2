package com.gosha.universityproject.repository;

import com.gosha.universityproject.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {

    Gift getByGift(String gift);
}
