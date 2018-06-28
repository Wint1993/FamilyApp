package com.father.dao;

import com.father.dao.entity.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatherRepo extends JpaRepository<Father,Long>{
}
