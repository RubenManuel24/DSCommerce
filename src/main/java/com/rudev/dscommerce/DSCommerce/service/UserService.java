package com.rudev.dscommerce.DSCommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudev.dscommerce.DSCommerce.dto.UserDTO;
import com.rudev.dscommerce.DSCommerce.entities.Role;
import com.rudev.dscommerce.DSCommerce.entities.User;
import com.rudev.dscommerce.DSCommerce.projections.UserDetailsProjection;
import com.rudev.dscommerce.DSCommerce.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);
		if (result.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}

		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());

		for (UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}

		return user;

	}

	public User autheticated() {

		try {

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");

			User user = userRepository.findByEmail(username).get();

			return user;

		} catch (Exception e) {
			throw new UsernameNotFoundException("Email not found");
		}
	}
	
	@Transactional(readOnly = true)
	public UserDTO getMe() {
		User user = autheticated();
		return new UserDTO(user);
	}
}
