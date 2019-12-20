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
public class Org  {

    private static final long serialVersionUID=1L;

    private String id;

    private String name;

    private String code;

    private String parentId;

    private String treeId;

    private String treeCode;

    private Long lastUpdateTime;

}
