package com.Sean.service;

import com.Sean.pojo.Tab;

import java.util.List;

import org.springframework.stereotype.Service;
public interface TabService {
    List<Tab> getAllTabs();

    Tab getByTabNameEn(String tabName);
}
