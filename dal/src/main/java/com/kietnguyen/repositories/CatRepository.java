package com.kietnguyen.repositories;

import com.kietnguyen.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer>{

    @Query(value = "FROM Cat cat WHERE cat.owner.id = :ownerId")
    public List<Cat> getAllCatsOfOwner(@Param("ownerId") Integer ownerId);
}
