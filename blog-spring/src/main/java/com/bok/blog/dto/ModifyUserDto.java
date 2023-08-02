package com.bok.blog.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ModifyUserDto {
    private String user_nick;
    private String user_thumb;
}
