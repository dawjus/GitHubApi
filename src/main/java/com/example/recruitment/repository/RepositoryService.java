package com.example.recruitment.repository;

import com.example.recruitment.branch.Branch;
import com.example.recruitment.user.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RepositoryService {

    private final RestTemplate restTemplate;

    @Autowired
    public RepositoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void findBranches( User user){
        List<Repository> repositories = user.getReposWithoutFork();
        String userName = user.getUserName();
        for (Repository repo: repositories){
            String url = "https://api.github.com/repos/" + userName +"/" +
                    repo.getRepoName() +"/branches";

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            repo.setBody(response.getBody());
            addBranches(repo);
        }
    }

    public void addBranches(Repository repo){
        JSONArray jsonArray = new JSONArray(repo.getBody());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject branch = jsonArray.getJSONObject(i);
            String branchName = branch.getString("name");
            JSONObject commit = branch.getJSONObject("commit");
            String sha = commit.getString("sha");
            Branch newBranch = Branch.builder()
                    .branchName(branchName)
                    .lastCommitSha(sha)
                    .build();
            System.out.println(newBranch);

            repo.addBranch(newBranch);
        }
    }
}
