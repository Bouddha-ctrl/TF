package com.ufr.croissantshow;

import com.ufr.croissantshow.dao.IMercrediDao;
import com.ufr.croissantshow.dao.IRoleDao;
import com.ufr.croissantshow.dao.IUserDao;
import com.ufr.croissantshow.modele.Mercredi;
import com.ufr.croissantshow.modele.Role;
import com.ufr.croissantshow.modele.User;
import com.ufr.croissantshow.service.IMercrediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication

public class CroissantshowApplication implements CommandLineRunner {

	@Autowired
	private IUserDao uDao;

	@Autowired
	private IMercrediService mService;

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
				.lastname("nom1")
				.firstname("prenom1")
				.build();

		uDao.save(user2);

		User user3 = User.builder()
				.role(role2)
				.enabled(false)
				.email("email@email.com")
				.username("useruser2")
				.password("useruser")
				.lastname("nom2")
				.firstname("prenom2")
				.build();

		uDao.save(user3);

		Date next =new SimpleDateFormat("yyyy-MM-dd")
				.parse(LocalDate.now().with(
									TemporalAdjusters.next( DayOfWeek.WEDNESDAY )
									)
								.toString());
		Date next2 =new SimpleDateFormat("yyyy-MM-dd")
				.parse(LocalDate.now().with(
								TemporalAdjusters.next( DayOfWeek.WEDNESDAY )
						).now().with(
								TemporalAdjusters.next( DayOfWeek.WEDNESDAY )
						)
						.toString());
		Date prev =new SimpleDateFormat("yyyy-MM-dd")
				.parse(LocalDate.now().with(
								TemporalAdjusters.previous( DayOfWeek.WEDNESDAY )
						)
						.toString());


		Mercredi mercredi1 = Mercredi.builder()
				.date(prev)
				.build();

		Mercredi mercredi2 = Mercredi.builder()
				.date(next)
				.build();
		Mercredi mercredi3 = Mercredi.builder()
				.date(next2)
				.build();

		mService.addMercredi(mercredi1);
		mService.addMercredi(mercredi3);
		mService.addMercredi(mercredi2);
	}


}
