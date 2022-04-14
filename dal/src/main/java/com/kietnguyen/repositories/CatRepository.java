package com.kietnguyen.repositories;

import com.kietnguyen.enums.CatBreed;
import com.kietnguyen.enums.CatColor;
import com.kietnguyen.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CatRepository extends JpaRepository<Cat, Integer>{

    @Query(value = "FROM Cat cat WHERE cat.owner.id = :ownerId")
    public List<Cat> getAllCatsOfOwner(@Param("ownerId") Integer ownerId);

    @Query(value = "FROM Cat cat WHERE cat.color = :color")
    public List<Cat> getCatByColor(@Param("color") CatColor color);

    @Query(value = "FROM Cat cat WHERE cat.breed = :breed")
    public List<Cat> getCatByBreed(@Param("breed") CatBreed breed);
}
