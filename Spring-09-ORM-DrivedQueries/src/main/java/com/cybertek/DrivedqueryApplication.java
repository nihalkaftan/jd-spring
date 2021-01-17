package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import com.cybertek.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class DrivedqueryApplication {

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DrivedqueryApplication.class, args);
    }

    @PostConstruct
    public void testRegions(){

        System.out.println("----------Region Start----------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));

        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));

        System.out.println("findByCountryContaining: " + regionRepository.findByCountryContaining("United"));

        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("United"));

        System.out.println("findTop2ByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("----------Region End----------");

        System.out.println();

    }

    @PostConstruct
    public void testDepartment(){

        System.out.println("----------Department Start----------");

        System.out.println("findByDepartment: " +departmentRepository.findByDepartment("Toys"));

        System.out.println("findByDivision: " +departmentRepository.findByDivision("Outdoors"));

        System.out.println("findByDivisionIs: " +departmentRepository.findByDivisionIs("Health"));

        System.out.println("findByDivisionEndingWith: " +departmentRepository.findByDivisionEndingWith("ics"));

        System.out.println("findByDivisionEquals: " +departmentRepository.findByDivisionEquals("Health"));

        System.out.println("findDistinctTop3ByByDivisionContains: " +departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("----------Department End----------");

    }

    @PostConstruct
    public void testEmployee(){

        System.out.println("----------Employee Start----------");

        System.out.println("findByEmail: " +employeeRepository.findByEmail("bmanueau0@dion.ne.jp"));

        System.out.println("findByEmailIsNull: " +employeeRepository.findByEmailIsNull());

        System.out.println("findByFirstNameAndLastNameOrEmail: " +employeeRepository.findByFirstNameAndLastNameOrEmail("Sydney","Symonds","ssymonds2@hhs.gov"));

        System.out.println("findByFirstNameIsNot: " +employeeRepository.findByFirstNameIsNot("Jodi"));

        System.out.println("findByLastNameStartsWith: " +employeeRepository.findByLastNameStartsWith("Cha"));

        System.out.println("findBySalaryGreaterThan: " +employeeRepository.findBySalaryGreaterThan(100000));

        System.out.println("findDistinctTop3BySalaryLessThanEqual: " +employeeRepository.findDistinctTop3BySalaryLessThanEqual(90000));

        System.out.println("findByHireDateBetween: " +employeeRepository.findByHireDateBetween(LocalDate.of(2006,02,19),LocalDate.of(2007,02,01)));

        System.out.println("findBySalaryGreaterThanEqualOrderBySalaryDesc: " +employeeRepository.findBySalaryGreaterThanEqualOrderBySalaryDesc(150000));

        System.out.println("----------Employee End----------");

    }

}
