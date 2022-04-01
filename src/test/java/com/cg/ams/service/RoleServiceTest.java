package com.cg.ams.service;

import com.cg.ams.entity.RoleEntity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Disabled
class RoleServiceTest {

    @Autowired
    IRoleService roleServ;

    // Add Role Entity
    @Test
    void addTest() {
        RoleEntity role = new RoleEntity(15, "HOD", "Head of Department");
        String s = roleServ.addRole(role);
        assertEquals("Role Added Successfully", s);
    }

    // Update Role Entity
    @Test
    void updateRoleTest() {
        RoleEntity role = new RoleEntity(4, "PRINCIPAL", "Pricipal of Organization");
        RoleEntity result = roleServ.updateRole(role);
        assertEquals("Pricipal of Organization", result.getDescription());
    }

    // Update Role Name By Id
    @Test
    void updateNameByIdTest() {
        RoleEntity role = roleServ.updateRoleNameById(15, "Mounish");
        assertEquals("Head of Department", role.getDescription());
    }

    // Delete Role Entity
	@Test
	void deleteRole() {
		RoleEntity role=new RoleEntity(15,"Mounish","Head of Department");
		RoleEntity result=roleServ.deleteRole(role);
		assertEquals("Mounish",result.getName());
		//assertEquals("Python ia a Programming Language",result.getDescription());
		
	}

	// Get Role Entity By Name
    @Test
    void getByNameTest() {
        RoleEntity role = roleServ.getRoleByName("HOD");
        assertEquals(15, role.getId());
    }

    // Get Role Entity By Id
    @Test
    void getByIdTest() {
        RoleEntity role = roleServ.getRoleById(15);
        assertEquals("HOD", role.getName());
    }

    // Delete Role Entity By Name
    @Test
    @Disabled
    void deleteByNameTest() {
        RoleEntity course = roleServ.deleteRoleByName("PRINCIPAL");
        assertEquals(4, course.getId());
    }

    // Delete Role Entity By Id
    @Test
    @Disabled
    void deleteById() {
        RoleEntity role = roleServ.deleteRoleById(103);
        assertEquals("HTML", role.getName());
    }

    // List All Roles
    @Test
    void getAllRolesTest() {
        List<RoleEntity> roleList = roleServ.getAllRoles();
        assertEquals(5, roleList.size());
    }


}
