package com.wgdesign.dashboard.users.domain.repository;

import com.wgdesign.dashboard.users.domain.entity.User;

public interface UserRepository
{
    User getById(int id);
}
