package com.example.recruitment.repository;

import com.example.recruitment.branch.Branch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class Repository {
    private String repoName;
    private List<Branch> branches;
    @JsonIgnore
    private Boolean fork;
    @JsonIgnore
    private String body;

    public void addBranch(Branch branch){
        branches.add(branch);
    }

    @Override
    public String toString() {
        return "Repository{\n" +
                "\nrepoName='" + repoName +
                ",\nbranches=" + branches.toString() +
                '}';
    }
}
