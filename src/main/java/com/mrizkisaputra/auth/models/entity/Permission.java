package com.mrizkisaputra.auth.models.entity;

import lombok.Getter;

@Getter
public enum Permission {
    PRODUCT_READ("PRODUCT::READ"),
    PRODUCT_WRITE("PRODUCT::WRITE"),
    EMPLOYE_READ("EMPLOYE::READ"),
    EMPLOYE_WRITE("EMPLOYE::WRITE");

    private final String permission;
    private Permission(String permission) {
        this.permission = permission;
    }
}
