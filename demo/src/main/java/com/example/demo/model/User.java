package com.example.demo.model;

import java.util.Collection;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="_user")
@Builder
public class User implements UserDetails{

    @Id
    @GeneratedValue 
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    
    @Override
    public boolean isAccountNonExpired() {
		return true;
	}
    
    public boolean isAccountNonLocked() {
		return true;
	}

    public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}
