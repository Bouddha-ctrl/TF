package com.ufr.croissantshow;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

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

		Role role = Role.builder().roleName("ROLE_ADMIN").build();
		rDao.save(role);

		Role role2 = Role.builder().roleName("ROLE_USER").build();
		rDao.save(role2);

		Utilisateur user1 = Utilisateur.builder()
				.role(role)
				.actif(true)
				.email("email@email.com")
				.identifiant("adminadmin")
				.motPasse("adminadmin")
				.nom("nom")
				.prenom("prenom")
				.build();

		uDao.save(user1);

		Utilisateur user2 = Utilisateur.builder()
				.role(role2)
				.actif(true)
				.email("email@email.com")
				.identifiant("useruser")
				.motPasse("useruser")
				.nom("nom")
				.prenom("prenom")
				.build();

		uDao.save(user2);

	}


}
