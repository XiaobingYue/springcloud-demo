package com.xdja.bdp.common.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页Bean
 *
 * @author yxb
 * @since 2019/6/26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    /**
     * 页码 默认1页
     */
    private Integer pageNo = 1;

    /**
     * 数量 默认10条
     */
    private Integer pageSize = 10;

    /**
     * 总数 默认0
     */
    private Long total = 0L;


    public PageBean(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
