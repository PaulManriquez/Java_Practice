package com.Main.Services;

import com.Main.Entitys.Role;
import com.Main.Entitys.User;
import com.Main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    //Return all the users in the repo
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    //Return the user found by id
    public User getUserByID(Integer id){
        return userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The user with id:%d do not exist",id))
        );
    }

    public User UsergetByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The user with name %s do not exist",username))
        );
    }

    public User UsergetByUsernameAndPassword(String username,String password){
        return userRepository.findByUsernameAndPassword(username,password).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("The user with name %s and pss:%s do not exist",username,password))
        );
    }

    //Paginate enable to return rows by section , reducing the time of retrieval
    //because gets the rows by sections
    public Page<User> getUsersPaginate(int page, int size){
        return userRepository.findAll(PageRequest.of(page,size));
    }

    public List<String> getAllUserNames(){
        return  userRepository.getAllUsernames();
    }

    //Get a Paginate of users
    public Page<String> getUsersNamesPaginate(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.getAllUsernamesPageable(pageable);
    }

}
