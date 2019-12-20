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
public class PersonDep {

    private static final long serialVersionUID=1L;

    private String id;

    private String code;

    private String personId;

    private String orgId;

    private String position;

    private Integer orderField;

    private String officeEmail;

    private String officePhone;

    private Long lastUpdateTime;

}
