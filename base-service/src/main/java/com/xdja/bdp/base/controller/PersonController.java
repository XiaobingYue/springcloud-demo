package com.xdja.bdp.base.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xdja.bdp.base.domain.Person;
import com.xdja.bdp.base.domain.PersonDep;
import com.xdja.bdp.base.service.IPersonDepService;
import com.xdja.bdp.base.service.IPersonService;
import com.xdja.bdp.common.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/person")
@Slf4j
public class PersonController {
    @Autowired
    private IPersonService personService;
    @Autowired
    private IPersonDepService personDepService;

    @PostMapping("/add")
    public Result add(@RequestBody Person person) {
        person.setLastUpdateTime(System.currentTimeMillis());
        personService.save(person);
        return Result.successResult();
    }

    @GetMapping("/list")
    public Result<List<Person>> list() {
        List<Person> personList = personService.list();
        return Result.successResult(personList);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("id") String id) {
        Person person = personService.getById(id);
        if (person != null) {
            List<PersonDep> list = personDepService.list(Wrappers.<PersonDep>lambdaQuery().eq(PersonDep::getPersonId, id));
            if (CollectionUtils.isEmpty(list)) {
                personService.removeById(id);
            } else {
                return  Result.failResult("删除失败，该人员已生成账户，请删除账户后再操作");
            }
        }
        return Result.successResult();
    }
}

