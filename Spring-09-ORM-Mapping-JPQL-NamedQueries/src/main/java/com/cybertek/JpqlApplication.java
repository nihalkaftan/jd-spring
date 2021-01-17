package com.cybertek;

import com.cybertek.repository.DepartmentRepository;
import com.cybertek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpqlApplication {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpqlApplication.class, args);
    }

    @PostConstruct
    public void testEmployee(){
        System.out.println("employeeRepository.getEmployeeDetail() = " + employeeRepository.getEmployeeDetail());
        System.out.println("employeeRepository.getEmployeeSalary() = " + employeeRepository.getEmployeeSalary());
        System.out.println("employeeRepository.getEmployeeByEmail(\"bhendricksi@privacy.gov.au\") = " + employeeRepository.getEmployeeByEmail("bhendricksi@privacy.gov.au"));

        employeeRepository.updateEmployeeJPQL(1);

        System.out.println(employeeRepository.retrieveEmployeeSalaryGreaterThan(100000));

        System.out.println(departmentRepository.findOzzyDepartment("Kids"));

        System.out.println(departmentRepository.countAllDepartments());

    }

}
