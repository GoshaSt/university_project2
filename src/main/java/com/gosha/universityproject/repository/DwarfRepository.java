package com.gosha.universityproject.repository;

import com.gosha.universityproject.entity.Dwarf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwarfRepository extends JpaRepository<Dwarf, Long> {

    Dwarf getTopByOrderByIdDesc();
}
