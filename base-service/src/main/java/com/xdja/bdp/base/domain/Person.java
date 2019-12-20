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
@TableName("t_person")
public class Person extends Model<Person> {

    private static final long serialVersionUID=1L;

    @TableId(value = "c_id",type = IdType.UUID)
    private String id;

    @TableField("c_name")
    private String name;

    @TableField("c_identifier")
    private String identifier;

    @TableField("n_gender")
    private Integer gender;

    @TableField("c_email")
    private String email;

    @TableField("c_telephone")
    private String telephone;

    @TableField("n_last_update_time")
    private Long lastUpdateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
