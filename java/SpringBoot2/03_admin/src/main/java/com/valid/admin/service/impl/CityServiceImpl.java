package com.valid.admin.service.impl;

import com.valid.admin.bean.City;
import com.valid.admin.mapper.CityMapper;
import com.valid.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    public void insertCity(City city) {
        cityMapper.insertCity(city);
    }
}
