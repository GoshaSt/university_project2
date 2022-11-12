package com.gosha.universityproject.repository;

import com.gosha.universityproject.entity.DwarfChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwarfChildrenRepository extends JpaRepository<DwarfChildren, Long> {

    DwarfChildren getTopByOrderByIdDesc();
}
