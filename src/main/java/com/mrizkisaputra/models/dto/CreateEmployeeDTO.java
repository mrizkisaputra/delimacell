package com.mrizkisaputra.models.dto;

import com.mrizkisaputra.models.entity.WorkLocation;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateEmployeeDTO {
    @NotBlank(message = "{employee.name.not-blank}")
    @Size(max = 100, message = "{employee.name.size}")
    private String name;

    @NotNull(message = "{employee.salary.notnull}") @Min(value = 0, message = "{employee.salary.min}")
    @Positive(message = "{employee.salary.positive}")
    private Double salary;

    @NotNull(message = "{employee.workplace-location.notnull}")
    private WorkLocation workLocation;

    @NotBlank(message = "{employee.user-account.not-blank}")
    private String userAccount;

    @NotBlank(message = "{employee.password-account.not-blank}")
    private String passwordAccount;

    public CreateEmployeeDTO() { }
}
