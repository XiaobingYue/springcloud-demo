package com.xdja.bdp.base.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xdja.bdp.base.bean.PersonDepBean;
import com.xdja.bdp.base.domain.Org;
import com.xdja.bdp.base.domain.Person;
import com.xdja.bdp.base.domain.PersonDep;
import com.xdja.bdp.base.service.IOrgService;
import com.xdja.bdp.base.service.IPersonDepService;
import com.xdja.bdp.base.service.IPersonService;
import com.xdja.bdp.common.bean.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yxb
 * @since 2019-12-17
 */
@RestController
@RequestMapping("/personDep")
public class PersonDepController {

    @Autowired
    private IPersonDepService personDepService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private IOrgService orgService;

    @GetMapping(value = "/list")
    public Result<List<PersonDepBean>> list() {
        List<PersonDep> list = personDepService.list();
        List<PersonDepBean> personDepBeans = new ArrayList<>();
        list.forEach(personDep -> personDepBeans.add(getPersonDepBean(personDep)));
        return Result.successResult(personDepBeans);
    }

    @PostMapping("/add")
    public Result add(@RequestBody PersonDep personDep) {
        personDep.setOrderField(999);
        personDep.setLastUpdateTime(System.currentTimeMillis());
        personDepService.save(personDep);
        return Result.successResult();
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("id") String id) {
        personDepService.removeById(id);
        return Result.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam("id") String id) {
        PersonDep personDep = personDepService.getById(id);
        return Result.successResult(getPersonDepBean(personDep));
    }

    @PostMapping("/listBatch")
    public Result<List<PersonDepBean>> listBatch(@RequestBody List<String> ids) {
        List<PersonDep> list = personDepService.list(Wrappers.<PersonDep>lambdaQuery().in(PersonDep::getId,ids));
        List<PersonDepBean> personDepBeans = new ArrayList<>();
        list.forEach(personDep -> personDepBeans.add(getPersonDepBean(personDep)));
        return Result.successResult(personDepBeans);
    }

    private PersonDepBean getPersonDepBean(PersonDep personDep) {
        PersonDepBean personDepBean = new PersonDepBean();
        BeanUtils.copyProperties(personDep, personDepBean);
        Person person = personService.getById(personDep.getPersonId());
        Org org = orgService.getById(personDep.getOrgId());
        personDepBean.setPerson(person);
        personDepBean.setOrg(org);
        return personDepBean;
    }
}

