package com.cp.stuspringbootdemo.domain;

import lombok.Data;

@Data
public class Permission {
    private Integer id;
    private String permission;
    private Integer roleid;
}
