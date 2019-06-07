package com.Sean.service;

import org.springframework.stereotype.Service;

import com.Sean.pojo.LoginLog;
public interface LoginLogService {

    boolean addLog(LoginLog log);
}
