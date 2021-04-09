package com.xdja.bdp.attence.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xdja.bdp.attence.baseapi.BaseApiService;
import com.xdja.bdp.attence.bean.AttenceBean;
import com.xdja.bdp.attence.bean.PersonDep;
import com.xdja.bdp.attence.bean.PersonDepBean;
import com.xdja.bdp.attence.domain.Attence;
import com.xdja.bdp.attence.service.IAttenceService;
import com.xdja.bdp.common.bean.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yxb
 * @since 2019-12-18
 */
@RestController
@RequestMapping("/attence")
public class AttenceController {

    @Autowired
    private IAttenceService attenceService;
    @Resource
    private BaseApiService baseApiService;


    @RequestMapping("/checkIn")
    public Result checkIn(String accountId) {
        Attence attence = new Attence();
        attence.setAccountId(accountId);
        attence.setCheckInTime(System.currentTimeMillis());
        attenceService.save(attence);
        return Result.successResult();
    }

    @RequestMapping("/list")
    public Result<PersonDepBean> list(String accountId) {
        Result<PersonDepBean> result = baseApiService.personDepDetail(accountId);
        PersonDepBean personDepBean = result.getData();
        List<Attence> list = attenceService.list(Wrappers.<Attence>lambdaQuery()
                .eq(Attence::getAccountId, accountId));
        personDepBean.setAttenceList(list);
        return Result.successResult(personDepBean);
    }

    @RequestMapping("/listAll")
    public Result<List<PersonDepBean>> listAll() {
        Result<List<PersonDepBean>> result = baseApiService.listPersonDep();
        List<PersonDepBean> list = result.getData();
        list.forEach(personDepBean -> {
            List<Attence> attenceList = attenceService.list(Wrappers.<Attence>lambdaQuery()
                    .eq(Attence::getAccountId, personDepBean.getId()));
            personDepBean.setAttenceList(attenceList);
        });
        return Result.successResult(list);
    }

    @RequestMapping("/v2/listAll")
    public Result<List<AttenceBean>> listAllV2() {
        // 查询打卡列表
        List<Attence> attenceList = attenceService.list();
        List<AttenceBean> attenceBeanList = new ArrayList<>();
        if (CollectionUtils.isEmpty(attenceList)) {
            return Result.successResult(attenceBeanList);
        }
        // 获取账户ID列表
        Set<String> accountIds = attenceList.stream().map(Attence::getAccountId).collect(Collectors.toSet());
        // 批量获取账户信息
        Result<List<PersonDepBean>> result = baseApiService.listPersonDepBatch(accountIds);
        List<PersonDepBean> personDepBeanList = result.getData();
        Map<String, PersonDepBean> map = personDepBeanList
                .stream()
                .collect(Collectors.toMap(PersonDep::getId, personDepBean -> personDepBean));
        // 组装
        attenceList.forEach(attence -> {
            AttenceBean attenceBean = new AttenceBean();
            PersonDepBean personDepBean = map.get(attence.getAccountId());
            BeanUtils.copyProperties(personDepBean, attenceBean);
            attenceBean.setCheckInTime(attence.getCheckInTime());
            attenceBeanList.add(attenceBean);
        });
        return Result.successResult(attenceBeanList);
    }


}

