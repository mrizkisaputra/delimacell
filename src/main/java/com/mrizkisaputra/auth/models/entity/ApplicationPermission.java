package com.mrizkisaputra.auth.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity(name = "s_permissions")
public class ApplicationPermission {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull
    @Column(name = "permission_value")
    @Enumerated(EnumType.STRING)
    private Permission permissionValue;

    @NotNull
    @Column(name = "permission_label")
    @Enumerated(EnumType.STRING)
    private Permission permissionLabel;

    @ManyToMany(mappedBy = "applicationPermissions")
    private Set<ApplicationRole> applicationRoles = new LinkedHashSet<>();

    public ApplicationPermission() { }
}
