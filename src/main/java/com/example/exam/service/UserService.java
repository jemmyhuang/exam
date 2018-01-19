package com.example.exam.service;

import com.example.exam.annotation.BusinessAccess;
import com.example.exam.domain.User;

public interface UserService {


    User queryUserByName(String username, String password);
}
