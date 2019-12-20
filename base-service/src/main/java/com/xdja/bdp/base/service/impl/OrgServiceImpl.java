package com.xdja.bdp.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdja.bdp.base.dao.OrgMapper;
import com.xdja.bdp.base.domain.Org;
import com.xdja.bdp.base.service.IOrgService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxb
 * @since 2019-12-17
 */
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements IOrgService {

}
