package com.nisaxap.springapp.repository;

import com.nisaxap.springapp.dto.EmployeeFilter;
import com.nisaxap.springapp.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeCustomRepository {

    List<EmployeeEntity> findByFilter(EmployeeFilter filter);
}