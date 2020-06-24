package com.employee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Field;

@Repository
public interface FieldRepository extends JpaRepository<Field,Long>, FieldRepositoryCustom
{

	List<Field> findBySkillId(long skillId);

}
