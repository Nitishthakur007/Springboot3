package com.example.project.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ApplicationUser {
    @Id
    public String user_name;
    public String user_email;
    public String password;
    public String user_mobile;
    public String location;

    public ApplicationUser(String user_name, String user_email, String password, String user_mobile, String location) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.password = password;
        this.user_mobile = user_mobile;
        this.location = location;
    }

    public ApplicationUser() {
    }

    public ApplicationUser(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    //    public Date user_dob;

}
