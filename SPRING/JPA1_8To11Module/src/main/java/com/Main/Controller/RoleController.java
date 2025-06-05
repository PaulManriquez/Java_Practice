package com.Main.Controller;

import com.Main.Entitys.Role;
import com.Main.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController{

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> roles(){
        return new ResponseEntity<List<Role>>(roleService.getAllRoles(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Role> createRoles(@RequestBody Role role){
        return new ResponseEntity<Role>(roleService.createRole(role),HttpStatus.CREATED);
    }


    @PutMapping("/{roleId}")
    public ResponseEntity<Role> updateRole(
            @PathVariable("roleId") Integer roleId,
            @RequestBody Role role) {

        return new ResponseEntity<Role>(
                roleService.updateRole(roleId, role),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> deleteRole
            (@PathVariable("roleId")Integer roleId){
        roleService.deleteRole(roleId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}