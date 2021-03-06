package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //display all employees with email address
    List<Employee> findByEmail(String email);

    //display all employees with first name "" and last name "" also show all employees with email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salaries higher than ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salaries less than ""
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    //Display all employees that has been hired between 2010,6,1 and 2013,12,30
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //display all employees where salaries greater and equal to "" in order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThanEqual(Integer salary);

    //display all employees that do not have email address
    List<Employee> findByEmailIsNull();


}
