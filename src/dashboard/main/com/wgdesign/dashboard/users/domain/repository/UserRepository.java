package com.wgdesign.dashboard.users.domain.repository;

import com.wgdesign.dashboard.users.domain.entity.User;

import java.util.Optional;

public interface UserRepository
{
    Optional<User> getById(int id);
}
