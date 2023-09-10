package onlineParkingSystem.com.ops.controller;

import onlineParkingSystem.com.ops.model.Users;
import onlineParkingSystem.com.ops.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/")
    public ResponseEntity<?> regUser(@RequestBody Users users){
        return ResponseEntity.ok(usersService.registerUser(users));
    }
}
