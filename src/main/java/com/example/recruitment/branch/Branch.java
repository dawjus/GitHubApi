package com.example.recruitment.branch;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Branch {
    private String branchName;
    private String lastCommitSha;

    @Override
    public String toString() {
        return "Branch{\n"  +
                "\nbranchName='" + branchName +
                ",\nlastCommitSha='" + lastCommitSha +
                '}';
    }

}
