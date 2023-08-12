package com.nitish.springboot.MVC_CRUD.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "EEID")
    private String empId;

    @Column(name = "Full Name")
    private String fullName;

    @Column(name = "Job Title")
    private String jobTitle;

    @Column(name = "Department")
    private String department;

    @Column(name = "Business Unit")
    private String businessUnit;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Ethnicity")
    private String ethnicity;

    @Column(name = "Age")
    private int age;

    @Column(name = "Hire Date")
    private String hireDate;

    @Column(name = "Annual Salary")
    private String annualSalary;

    @Column(name = "Bonus %")
    private String bonusPer;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    @Column(name = "Exit Date")
    private String exitDate;

    public Employee() {
    }

    public Employee(String empId, String fullName, String jobTitle, String department) {
        this.empId = empId;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public Employee(String empId, String fullName, String jobTitle, String department,
                    String businessUnit, String gender, String ethnicity, int age, String hireDate,
                    String annualSalary, String bonusPer, String country, String city, String exitDate) {
        this.empId = empId;
        this.fullName = fullName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.businessUnit = businessUnit;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.age = age;
        this.hireDate = hireDate;
        this.annualSalary = annualSalary;
        this.bonusPer = bonusPer;
        this.country = country;
        this.city = city;
        this.exitDate = exitDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(String annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String getBonusPer() {
        return bonusPer;
    }

    public void setBonusPer(String bonusPer) {
        this.bonusPer = bonusPer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", age=" + age +
                ", hireDate='" + hireDate + '\'' +
                ", annualSalary='" + annualSalary + '\'' +
                ", bonusPer='" + bonusPer + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", exitDate='" + exitDate + '\'' +
                '}';
    }
}
