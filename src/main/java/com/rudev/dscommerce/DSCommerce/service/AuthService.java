package com.rudev.dscommerce.DSCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudev.dscommerce.DSCommerce.entities.User;
import com.rudev.dscommerce.DSCommerce.service.exceptions.ForbiddenException;

@Service
public class AuthService {
	
	@Autowired
	private UserService userService = new UserService();
	
	public void validateSelfOrAdmin(long idUser) {
		
		User me = userService.autheticated();
		
		if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(idUser)) {
			throw new ForbiddenException("Access denied");
		}
		
	}

}
