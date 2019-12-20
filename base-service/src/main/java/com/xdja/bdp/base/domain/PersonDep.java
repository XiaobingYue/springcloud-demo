package com.xdja.bdp.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxb
 * @since 2019-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_person_dep")
public class PersonDep extends Model<PersonDep> {

    private static final long serialVersionUID=1L;

    @TableId(value = "c_id",type = IdType.UUID)
    private String id;

    @TableField("c_code")
    private String code;

    @TableField("c_person_id")
    private String personId;

    @TableField("c_org_id")
    private String orgId;

    @TableField("c_position")
    private String position;

    @TableField("n_order_field")
    private Integer orderField;

    @TableField("c_office_email")
    private String officeEmail;

    @TableField("c_office_phone")
    private String officePhone;

    @TableField("n_last_update_time")
    private Long lastUpdateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
