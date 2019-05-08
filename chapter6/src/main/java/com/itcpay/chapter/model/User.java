package com.itcpay.chapter.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 5697120281814175161L;

    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;

}
