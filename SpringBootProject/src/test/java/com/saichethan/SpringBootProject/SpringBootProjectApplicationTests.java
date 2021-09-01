package com.saichethan.SpringBootProject;

import com.saichethan.SpringBootProject.dao.UserRepository;
import com.saichethan.SpringBootProject.entity.Authorities;
import com.saichethan.SpringBootProject.entity.Student;
import com.saichethan.SpringBootProject.entity.User;
import com.saichethan.SpringBootProject.service.UserService;
import com.saichethan.SpringBootProject.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.saichethan.SpringBootProject.SpringBootProjectApplication.class})
class SpringBootProjectApplicationTests {
	@Test
	void contextLoads() {}
	private UserService userService;
	@Mock
	private UserRepository mockRepository;
	@BeforeEach
	void initUseCase(){
		userService = new UserServiceImpl(mockRepository);
	}
	@Test
	public void findAll_WhenInvoked_ReturnsMockUser(){
		Authorities authority1 = new Authorities("ROLE_STUDENT");
		List<Authorities> authoritiesList = new ArrayList<>();
		authoritiesList.add(authority1);

		Student student1 = new Student("Hello1", "World", "helloworld@gmail.com");
		User user1=new User(student1,"password",authoritiesList);

		Student student2 = new Student("Hello2", "World", "helloworld@gmail.com");
		User user2=new User(student2,"password",authoritiesList);

		Student student3 = new Student("Hello3", "World", "helloworld@gmail.com");
		User user3=new User(student3,"password",authoritiesList);

		Student student4 = new Student("Hello4", "World", "helloworld@gmail.com");
		User user4=new User(student4,"password",authoritiesList);

		Student student5 = new Student("Hello5", "World", "helloworld@gmail.com");
		User user5=new User(student5,"password",authoritiesList);

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		Mockito.when(mockRepository.findAll()).thenReturn(userList);
		Assert.assertEquals(userList,userService.findAll());
		Mockito.verify(mockRepository).findAll();
	}

	@Test
	public void findByIdMocked_WhenInvoked_ReturnsMockUser(){
		Student student = new Student("Hello", "World", "helloworld@gmail.com");
		Authorities authority1 = new Authorities("ROLE_STUDENT");
		List<Authorities> authoritiesList = new ArrayList<>();
		authoritiesList.add(authority1);
		User user=new User(student,"password",authoritiesList);
		Mockito.when(mockRepository.findById(1)).thenReturn(java.util.Optional.of(user));
		Assert.assertEquals(user,userService.findById(1));
		Mockito.verify(mockRepository).findById(1);
	}


	@Test
	public void saveUser_WhenInvoked_Success(){
		Student student = new Student("Hello", "World", "helloworld@gmail.com");
		Authorities authority1 = new Authorities("ROLE_STUDENT");
		List<Authorities> authoritiesList = new ArrayList<>();
		authoritiesList.add(authority1);
		User user=new User(student,"password",authoritiesList);
		Mockito.when(mockRepository.save(user)).thenReturn(user);
		User theUser = userService.save(user);
		assertThat(theUser.getId()).isNotNull();
	}

}
