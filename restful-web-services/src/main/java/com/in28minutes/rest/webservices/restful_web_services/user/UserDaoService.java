package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static int usersCount = 0;
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(++usersCount, "Katie", LocalDate.now().minusYears(28)));
		users.add(new User(++usersCount, "Bill", LocalDate.now().minusYears(62)));
		users.add(new User(++usersCount, "Frank", LocalDate.now().minusYears(14)));
		users.add(new User(++usersCount, "Susan", LocalDate.now().minusYears(8)));
	}
	
	public User saveUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public List<User> findAll(){
		return users;
	}

	public User getUser(int id) {
		Predicate <? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void deleteById(Integer id) {
		Predicate <? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	/*public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().get();
	}*/
}
