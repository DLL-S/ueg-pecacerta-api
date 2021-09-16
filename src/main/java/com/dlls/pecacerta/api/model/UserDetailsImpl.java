package com.dlls.pecacerta.api.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long Codigo;

	private String email;

	@JsonIgnore
	private String senha;
	
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String email, String senha, Collection<? extends GrantedAuthority> authorities) {
		this.Codigo = id;
		this.email = email;
		this.senha = senha;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Funcionario funcionario) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("FUNCIONARIO"));

		return new UserDetailsImpl(funcionario.getCodigo(), funcionario.getEmail(),
				funcionario.getSenha(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return Codigo;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(Codigo, user.Codigo);
	}
}