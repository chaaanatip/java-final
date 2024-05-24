package ssi2testbe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Testdto {
    @NotNull
    @NotBlank
    private String name;
}
