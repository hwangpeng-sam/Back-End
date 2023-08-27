package com.example.plugissue.usages.repository;

import com.example.plugissue.usages.entity.Usages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface UsagesRepository extends JpaRepository<Usages,Long> {
    @Query(value = "select u from Usages u where u.time = :time")
    Object[] findByTime(@Param("time") LocalDateTime time);
}
