package com.family.dao;

import com.family.dao.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Family,Long> {

    Family findOneById(Long id);
}
