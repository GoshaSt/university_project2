package com.gosha.universityproject.repository;

import com.gosha.universityproject.entity.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {

    Children save(Children children);

    @Query("SELECT COUNT(c) FROM Children c WHERE c.dateFinished IS NOT NULL")
    int childrenWithGift();

    @Query("SELECT COUNT(c) FROM Children c WHERE c.dateFinished IS NULL")
    int childrenWithoutGift();
}
