package com.rudev.dscommerce.DSCommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rudev.dscommerce.DSCommerce.dto.UserDTO;
import com.rudev.dscommerce.DSCommerce.service.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/me")
	public ResponseEntity<UserDTO> getMe() {
		UserDTO result = userService.getMe();
		return ResponseEntity.ok(result);
		
	}

}
