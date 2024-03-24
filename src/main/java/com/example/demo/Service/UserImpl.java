package com.example.demo.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Repo.LoginMessage;
import com.example.demo.Repo.UserRepo;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDto userDto) {
        User user =new User(
//                userDto.getId(),
                userDto.getUserName(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        userRepo.save(user);
        return user.getFirstName();
    }






    @Override
    public String loginUser(LoginDto loginDTO) {
        String msg = "";
        User employee1 = userRepo.findByEmail(loginDTO.getEmail());
        String name= employee1.getFirstName();
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            System.out.println(isPwdRight);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
//                    return new LoginMessage("Login Success", true);
                    return name;
                } else {
//                    return new LoginMessage("Login Failed", false);
                    return "failed";
                }
            } else {
//                return new LoginMessage("password Not Match", false);
                return "false";
            }
        }else {
//            return new LoginMessage("Email not exits", false);
            return "false";
        }
    }

}
