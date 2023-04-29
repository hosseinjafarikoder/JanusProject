package com.example.janustextsample.ajaxTextPack;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private List<Users> users;

    // Love Java 8
    public List<Users> findByUserNameOrEmail(String username) {

        List<Users> result = users.stream()
                .filter(x -> x.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());

        return result;

    }

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<Users>();

        Users user1 = new Users("mkyong", "password111", "mkyong@yahoo.com");
        Users user2 = new Users("yflow", "password222", "yflow@yahoo.com");
        Users user3 = new Users("laplap", "password333", "mkyong@yahoo.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }

}
