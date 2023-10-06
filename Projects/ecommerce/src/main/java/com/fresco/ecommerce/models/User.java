package com.fresco.ecommerce.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	// Implement Roles


	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="roleId")
	private Role roles;


	/*
	 * @OneToOne(mappedBy = "user", cascade =
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	 * }) private Cart cart;
	 */


	/*
	 * @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, //fetch =
	 * FetchType.LAZY, // By default for OneTOMany fetch type is 'LAZY' , but we are
	 * mentioning specifically cascade =
	 * {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
	 * }) private List<Role> roles;
	 */


	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}



	/*
	 * public List<Role> getRoles() { return roles; } public void
	 * setRoles(List<Role> roles) { this.roles = roles; }
	 */


	// add convenience methods for bi-directional relationship


	/*
	 * public void add(Role tempRole){ if(roles == null){ roles = new ArrayList<>();
	 * }
	 *
	 * roles.add(tempRole); tempRole.setUser(this); }
	 */


	/*
	 * @Override public String toString() { return "User [userId=" + userId +
	 * ", userName=" + username + ", password=" + password + ", roles=" + roles +
	 * "]"; }
	 */






}
