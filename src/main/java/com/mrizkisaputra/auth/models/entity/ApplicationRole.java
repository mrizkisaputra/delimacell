package com.mrizkisaputra.auth.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity(name = "s_roles")
public class ApplicationRole {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private Role name;

    @OneToMany(mappedBy = "role")
    private Set<ApplicationUser> users;

    @ManyToMany
    @JoinTable(
            name = "s_roles_permissions",
            joinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_permission", referencedColumnName = "id")
    )
    private Set<ApplicationPermission> applicationPermissions = new LinkedHashSet<>();

    public ApplicationRole() { }
}
