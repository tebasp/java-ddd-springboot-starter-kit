package com.wgdesign.gradle_test.dashboard.controllers.users;

import com.wgdesign.dashboard.users.application.find.UserFinder;
import com.wgdesign.dashboard.users.domain.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGetController {

    private final UserFinder userFinder;

    public UserGetController(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> index(@PathVariable Integer id) {
        User user = userFinder.find(id);
        return ResponseEntity.ok(user);
    }
}
