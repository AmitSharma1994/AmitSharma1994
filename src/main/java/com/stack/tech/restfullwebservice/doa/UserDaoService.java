package com.stack.tech.restfullwebservice.doa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stack.tech.restfullwebservice.bean.User;
import com.stack.tech.restfullwebservice.controllers.UserController;

@Component
public class UserDaoService {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoService.class);
	static private int count = 3;

	private static List<User> userlist = new ArrayList<User>();

	static {
		userlist.add(new User(1, "amit", new Date()));
		userlist.add(new User(2, "amit", new Date()));
		userlist.add(new User(3, "amit", new Date()));
	}

	public List<User> getAllUser() {
		logger.debug("get");
		return userlist;
	}

	public User Save(User user) {
		logger.info("get");
		if (user.getId() == null) {
			user.setId(++count);
		}
		userlist.add(user);
		return user;
	}

	public User getUserbyId(int id) {
		for (User user : userlist) {
			if (user.getId() == id) {
				return user;
			}

		}
		return null;
	}

	public User deletebyId(int id) {

		Iterator<User> itr = userlist.iterator();

		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id)
				itr.remove();
			return user;
		}

		return null;
	}

}
