package com.Main.Repository;

import com.Main.Entitys.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByUsername(String username);

    //findBy → this starts the query.
    //UsernameAndPassword → this refers to fields in the User entity.
    //It expects parameters in the same order: username, then password
    public Optional<User> findByUsernameAndPassword(String username,String password);


    @Query("SELECT u.username FROM User as u")
    public List<String> getAllUsernames();

    @Query("SELECT u.username FROM User u")
    Page<String> getAllUsernamesPageable(Pageable pageable);
}
