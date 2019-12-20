package com.xdja.bdp.base.bean;

import com.xdja.bdp.base.domain.Org;
import com.xdja.bdp.base.domain.Person;
import com.xdja.bdp.base.domain.PersonDep;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yxb
 * @since 2019/12/18
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDepBean extends PersonDep {

    private Person person;

    private Org org;

}
