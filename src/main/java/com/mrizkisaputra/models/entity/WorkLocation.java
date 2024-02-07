package com.mrizkisaputra.models.entity;

import lombok.Getter;

@Getter
public enum WorkLocation {
    CABANG_1("Sentosa (cabang 1)"),
    CABANG_2("Banten (cabang 2)");

    private final String detail;

    private WorkLocation(String detail) {
        this.detail = detail;
    }
}
