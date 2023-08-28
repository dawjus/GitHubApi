package com.example.recruitment.user;

import com.example.recruitment.repository.Repository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<User> findUser(String userName){
        String apiUrl = "https://api.github.com/users/" + userName + "/repos";

        try {
            User user = new User(userName);
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            String responseBody = response.getBody();
            user.setBody(responseBody);
            System.out.println(user.getUserName());
            return Optional.of(user);
        } catch (RestClientException ex){
            return Optional.empty();
        }
    }

    public void findRepository(User user) {
        JSONArray jsonArray = new JSONArray(user.getBody());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject repository = jsonArray.getJSONObject(i);
            String repositoryName = repository.getString("name");
            Boolean fork = repository.getBoolean("fork");
            Repository repo = Repository.builder()
                    .repoName(repositoryName)
                    .fork(fork)
                    .branches(new ArrayList<>())
                    .build();

            user.addRepo(repo);
            addToNotFork(repo, user);
        }
    }

    public void addToNotFork(Repository repo, User user){
        if (repo.getFork().equals(false)){
            user.addRepoWithoutFork(repo);
        }
    }


}
