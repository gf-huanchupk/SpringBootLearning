package com.gf.entity;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Integer id;
    private String commodityCode;
    private Integer count;
}
