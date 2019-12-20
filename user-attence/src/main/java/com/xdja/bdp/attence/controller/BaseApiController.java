package com.xdja.bdp.attence.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xdja.bdp.attence.baseapi.BaseApiService;
import com.xdja.bdp.attence.bean.Org;
import com.xdja.bdp.attence.bean.Person;
import com.xdja.bdp.attence.bean.PersonDep;
import com.xdja.bdp.attence.bean.PersonDepBean;
import com.xdja.bdp.attence.domain.Attence;
import com.xdja.bdp.attence.service.IAttenceService;
import com.xdja.bdp.common.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yxb
 * @since 2019/12/18
 */
@RestController
public class BaseApiController {

    @Autowired
    private BaseApiService baseApiService;
    @Autowired
    private IAttenceService attenceService;

    @GetMapping("/person/list")
    public Result<List<Person>> listPerson() {
        return baseApiService.listPerson();
    }

    @PostMapping("/person/add")
    public Result addPerson(@RequestBody Person person) {
        return baseApiService.addPerson(person);
    }

    @GetMapping("/person/delete")
    public Result deletePerson(@RequestParam("id") String id){
        return baseApiService.deletePerson(id);
    }

    @GetMapping("/org/list")
    public Result<List<Org>> listOrg() {
        return baseApiService.listOrg();
    }

    @PostMapping("/org/add")
    public Result addOrg(@RequestBody Org org) {
        return baseApiService.addOrg(org);
    }

    @GetMapping("/org/delete")
    public Result deleteOrg(@RequestParam("id") String id) {
        return baseApiService.deleteOrg(id);
    }

    @GetMapping("/personDep/list")
    public Result<List<PersonDepBean>> listPersonDep() {
        return baseApiService.listPersonDep();
    }

    @PostMapping("/personDep/add")
    public Result addPersonOrg(@RequestBody PersonDep personDep) {
        return baseApiService.addPersonOrg(personDep);
    }

    @GetMapping("/personDep/delete")
    public Result deletePersonOrg(@RequestParam("id") String id){
        attenceService.remove(Wrappers.<Attence>lambdaQuery().eq(Attence::getAccountId,id));
        return baseApiService.deletePersonOrg(id);
    }
}
