package com.nisaxap.springapp.repository;

import com.nisaxap.springapp.dto.EmployeeFilter;
import com.nisaxap.springapp.entity.EmployeeEntity;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

import static com.nisaxap.springapp.entity.QEmployeeEntity.employeeEntity;

@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeCustomRepository {

    private final EntityManager entityManager;

    @Override
    public List<EmployeeEntity> findByFilter(EmployeeFilter filter) {
        return new JPAQuery<EmployeeEntity>(entityManager)
                .select(employeeEntity)
                .from(employeeEntity)
                .where(employeeEntity.firstName.containsIgnoreCase(filter.getFirstName()))
                .fetch();
    }
}
