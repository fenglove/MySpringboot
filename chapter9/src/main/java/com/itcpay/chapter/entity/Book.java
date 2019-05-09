package com.itcpay.chapter.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class Book implements Serializable {

    private static final long serialVersionUID = 901967570569576204L;

    private String id;
    private String name;

}
