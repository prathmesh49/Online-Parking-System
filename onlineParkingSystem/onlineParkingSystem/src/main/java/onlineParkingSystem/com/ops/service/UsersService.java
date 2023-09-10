package onlineParkingSystem.com.ops.service;

import onlineParkingSystem.com.ops.model.Users;
import onlineParkingSystem.com.ops.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Users registerUser(Users user) {
        // Encrypt the user's password before saving it
        user.setId(UUID.randomUUID());
        Optional<Users> opt = usersRepository.findById(user.getId());
        if(opt.isPresent()){

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }
}
