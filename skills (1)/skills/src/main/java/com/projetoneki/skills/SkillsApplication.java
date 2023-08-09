package com.projetoneki.skills;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.projetoneki.skills.model.Client;
import com.projetoneki.skills.model.ClientSkill;
import com.projetoneki.skills.model.Skill;
import com.projetoneki.skills.repositories.ClientRepository;
import com.projetoneki.skills.repositories.ClientSkillRepository;
import com.projetoneki.skills.repositories.SkillRepository;

@SpringBootApplication
public class SkillsApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private ClientSkillRepository clientSkillRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SkillsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Client cli1 = new Client(null, "cli1@gmail.com", passwordEncoder.encode("12345"));
		Client cli2 = new Client(null, "cli4@gmail.com", passwordEncoder.encode("12345"));

		Skill sk1 = new Skill(null, "JAVA", "11", "Backend language", "https://marcas-logos.net/wp-content/uploads/2020/11/Java-logo.png");
		Skill sk2 = new Skill(null, "JavaScrit", "12", "Frontend Language",
				"https://mpng.subpng.com/20180411/cvq/kisspng-javascript-html-computer-software-web-browser-watermark-5acdbd54ac19f7.4484983215234327887049.jpg");
		Skill sk3 = new Skill(null, "SQL", "11", "Backend language", "https://thumbs.dreamstime.com/b/%C3%ADcone-logo-design-ui-ou-ux-app-do-base-de-dados-do-sql-96841969.jpg");
		Skill sk4 = new Skill(null, "Angular", "11", "JS FrameWork", "https://seeklogo.com/images/A/angular-logo-B76B1CDE98-seeklogo.com.png");
		Skill sk5 = new Skill(null, "SpringBoot", "2", "JAVA FrameWork", "https://miro.medium.com/max/624/1*dwa1SCG85BAzQttURVUvrA.png");
		Skill sk6 = new Skill(null, "React", "11", "JS FrameWork", "https://ionicframework.com/docs/icons/logo-react-icon.png");

		ClientSkill cs1 = new ClientSkill(null, cli1, sk1, 10);

		ClientSkill cs2 = new ClientSkill(null, cli1, sk2, 6);
		
		ClientSkill cs3 = new ClientSkill(null, cli1, sk4, 9);
		
		ClientSkill cs4 = new ClientSkill(null, cli1, sk6, 8);
		

		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		skillRepository.saveAll(Arrays.asList(sk1, sk2, sk3, sk4, sk5, sk6));
		clientSkillRepository.saveAll(Arrays.asList(cs1, cs2, cs3, cs4));


	}
}

