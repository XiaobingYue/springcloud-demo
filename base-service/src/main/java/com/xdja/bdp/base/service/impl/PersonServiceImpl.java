package com.xdja.bdp.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xdja.bdp.base.dao.PersonMapper;
import com.xdja.bdp.base.domain.Person;
import com.xdja.bdp.base.service.IPersonService;
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
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
