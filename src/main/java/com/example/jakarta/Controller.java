package com.example.jakarta;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class Controller implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private DataContainer dataContainer = new DataContainer();

    @NotBlank(message = "First name cannot be empty")
    public String getFirstName() {
        return firstName;
    }

    @NotBlank(message = "Last name cannot be empty")
    public String getLastName() {
        return lastName;
    }

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid email format")
    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void submitButtonPressed() {
        UserData newUser = new UserData(firstName, lastName, email);
        dataContainer.addData(newUser);

        firstName = "";
        lastName = "";
        email = "";
    }

    public List<UserData> getDataList() {
        return dataContainer.getDataList();
    }
}


