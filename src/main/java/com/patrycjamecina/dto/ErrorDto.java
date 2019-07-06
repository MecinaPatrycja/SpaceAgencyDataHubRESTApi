package com.patrycjamecina.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {
    private String message;
    private Long event;
}
