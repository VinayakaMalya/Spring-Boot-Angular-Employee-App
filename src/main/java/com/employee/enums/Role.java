package com.employee.enums;

public enum Role 
{
	
	/* description: The role or title of the employee. */
	
	TECHICALCONSULTANT ("Technical Consulant"),
    PROJECTMANAGER ("Project Manager"),
    DIRECTOR("Director"),
    CHIEF("Chief");
	
	private final String role;
	
	Role(String role)
	{
		this.role=role;
	}
	
	public String getRole()
	{
		return role;
	}
}
