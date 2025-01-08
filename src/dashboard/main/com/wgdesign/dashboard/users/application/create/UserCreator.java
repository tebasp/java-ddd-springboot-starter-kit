package com.wgdesign.dashboard.users.application.create;

import com.wgdesign.dashboard.users.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserCreator {
    public void create(String name, Date birthDate) {
       User user = User.create(name, birthDate);
    }
}
