package com.mrizkisaputra.auth.repository;

import com.mrizkisaputra.auth.models.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, String> {
    @Query("SELECT r.name, u.username FROM s_users u INNER JOIN u.role r WHERE u.username = :username")
    String findRoleNameByUsername(@Param("username") String username);

    void deleteByEmployee_Id(String id);

    ApplicationUser findByEmployee_Id(String id);
}
