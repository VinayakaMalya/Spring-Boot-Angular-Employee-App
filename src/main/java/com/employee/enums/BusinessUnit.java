package com.employee.enums;

public enum BusinessUnit 
{
	
	/* Description : Employee is part of another business unit besides Detroit GEO. */
	
     DIGITALEXPGROUP ("Digital Experience Group"),
     ADOBE ("Adobe"),
     IBMNBU("IBM NBU"),
     APIMANAGEMENT("API Management");
	
	private final String businessUnit;
	
	BusinessUnit(String businessUnit)
	{
		this.businessUnit=businessUnit;
	}
	
	public String getBusinessUnit()
	{
		return businessUnit;
	}
}
