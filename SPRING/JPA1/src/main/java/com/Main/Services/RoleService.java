package com.Main.Services;

import com.Main.Entitys.Role;
import com.Main.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role createRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRole(Integer roleId,Role role){
        Optional <Role> optRol= roleRepository.findById(roleId);
        if(optRol.isPresent()){
            Role rol =  optRol.get();
            rol.setName(role.getName());
            return roleRepository.save(rol);
        }else{
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,
                            String.format("Role with %d id, do not exist",roleId));
        }
    }

    public void deleteRole(Integer roleId){
        Optional<Role> optRol = roleRepository.findById(roleId);
        if(optRol.isPresent()){
            roleRepository.deleteById(roleId);
        }else{
            throw new ResponseStatusException
                    (HttpStatus.NOT_FOUND,
                            String.format("The role with the ID %d do not exist",roleId));
        }
    }

}
