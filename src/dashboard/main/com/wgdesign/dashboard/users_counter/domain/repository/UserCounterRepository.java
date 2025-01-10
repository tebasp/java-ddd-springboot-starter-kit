package com.wgdesign.dashboard.users_counter.domain.repository;

import com.wgdesign.dashboard.users_counter.domain.entity.UserCounter;

import java.util.Optional;

public interface UserCounterRepository {

    Integer count();

    void save(UserCounter userCounter);

    void update(UserCounter userCounter);

    Optional<UserCounter> findById(Integer id);
}
