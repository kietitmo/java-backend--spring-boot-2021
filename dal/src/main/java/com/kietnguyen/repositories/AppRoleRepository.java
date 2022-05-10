package com.kietnguyen.repositories;

import com.kietnguyen.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
//    @Query(value = "SELECT ur.appRole.roleName FROM UserRole ur WHERE ur.appUser.userId = :userId ")
//    public List<String> getRoleNames(@Param("userId") Integer userId);
}
