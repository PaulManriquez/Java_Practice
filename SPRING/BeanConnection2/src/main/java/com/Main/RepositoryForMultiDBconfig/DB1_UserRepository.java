package com.Main.RepositoryForMultiDBconfig;

import com.Main.EntitysDB1.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DB1_UserRepository extends JpaRepository<User,Integer> {
}
