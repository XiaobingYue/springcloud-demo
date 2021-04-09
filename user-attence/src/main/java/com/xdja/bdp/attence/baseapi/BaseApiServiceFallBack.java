package com.xdja.bdp.attence.baseapi;

import com.xdja.bdp.attence.bean.Org;
import com.xdja.bdp.attence.bean.Person;
import com.xdja.bdp.attence.bean.PersonDep;
import com.xdja.bdp.attence.bean.PersonDepBean;
import com.xdja.bdp.common.bean.Result;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author yxb
 * @since 2021.4.9
 */

@Component
public class BaseApiServiceFallBack implements BaseApiService {
    @Override
    public Result<List<Person>> listPerson() {
        return Result.failResult("fallBack");
    }

    @Override
    public Result addPerson(Person person) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result deletePerson(String id) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result<List<Org>> listOrg() {
        return Result.failResult("fallBack");
    }

    @Override
    public Result addOrg(Org org) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result deleteOrg(String id) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result<List<PersonDepBean>> listPersonDep() {
        return Result.failResult("fallBack");
    }

    @Override
    public Result<List<PersonDepBean>> listPersonDepBatch(Set<String> ids) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result addPersonOrg(PersonDep personDep) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result deletePersonOrg(String id) {
        return Result.failResult("fallBack");
    }

    @Override
    public Result<PersonDepBean> personDepDetail(String id) {
        return Result.failResult("fallBack");
    }
}
