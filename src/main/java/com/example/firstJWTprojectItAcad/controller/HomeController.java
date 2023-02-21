package com.example.firstJWTprojectItAcad.controller;

import com.example.firstJWTprojectItAcad.AuthRequest;
import com.example.firstJWTprojectItAcad.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.firstJWTprojectItAcad.service.CarService;
import com.example.firstJWTprojectItAcad.service.CustomUserDetailsService;
import com.example.firstJWTprojectItAcad.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@RestController
public class HomeController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;
    private final CarService carService;

    @Autowired
    public HomeController(AuthenticationManager authenticationManager,
                          CustomUserDetailsService customUserDetailsService,
                          JwtUtil jwtUtil,
                          CarService carService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.carService = carService;
    }


    @GetMapping("/")
    public String welcome() {
        return "Welcome Home , friend!";
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("invalid username or password");
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUserName());
        return jwtUtil.generateToken(userDetails);
    }

    @GetMapping("/getAll")
    public List<Car> cars() {
        return carService.getCars();
    }

    @GetMapping("/getByUser/{id}")
    public Car cars(@PathVariable Long id) {
        return carService.getByUser(id);
    }

    @GetMapping("/getByModel/{model}")
    public Car cars(@PathVariable String model) {
        return carService.getByModel(model);
    }

    @GetMapping("/getMaxConsumming/{}")
    public Car getMaxConsume() {
        return carService.findByMaxConsume();
    }

    @GetMapping("/getMaxSpeed/{}")
    public Car getMaxSpeed() {
        return carService.findByMaxSpeed();
    }


}
