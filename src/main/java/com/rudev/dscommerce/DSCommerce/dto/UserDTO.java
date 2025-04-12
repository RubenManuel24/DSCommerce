package com.rudev.dscommerce.DSCommerce.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import com.rudev.dscommerce.DSCommerce.entities.User;

public class UserDTO {
	
	private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate bithDate;
    
    private List<String> roles = new ArrayList<>();
    
    public UserDTO() {}

	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		phone = entity.getPhone();
		bithDate = entity.getBithDate();
		
		for(GrantedAuthority role : entity.getRoles()) {
			roles.add(role.getAuthority());
		}
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDate getBithDate() {
		return bithDate;
	}

	public List<String> getRoles() {
		return roles;
	}

}
