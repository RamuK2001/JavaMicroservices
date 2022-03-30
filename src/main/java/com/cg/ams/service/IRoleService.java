package com.cg.ams.service;

import com.cg.ams.entity.RoleEntity;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IRoleService {

    String addRole(RoleEntity role);

    RoleEntity deleteRole(RoleEntity role);

    RoleEntity deleteRoleById(long id);

    RoleEntity deleteRoleByName(String name);

    RoleEntity updateRole(RoleEntity role);

    RoleEntity updateRoleNameById(long id, String name);

    List<RoleEntity> getAllRoles();

    RoleEntity getRoleById(long id);

    RoleEntity getRoleByName(String name);
    
    Page<RoleEntity> getAllRolesWithPagination(int offset, int pageSize);
}
