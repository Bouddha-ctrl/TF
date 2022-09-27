package com.ufr.croissantshow;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.Utilisateur;
import com.ufr.croissantshow.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CroissantshowApplication implements CommandLineRunner {

	@Autowired
	private IUserDao uDao;

	@Autowired
	private IRoleDao rDao;

	@GetMapping("/greeting")
	public String greeting(){
		return "Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(CroissantshowApplication.class, args);

	}
	@Override
	public void run(String... strings) throws Exception {

		Role role = Role.builder().roleName("ADMIN").build();
		rDao.save(role);

		Role role2 = Role.builder().roleName("USER").build();
		rDao.save(role2);

		Utilisateur user1 = Utilisateur.builder()
				.role(role)
				.actif(true)
				.email("email@email.com")
				.identifiant("username")
				.motPasse("password")
				.nom("nom")
				.prenom("prenom")
				.build();

		uDao.save(user1);
	}


}
