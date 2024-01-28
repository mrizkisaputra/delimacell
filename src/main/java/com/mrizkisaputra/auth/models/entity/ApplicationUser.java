package com.mrizkisaputra.auth.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "s_users")
public class ApplicationUser {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull @NotEmpty @Size(min = 8, max = 255)
    @Column(unique = true)
    private String username;

    @NotNull @NotEmpty @Size(min = 8, max = 255)
    private String password;

    private Boolean active = Boolean.TRUE;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private ApplicationRole role;

    public ApplicationUser() { }
}
