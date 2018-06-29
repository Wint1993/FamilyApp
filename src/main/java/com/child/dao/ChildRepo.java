package com.child.dao;

import com.child.dao.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {

    @Query("SELECT T FROM Child T WHERE LOWER(T.name) LIKE (CONCAT('%',:query,'%')) " +
            "OR LOWER(T.lastName) LIKE (CONCAT('%',:query,'%')) " +
            "OR LOWER(T.pesel) LIKE (CONCAT('%',:query,'%')) " +
            "OR LOWER(T.birthDate) LIKE (CONCAT('%',:query,'%'))" +
            "OR LOWER(T.sex) LIKE (CONCAT('%',:query,'%'))")
    List<Child> findAll(@Param("query") String query);

}
