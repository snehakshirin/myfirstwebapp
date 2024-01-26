package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> todos= new ArrayList<>();
	
	static	{
		todos.add(new Todo(1,"28minutes","learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"28minutes","learn Devops",LocalDate.now().plusMonths(8),false));
		todos.add(new Todo(3,"28minutes","learn fullstack",LocalDate.now().plusDays(150),false));

	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	

}
