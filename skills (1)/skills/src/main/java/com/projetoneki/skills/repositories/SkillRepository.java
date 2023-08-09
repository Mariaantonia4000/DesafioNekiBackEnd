package com.projetoneki.skills.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoneki.skills.model.Skill;



/*Acessa dados e salva um objeto*/

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{

}
