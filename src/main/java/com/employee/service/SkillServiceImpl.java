package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.Skill;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Override
	public List<Skill> findAllSkillsByEmployee(long employeeId) 
	{
		try
		{
			List<Skill> skill =  skillRepository.findByEmployeeId(employeeId);
			if(skill!=null && !skill.isEmpty())
			{
				for(Skill sk : skill)
				{
					sk.setEmpId(employeeId);
				}
				return skill;
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
	public Skill addSkillToEmployee(long employeeId, Skill skill)
	{
		try
		{
			Optional<Employee> employeeExist = employeeRepository.findById(employeeId);
			if(employeeExist.isPresent())
			{
				skill.setEmployee(employeeExist.get());
				skill.setEmpId(employeeId);
				return skillRepository.save(skill);	
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
	public Optional<Skill> findSkillFromEmployeeById(long employeeId, long skillId) 
	{
		try
		{
			Optional<Employee> employeeExist = employeeRepository.findById(employeeId);
			if(employeeExist.isPresent())
			{
				Optional<Skill> skill = skillRepository.findByIdAndEmployeeId(skillId,employeeId);
				skill.get().setEmpId(employeeId);
				return skill;
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
	public Skill updateSkillFromEmployeeById(long employeeId, long skillId, Skill skill) 
	{
		try
		{
			Optional<Employee> employeeExist = employeeRepository.findById(employeeId);
			if(employeeExist.isPresent())
			{
				skill.setEmployee(employeeExist.get());
				skill.setEmpId(employeeId);
				Skill retSkill =  skillRepository.save(skill);
				retSkill.setEmpId(employeeId);
				return retSkill;
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
	public String removeSkillFromEmployeeById(long employeeId, long skillId) 
	{
		try
		{
			Optional<Employee> employeeExist = employeeRepository.findById(employeeId);
			if(employeeExist.isPresent())
			{
				Optional<Skill> skill = skillRepository.findByIdAndEmployeeId(skillId, employeeId);
				if(skill!=null)
				{
					skillRepository.delete(skill.get());
					return "Deleted a technical skill, from a Perficient employee, by ID";
				}
				else
				{
					return null;
				}
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
