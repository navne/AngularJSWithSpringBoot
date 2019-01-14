package com.login.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.demo.model.User;
import com.login.demo.model.UserDto;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	/*
	 * @Autowired private UserDao userDao;
	 */
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	List<User> list ;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userDao.findByUsername(username);
		User user = new User();
		user.setUsername("admin");
		String pass = bcryptEncoder.encode("admin");
		user.setPassword("$2a$10$BwYSpqmxlqLhDShFT38EJepqzjzgH0lemnx0rPyYjqQX/iy5hXDRG");
		if(!user.getUsername().equals("admin")){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "Alex","Knr", "alex123","$2a$04$4vwa/ugGbBVDvbWaKUVZBuJbjyQyj6tqntjSmG8q.hi97.xSdhj/2", 3456, 33));
		list.add(new User(2, "Tom", "Asr", "tom234", "$2a$04$QED4arFwM1AtQWkR3JkQx.hXxeAk/G45NiRd3Q4ElgZdzGYCYKZOW", 7823, 23));
		list.add(new User(3, "Adam", "Psr", "adam", "$2a$04$WeT1SvJaGjmvQj34QG8VgO9qdXecKOYKEDZtCPeeIBSTxxEhazNla", 4234, 45));
//		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
//		userDao.deleteById(id);
	}

	@Override
	public User save(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto update(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public User findOne(String username) { // return
	 * userDao.findByUsername(username); }
	 * 
	 * @Override public User findById(int id) { // Optional<User> optionalUser =
	 * userDao.findById(id); return optionalUser.isPresent() ? optionalUser.get() :
	 * null; }
	 * 
	 * @Override public UserDto update(UserDto userDto) { User user =
	 * findById(userDto.getId()); if(user != null) {
	 * BeanUtils.copyProperties(userDto, user, "password"); userDao.save(user); }
	 * return userDto; }
	 * 
	 * @Override public User save(UserDto user) { User newUser = new User();
	 * newUser.setUsername(user.getUsername());
	 * newUser.setFirstName(user.getFirstName());
	 * newUser.setLastName(user.getLastName());
	 * newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	 * newUser.setAge(user.getAge()); newUser.setSalary(user.getSalary()); return
	 * userDao.save(newUser); }
	 */
}
