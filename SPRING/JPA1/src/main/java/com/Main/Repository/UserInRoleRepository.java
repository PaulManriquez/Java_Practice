package com.Main.Repository;

import com.Main.Entitys.UserInRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInRoleRepository extends CrudRepository<UserInRole,Integer> {
}
