package com.auth_sys.dto;

import com.auth_sys.util.Role;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private Role role;
}
