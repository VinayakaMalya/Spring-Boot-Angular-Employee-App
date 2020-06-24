package com.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long>, SkillRepositoryCustom
{
	List<Skill> findByEmployeeId(long employeeId);

	Optional<Skill> findByIdAndEmployeeId(long skillId, long employeeId);

}
