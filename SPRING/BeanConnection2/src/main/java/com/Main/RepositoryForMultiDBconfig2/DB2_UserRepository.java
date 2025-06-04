package com.Main.RepositoryForMultiDBconfig2;

import com.Main.EntitysDB2.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DB2_UserRepository extends JpaRepository<User,Integer> {
}
