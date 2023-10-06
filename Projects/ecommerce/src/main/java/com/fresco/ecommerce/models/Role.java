package com.fresco.ecommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "roleId")
	private Integer roleId;

	@Column(name = "role")
	private String role;


	/*
	 * @ManyToOne(cascade =
	 * {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH
	 * })
	 *
	 * @JoinColumn(name="userId") private User user;
	 */


	public Role() {
		super();
	}

	public Role(String role,User user) {
		super();
		this.role = role;

	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}




	/*
	 * public User getUser() { return user; }
	 *
	 * public void setUser(User user) { this.user = user;
	 *
	 * }
	 */

	/*@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + ", user=" + user + "]";
	}	*/

}
