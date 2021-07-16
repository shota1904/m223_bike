package ch.zli.m223.ksh18a.shotak.crm.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("serial")
@Entity(name = "User")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue
	private Long id;

	private String passwordHash;
	private String userName;

	@ElementCollection(fetch = FetchType.EAGER)
	// for simple types only, no Role objects allowed
	private Set<String> roles;

	@Override
	public List<String> getRoles() {
		return new ArrayList<>(roles);
	}

	@Override
	public Long getId() {
		return id;
	}

	protected AppUserImpl() {
	}

	public AppUserImpl(String userName, String password, List<String> roles) {
		this.userName = userName;
		setPassword(password);
		this.roles = new HashSet<>(roles);
	}

	public AppUserImpl setRoles(List<String> roles) {
		this.roles = new HashSet<>(roles);
		return this;
	}

	private void setPassword(String password) {
		BCryptPasswordEncoder pwe = new BCryptPasswordEncoder();
		passwordHash = pwe.encode(password);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return passwordHash;
	}

	@Override
	public String getUsername() {
		return userName;
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

	/**
	 * @Id
	 * @GeneratedValue private Long id;
	 * 
	 * @Column(unique = true) private String userName; private String passwordHash;
	 * 
	 * @Override public Long getId() { return id; }
	 * 
	 * @Override public String getUserName() { return userName; }
	 * 
	 *           protected AppUserImpl() { } // For JPA
	 * 
	 *           public AppUserImpl(String userName, String password) {
	 *           this.userName = userName; setPassword(password); }
	 * 
	 *           private void setPassword(String password) { // TODO : hash password
	 *           passwordHash = password; }
	 */
}
