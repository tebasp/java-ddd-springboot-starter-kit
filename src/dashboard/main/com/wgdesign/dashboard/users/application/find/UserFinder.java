package com.wgdesign.dashboard.users.application.find;

import com.wgdesign.dashboard.users.domain.entity.User;
import com.wgdesign.dashboard.users.domain.exception.UsersException;
import com.wgdesign.dashboard.users.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserFinder {
    private final UserRepository jpaUserRepository;

    public UserFinder(UserRepository repository) {
        jpaUserRepository = repository;
    }

    public User find(Integer id)  {
        try {
            User user = jpaUserRepository.getById(id);

            if (user == null) {
                throw new UsersException("User not found");
            }

            return user;
        } catch (UsersException e ) {
            System.out.println(e.getMessage());
            throw new UsersException("Error on UserFinder: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error on UserFinder: " + e.getMessage());
        }
    }
}

