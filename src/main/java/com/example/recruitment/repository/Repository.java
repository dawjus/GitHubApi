package com.example.recruitment.repository;

import com.example.recruitment.branch.Branch;
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
    private String commitSha;
    private Boolean fork;
    private String body;
    private List<Branch> branches;

    public void addBranch(Branch branch){
        branches.add(branch);
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repoName='" + repoName + '\'' +
                ", commitSha='" + commitSha + '\'' +
                ", branches=" + branches.toString() +
                '}';
    }
}
