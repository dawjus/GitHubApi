package com.example.recruitment.user;

import com.example.recruitment.repository.Repository;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {

    private String userName;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", reposWithoutFork=" + reposWithoutFork.toString() +
                '}';
    }

    private String body;
    private List<Repository> repos = new ArrayList<>();
    private List<Repository> reposWithoutFork =new ArrayList<>();

    public User (String userName){
        this.userName = userName;
    }

    public void addRepo(Repository repo){
        repos.add(repo);
    }

    public void addRepoWithoutFork(Repository repo){
        reposWithoutFork.add(repo);
    }
}
