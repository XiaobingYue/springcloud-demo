package com.xdja.bdp.attence.baseapi;

import com.xdja.bdp.attence.bean.Org;
import com.xdja.bdp.attence.bean.Person;
import com.xdja.bdp.attence.bean.PersonDep;
import com.xdja.bdp.attence.bean.PersonDepBean;
import com.xdja.bdp.common.bean.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author yxb
 * @since 2019/12/17
 */
@FeignClient(value = "base-service",
        configuration = FeignClientsConfiguration.class,
        fallback = BaseApiServiceFallBack.class)
public interface BaseApiService {

    @GetMapping("/person/list")
    Result<List<Person>> listPerson();

    @PostMapping("/person/add")
    Result addPerson(@RequestBody Person person);

    @GetMapping("/person/delete")
    Result deletePerson(@RequestParam("id") String id);

    @GetMapping("/org/list")
    Result<List<Org>> listOrg();

    @PostMapping("/org/add")
    Result addOrg(@RequestBody Org org);

    @GetMapping("/org/delete")
    Result deleteOrg(@RequestParam("id") String id);

    @GetMapping("/personDep/list")
    Result<List<PersonDepBean>> listPersonDep();

    @PostMapping("/personDep/listBatch")
    Result<List<PersonDepBean>> listPersonDepBatch(@RequestBody Set<String> ids);

    @PostMapping("/personDep/add")
    Result addPersonOrg(@RequestBody PersonDep personDep);

    @GetMapping("/personDep/delete")
    Result deletePersonOrg(@RequestParam("id") String id);

    @GetMapping("/personDep/detail")
    Result<PersonDepBean> personDepDetail(@RequestParam("id") String id);
}
