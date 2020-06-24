package com.employee.service;

import java.util.List;
import java.util.Optional;

import com.employee.model.Skill;

public interface SkillService 
{
	List<Skill> findAllSkillsByEmployee(long employeeId);

	Skill addSkillToEmployee(long employeeId, Skill skill);

	Optional<Skill> findSkillFromEmployeeById(long employeeId, long skillId);

	Skill updateSkillFromEmployeeById(long employeeId, long skillId, Skill skill);

	String removeSkillFromEmployeeById(long employeeId, long skillId);
}
