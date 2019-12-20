package com.xdja.bdp.attence.bean;

import com.xdja.bdp.attence.domain.Attence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private List<Attence> attenceList;

}
