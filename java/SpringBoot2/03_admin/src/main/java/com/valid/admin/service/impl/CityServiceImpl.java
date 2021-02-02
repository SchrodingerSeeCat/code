package com.valid.admin.service.impl;

import com.valid.admin.bean.City;
import com.valid.admin.mapper.CityMapper;
import com.valid.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;
    Counter counter;
    public CityServiceImpl(MeterRegistry meterRegistry) {
        // 注册指标
        counter = meterRegistry.counter("cityService");
    }

    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    public void insertCity(City city) {
        cityMapper.insertCity(city);
        counter.increment();
    }
}
