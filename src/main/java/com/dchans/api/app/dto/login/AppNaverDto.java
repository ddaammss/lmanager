package com.dchans.api.app.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppNaverDto {
    private String id;
    private String email;
    private String name;
    private String profileImage;
    private String age;
    private String birthday;
    private String birthYear;
    private String gender;
    private String mobile;

    private String jwtToken;
}
