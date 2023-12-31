package com.nisaxap.springapp.repository;

import com.nisaxap.springapp.entity.EmployeeEntity;
import com.nisaxap.springapp.projection.EmployeeNameView;
import com.nisaxap.springapp.projection.EmployeeNativeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, EmployeeCustomRepository,
        QuerydslPredicateExecutor<EmployeeEntity> {

    Optional<EmployeeEntity> findByFirstNameContaining(String firstName);

    //    @Query("select e from EmployeeEntity e where e.firstName = :name and e.salary = :salary")
    @Query(value = "select e.* from employee e where e.first_name = :name and e.salary = :salary",
            nativeQuery = true)
    List<EmployeeEntity> findAllByFirstNameAndSalary(@Param("name") String firstName, @Param("salary") Integer salary);

    List<EmployeeNameView> findAllBySalaryGreaterThan(Integer salary);

    @Query(value = "select " +
            "e.id as id, " +
            "e.first_name || e.last_name as fullName " +
            "from employee e " +
            "where e.salary > :salary", nativeQuery = true)
    List<EmployeeNativeView> findAllBySalaryGreaterThanNative(@Param("salary") Integer salary);
}
