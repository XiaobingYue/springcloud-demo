package com.xdja.bdp.attence.bean;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author yxb
 * @since 2019-12-17
 */
@Data
public class Person {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String identifier;

    private Integer gender;

    private String email;

    private String telephone;

    private Long lastUpdateTime;

}
