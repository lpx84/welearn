package com.welearn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", columnDefinition="varchar(50)", nullable=false)
	private String name;
	
	@Column(name="description", columnDefinition="varchar(1024)")
	private String description; //角色说明
	
	/**
	 * 角色权限 String类型 用数字串表示 格式是 1;2;3;4;5;6
	 */
	@Column(name="privileges", columnDefinition="varchar(1024)")
	private String privileges;

	public Role() {
		super();
	}

	public Role(String name, String description, String privileges) {
		super();
		this.name = name;
		this.description = description;
		this.privileges = privileges;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	
	/**
	 * 是否具有指定的某项权限
	 * @param privi
	 * @return
	 */
	public boolean hasPrivilege(int privi) {
		boolean res = false;
		if(privileges == null) {
			return false;
		}
		String[] privs = privileges.split(";");
		for(int i=0; i < privs.length; ++i) {
			if(Integer.parseInt(privs[i])  == privi) {
				res = true;
				break;
			}
		}
		return res;
	}
}
