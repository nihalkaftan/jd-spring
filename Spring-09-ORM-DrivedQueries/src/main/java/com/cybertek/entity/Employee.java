package com.cybertek.entity;

import com.cybertek.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employees")
@ToString
public class Employee extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
