package com.kietnguyen.repositories;

import com.kietnguyen.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    @Query(value = "FROM AppUser u WHERE u.userName = :userName")
    AppUser findUserAccount(@Param("userName") String userName);
}
