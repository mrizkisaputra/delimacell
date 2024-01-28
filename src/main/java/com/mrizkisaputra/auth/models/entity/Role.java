package com.mrizkisaputra.auth.models.entity;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"),
    EMPLOYE("EMPLOYE");

    private final String role;

    private Role(String role) {
        this.role = role;
    }
}
