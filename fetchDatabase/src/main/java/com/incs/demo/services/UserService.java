package com.incs.demo.services;

import com.incs.demo.entities.Users;
import com.incs.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    static List<Users> userList = new ArrayList<Users>();
    Map<String, Object> responseMap = new HashMap<>();
    RandomString randomString = new RandomString();

    public String createUsers() {
        for (int i = 1; i <= 10; i++) {
            Users user = new Users();
            user.setUserName(randomString.generateRandomString());
            user.setUserEmail(randomString.generateRandomString() + "@gmail.com");
            user.setUserRole("HR");
            userList.add(user);
        }

        for (int i = 1; i <= 10; i++) {
            Users user = new Users();
            user.setUserName(randomString.generateRandomString());
            user.setUserEmail(randomString.generateRandomString() + "@hotmail.com");
            user.setUserRole("SALES");
            userList.add(user);
        }
        for (int i = 1; i <= 10; i++) {
            Users user = new Users();
            user.setUserName(randomString.generateRandomString());
            user.setUserEmail(randomString.generateRandomString() + "@ymail.com");
            user.setUserRole("DEVELOPMENT");
            userList.add(user);
        }
        userRepository.save(userList);
        return "30 records are saved";
    }


    public @ResponseBody
    Page<Users> displayUsers(Pageable pageable) {

        return userRepository.findAll(pageable);
    }


    public Iterable<Users> displayUsers(int max, int offset) {
        List<Users> u = new ArrayList<>();

        for (long id = offset; id <= max; id++) {


            Users user = userRepository.findOne(id);

            u.add(user);
        }
        return u;

    }

    public @ResponseBody
    Page<Users> displayUsers1(String userEmail, Pageable pageable) {

        Page<Users> emailList = userRepository.findUsersByUserEmailEndingWith(userEmail, pageable);


        return emailList;
    }


}
