package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Nation;
import com.braisedpanda.shirotest.mapper.NationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NationServiceImpl implements NationService{

    @Autowired
    NationMapper nationMapper;

    @Override
    public Nation getNationById(String nation_id) {
        Nation nation = nationMapper.getNationById(nation_id);
        return nation;
    }
    //查询所有的nation
    @Override
    public List<Nation> getAllNation() {
           List<Nation> nationList = nationMapper.getAllNation();
           return nationList;
    }
}
