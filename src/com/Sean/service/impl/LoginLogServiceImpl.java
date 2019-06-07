package com.Sean.service.impl;

import com.Sean.mapper.LoginLogMapper;
import com.Sean.pojo.LoginLog;
import com.Sean.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    public LoginLogMapper LoginLogMapper;

    public boolean addLog(LoginLog log) {

        if(LoginLogMapper.insert(log)>0){
            return true;
        }else {
            return false;
        }
    }
}
