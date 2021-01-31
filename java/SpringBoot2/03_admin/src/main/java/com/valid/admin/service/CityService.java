package com.valid.admin.service;

import com.valid.admin.bean.City;

public interface CityService {
    City getCityById(Long id);
    void insertCity(City city);
}
