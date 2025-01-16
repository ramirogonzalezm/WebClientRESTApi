package com.dev.synlab.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4084952303081778056L;
	
	private int id;
	private Date createDate;
	private String name;
	private String avatar;

}
