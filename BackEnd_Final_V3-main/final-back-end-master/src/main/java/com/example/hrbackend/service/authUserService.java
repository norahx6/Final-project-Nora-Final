package com.example.hrbackend.service;
import com.example.hrbackend.dto.RegisterForm;
import com.example.hrbackend.model.Customer;
import com.example.hrbackend.model.Hr;
import com.example.hrbackend.model.User;
import com.example.hrbackend.repository.HrRepository;
import com.example.hrbackend.repository.authUserRepository;
import com.example.hrbackend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class authUserService {

    private final authUserRepository authuserRepository;
    private final HrRepository Hrrepository;
    private final CustomerRepository customerrepository;

    public void register(RegisterForm registerForm) {
        String hashedPassword=new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        User userS=new User(null,registerForm.getUsername(),registerForm.getPassword(),registerForm.getRole(),registerForm.getFullName(),registerForm.getPhoneNumber(),registerForm.getEmail(),registerForm.getMajor());
        User newUser=authuserRepository.save(userS);
        if(registerForm.getRole().equals("HR")){
            Hr hr=new Hr(null,registerForm.getCategory(),registerForm.getSummary(),registerForm.getYearsOfExperience(),newUser.getId());
            Hrrepository.save(hr);
        }else {
            Customer customer=new Customer(null,registerForm.getGoal(),newUser.getId());
            customerrepository.save(customer);
        }

    }


}
