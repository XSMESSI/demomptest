package com.atguigu.demomptest.entity;

import lombok.Data;

/**
 * @Author: Leo messi
 * @Date: 2022/05/22/18:12
 * @Description: 实体类
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
