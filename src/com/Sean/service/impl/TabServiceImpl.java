package com.Sean.service.impl;

import com.Sean.mapper.TabMapper;
import com.Sean.pojo.Tab;
import com.Sean.service.TabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TabServiceImpl implements TabService {

    @Autowired
    public TabMapper TabMapper;

    public List<Tab> getAllTabs() {
        return TabMapper.getAllTabs();
    }

    public Tab getByTabNameEn(String tabNameEn) {
        return TabMapper.getByTabNameEn(tabNameEn);
    }
}
