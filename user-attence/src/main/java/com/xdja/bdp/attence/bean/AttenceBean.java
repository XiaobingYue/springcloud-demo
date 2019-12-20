package com.xdja.bdp.attence.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yxb
 * @since 2019/12/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttenceBean extends PersonDepBean {

    private Long checkInTime;

}
