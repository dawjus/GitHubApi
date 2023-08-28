package com.example.recruitment.user;

import com.example.recruitment.repository.Repository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class User {

    private String userName;

    @JsonIgnore
    private String body;
    @JsonIgnore
    private List<Repository> repos = new ArrayList<>();
    @JsonProperty("repositiories")
    private List<Repository> reposWithoutFork = new ArrayList<>();

    public User (String userName){
        this.userName = userName;
    }

    public void addRepo(Repository repo){
        repos.add(repo);
    }

    public void addRepoWithoutFork(Repository repo){
        reposWithoutFork.add(repo);
    }

    @Override
    public String toString() {
        return "User{" +
                "\nuserName='" + userName +
                ",\nreposWithoutFork=" + reposWithoutFork.toString() +
                '}';
    }
}
