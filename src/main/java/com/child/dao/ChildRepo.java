package com.child.dao;

import com.child.dao.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {

    @Query("SELECT T FROM Child T WHERE T.name LIKE LOWER(CONCAT('%',:query,'%')) " +
            "OR T.lastName LIKE LOWER(CONCAT('%',:query,'%')) " +
            "OR T.pesel LIKE LOWER(CONCAT('%',:query,'%')) " +
            "OR T.birthDate LIKE LOWER(CONCAT('%',:query,'%'))" +
            "OR T.sex LIKE LOWER(CONCAT('%',:query,'%'))")
    List<Child> findAll(@Param("query") String query);
}
