package com.xdja.bdp.base.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xdja.bdp.base.domain.Org;
import com.xdja.bdp.base.domain.Person;
import com.xdja.bdp.base.domain.PersonDep;
import com.xdja.bdp.base.service.IOrgService;
import com.xdja.bdp.base.service.IPersonDepService;
import com.xdja.bdp.common.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RequestMapping("/org")
@RefreshScope
public class OrgController {

    @Autowired
    private IOrgService orgService;
    @Autowired
    private IPersonDepService personDepService;

    @Value("${base-service.username}")
    private String username;

    @Value("${base-service.password}")
    private String password;


    @PostMapping("/add")
    public Result add(@RequestBody Org org) {
        org.setLastUpdateTime(System.currentTimeMillis());
        orgService.save(org);
        return Result.successResult();
    }

    @GetMapping("/list")
    public Result<List<Org>> list() {
        List<Org> orgList = orgService.list();
        return Result.successResult(orgList);
    }

    @GetMapping("/delete")
    public Result delete(@RequestParam("id") String id) {
        Org org = orgService.getById(id);
        if (org != null) {
            List<PersonDep> list = personDepService.list(Wrappers.<PersonDep>lambdaQuery().eq(PersonDep::getOrgId, id));
            if (CollectionUtils.isEmpty(list)) {
                orgService.removeById(id);
            } else {
                return  Result.failResult("删除失败，该单位下已有账户，请删除账户后再操作");
            }
        }
        return Result.successResult();
    }


    @GetMapping("/getConfig")
    public Result getConfig() {
        return Result.successResult(username + password);
    }
}

