package com.mrizkisaputra.auth.repository;

import com.mrizkisaputra.auth.models.entity.ApplicationRole;
import com.mrizkisaputra.auth.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRoleRepository extends JpaRepository<ApplicationRole, String> {
    ApplicationRole findByName(Role name);
}
