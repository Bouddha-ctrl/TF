package com.ufr.croissantshow.test.unitaire;

import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IRoleService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RoleServiceImpTest {

    @Autowired
    private IRoleService roleS;

    @Test
    void testAddRole() {
        Role role = Role.builder()
                .roleName("ROLE_UNIT_TEST")
                .build();

        roleS.addRole(role);

        List<Role> roles = roleS.getAllRoles();
        Role roleFound = null;

        for (Role r: roles) {
            if(r != null && r.getRoleName().equals(role.getRoleName())){
                roleFound = r;
                break;
            }
        }
        Assert.assertEquals(roleFound.getRoleName(), role.getRoleName());
    }
}