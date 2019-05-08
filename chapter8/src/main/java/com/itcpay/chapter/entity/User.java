package com.itcpay.chapter.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;

}
