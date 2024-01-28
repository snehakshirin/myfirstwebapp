package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private TodoService todoservice;
	
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		List<Todo> todos=todoservice.findByUsername("in28minutes");
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username= (String)model.get("name");
		Todo todo= new Todo(0,username,"", LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}

	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo( ModelMap model, @Valid Todo todo, BindingResult result  ) {
		
		if(result.hasErrors())
			return "todo";
		
		String username= (String)model.get("name");
		todoservice.addTodo(username,todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoservice.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo todo=todoservice.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo( ModelMap model, @Valid Todo todo, BindingResult result  ) {
		
		if(result.hasErrors())
			return "todo";
		
		String username= (String)model.get("name");
		todo.setUsername(username);
		todoservice.updateTodo(todo);
		return "redirect:list-todos";
	}
}
