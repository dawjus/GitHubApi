package com.example.recruitment.branch;

import lombok.Builder;

@Builder
public record Branch(String branchName, String lastCommitSha) {

}