package com.auth_sys.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String msg;
    private int status;
    private LocalDateTime timestamp;
}
