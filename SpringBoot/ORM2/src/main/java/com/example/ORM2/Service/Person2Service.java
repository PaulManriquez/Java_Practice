package com.example.ORM2.Service;

import com.example.ORM2.Model.Person2;
import com.example.ORM2.Model.Post;
import com.example.ORM2.Repository.Person2Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Person2Service {

    @Autowired
    private Person2Repository repoPerson2;

    @Transactional
    public void setAPostToAUser(int id) {
        Optional<Person2> optional = repoPerson2.findById(id);
        if (optional.isPresent()) {
            Person2 p2 = optional.get();

            Post post = new Post();
            post.setTitle("Title1");
            post.setContent("Content1");

            p2.savePost(post);
            repoPerson2.save(p2);
        }
    }

    @Transactional
    public void displayPersonWithPostRelated(){
        List<Person2> personList = repoPerson2.findAll();
        for(Person2 ptrP2: personList){
            System.out.println(ptrP2.getName() + ptrP2.getAge());
            List<Post> postOfThisUser = ptrP2.getListOfPost();
            System.out.println("Posts:");
            for(Post ptrPost: postOfThisUser){
                System.out.println(ptrPost.getTitle() +" ID:" + ptrPost.getPerson2().getId());
            }
            System.out.println("================");
        }
    }

}
