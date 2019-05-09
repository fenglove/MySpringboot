package com.itcpay.chapter.entity;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 901967570569576204L;

    private String id;
    private String name;

}
