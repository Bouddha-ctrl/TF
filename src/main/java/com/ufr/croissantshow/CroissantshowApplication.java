package com.ufr.croissantshow;

import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
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

		User user1 = User.builder()
				.role(role)
				.enabled(true)
				.email("email@email.com")
				.username("adminadmin")
				.password("adminadmin")
				.lastname("nom")
				.firstname("prenom")
				.build();

		uDao.save(user1);

		User user2 = User.builder()
				.role(role2)
				.enabled(true)
				.email("email@email.com")
				.username("useruser")
				.password("useruser")
				.lastname("nom")
				.firstname("prenom")
				.build();

		uDao.save(user2);

	}


}
