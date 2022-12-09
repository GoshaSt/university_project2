package com.gosha.universityproject.repository;

import com.gosha.universityproject.entity.DwarfChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DwarfChildrenRepository extends JpaRepository<DwarfChildren, Long> {

    DwarfChildren getTopByOrderByIdDesc();

    @Query("SELECT dc FROM DwarfChildren dc")
    List<DwarfChildren> getAll();

    @Query("SELECT dc FROM DwarfChildren dc WHERE dc.dateFinished IS NULL ORDER BY dc.dateCreated ASC")
    List<DwarfChildren> getChild();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 1")
    Integer countMikeChildren();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 1 AND d.dateFinished IS NOT NULL")
    Integer countMikeChildrenWithGift();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 1 AND d.dateFinished IS NULL")
    Integer countMikeChildrenWithoutGift();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 2")
    Integer countAlexChildren();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 2 AND d.dateFinished IS NOT NULL")
    Integer countAlexChildrenWithGift();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 2 AND d.dateFinished IS NULL")
    Integer countAlexChildrenWithoutGift();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 3")
    Integer countTimChildren();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 3 AND d.dateFinished IS NOT NULL")
    Integer countTimChildrenWithGift();

    @Query("SELECT COUNT(d.id) FROM DwarfChildren d WHERE d.dwarf.id = 3 AND d.dateFinished IS NULL")
    Integer countTimChildrenWithoutGift();

}
