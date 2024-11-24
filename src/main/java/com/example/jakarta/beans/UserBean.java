package com.example.jakarta.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import com.example.jakarta.entities.User;
import com.example.jakarta.services.UserService;
import java.util.List;

@Named
@RequestScoped
public class UserBean {
    private User user = new User();
    private List<User> users;
    private List<String> usersWithSubstring;
    private List<String> userInfoList;
    private String substring;

    private final UserService userService;

    public UserBean() {
        this.userService = new UserService();
        loadUsers();
    }

    public void loadUsers() {
        users = userService.findAllUsers(10);
    }

    public String createUser() {
        userService.createUser(user);
        loadUsers();
        user = new User();
        return "users";
    }

    public String editUser(Long id) {
        user = userService.findById(id);
        return "changeUserData";
    }

    public String updateUser() {
        if (user.getId() != null) {
            userService.updateUser(user);
        }
        loadUsers();
        user = new User();
        return "users";
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
        loadUsers();
    }

    public void searchUsersWithSubstring() {
        usersWithSubstring = userService.findUsersWithSubstringInName(substring);
    }

    public void loadUserFullNamesAndEmailLength() {
        userInfoList = userService.findUserFullNamesAndEmailLength();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUserCount() {
        return users != null ? users.size() : 0;
    }

    public List<String> getUsersWithSubstring() {
        return usersWithSubstring;
    }

    public List<String> getUserInfoList() {
        return userInfoList;
    }

    public String getSubstring() {
        return substring;
    }

    public void setSubstring(String substring) {
        this.substring = substring;
    }
}