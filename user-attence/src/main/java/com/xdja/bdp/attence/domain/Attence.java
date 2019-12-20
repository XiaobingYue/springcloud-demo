package com.xdja.bdp.attence.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxb
 * @since 2019-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_attence")
public class Attence extends Model<Attence> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "c_id",type = IdType.UUID)
    private String id;

    @TableField("n_check_in_time")
    private Long checkInTime;

    @TableField("c_account_id")
    private String accountId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
