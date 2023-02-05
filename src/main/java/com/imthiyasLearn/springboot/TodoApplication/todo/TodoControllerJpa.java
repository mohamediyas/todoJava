package com.imthiyasLearn.springboot.TodoApplication.todo;

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
import jakarta.websocket.Session;



@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	
	@Autowired
	private TodoRepository todoRepository;
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap map) {
		// TODO Auto-generated method stub
		
		String userName = (String) map.get("name");
		
		List<Todo> todos = todoRepository.findByUsername(userName);
		
		
		map.addAttribute("todos", todos);
		return "listTodos";

	}
	
	
	@RequestMapping(value = "add-todo",method = RequestMethod.GET)
	public String showNewAddTodo(ModelMap modelMap) {
		Todo todo = new Todo(0, (String)modelMap.get("name"), "", LocalDate.now().plusYears(1), false);
		
		modelMap.put("todo", todo);
		
		return "addTodo";
	}
	
	@RequestMapping(value = "add-todo",method = RequestMethod.POST)
	public String newAddTodo(ModelMap map, @Valid Todo todo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addTodo";
			
		}
		
		System.out.println((String)map.get("name"));
		
		todo.setUsername((String)map.get("name"));
		 
		todoRepository.save(todo);
		
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// TODO Auto-generated method stub
		
		todoRepository.deleteById(id);
		
		
		return "redirect:list-todos";

	}
	
	@RequestMapping(value = "update-todo",method = RequestMethod.GET)
	public String updateTodo(@RequestParam int id,ModelMap map)
	
	{
		Todo todo = todoRepository.findById(id).get();
		
		map.addAttribute("todo",todo);
		
		
		return "addTodo";

	}
	
	
	@RequestMapping(value = "update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap map, @Valid Todo todo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addTodo";
			
		}
		
		
		todo.setUsername((String)map.get("name"));
		 

            todoRepository.save(todo);
		
		
		return "redirect:list-todos";
	}
	
	
 
}