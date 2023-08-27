package com.example.recruitment.user;
import com.example.recruitment.exceptions.UserNotFoundException;
import com.example.recruitment.repository.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final RepositoryService repositoryService;

    @Autowired
    public UserController(UserService userService, RepositoryService repositoryService) {
        this.userService = userService;
        this.repositoryService = repositoryService;
    }

    @GetMapping("/")
    public ResponseEntity<String> homePage(){
        return ResponseEntity.ok("Page to find repositories from github");
    }

    @GetMapping("/{user}")
    public ResponseEntity<String> getGitHubData(@PathVariable String user) {
        User newUser = userService.findUser(user);
        if (newUser != null) {
            userService.findRepository(newUser);
            repositoryService.findBranches(newUser);
            return ResponseEntity.ok(newUser.toString());
        }
        else {
            throw new UserNotFoundException(user);
        }
    }


}