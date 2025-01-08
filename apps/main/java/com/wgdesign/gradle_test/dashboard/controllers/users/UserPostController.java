package com.wgdesign.gradle_test.dashboard.controllers.users;

import com.wgdesign.dashboard.users.application.create.UserCreator;
import com.wgdesign.dashboard.users.domain.dto.UserCreateDto;
import com.wgdesign.dashboard.users.domain.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserPostController {
    private final UserCreator creator;

    public UserPostController(UserCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/users")
    public ResponseEntity<User> handle(@Valid @RequestBody UserCreateDto userDto) {
        creator.create(userDto.getName(), userDto.getBirthDate());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
