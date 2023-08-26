package com.example.recruitment.branch;

import lombok.Builder;

@Builder
public class Branch {
    private String branchName;
    private String lastCommitSha;

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", lastCommitSha='" + lastCommitSha + '\'' +
                '}';
    }

}
