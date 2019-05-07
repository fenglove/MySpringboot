package com.itcpay.chapter.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;


}
