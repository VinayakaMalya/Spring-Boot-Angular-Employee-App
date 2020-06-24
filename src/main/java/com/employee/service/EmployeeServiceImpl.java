package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllEmployees() 
	{
		try
		{
			return employeeRepository.findAll();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Employee createEmployee(Employee employee) 
	{
		try
		{
			return employeeRepository.save(employee);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Optional<Employee> findEmployeeById(long employeeId)
	{
		return employeeRepository.findById(employeeId);
	}

	@Override
	public Optional<Employee> updateEmployeeById(long employeeId,Employee employee) 
	{
		try
		{
			Optional<Employee> employeeExist = employeeRepository.findById(employeeId);
			if(employeeExist!=null && employeeExist.isPresent())
			{
				Employee emp = new Employee();
				emp.setId(employeeId);
				emp.setFirstName(employee.getFirstName());
				emp.setLastName(employee.getLastName());
				emp.setBirthDate(employee.getBirthDate());
				emp.setCompanyEmail(employee.getCompanyEmail());
				emp.setHiredDate(employee.getHiredDate());
				emp.setRole(employee.getRole());
				emp.setBusinessUnit(employee.getBusinessUnit());
				if(employee.getAddress()==null)
				{
					emp.setAddress(employeeExist.get().getAddress());
				}
				else
				{
					emp.setAddress(employee.getAddress());
				}
				if(employee.getSkill()==null || employee.getSkill().isEmpty())
				{
					emp.setSkill(employeeExist.get().getSkill());
				}
				else
				{
					emp.setSkill(employee.getSkill());
				}
				employeeRepository.save(emp);
				return employeeExist;
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public String removeEmployeeById(long employeeId) 
	{
		try
		{
			Optional<Employee> employeeExist = employeeRepository.findById(employeeId);
			if(employeeExist.isPresent())
			{
				employeeRepository.delete(employeeExist.get());
				return "Deleted a Perficient employee.";
			}
			else
			{
				return null;
			}
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
