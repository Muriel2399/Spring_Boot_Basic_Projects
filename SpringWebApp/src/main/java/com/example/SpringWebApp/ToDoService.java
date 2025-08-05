package com.example.SpringWebApp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@SessionAttributes("name")
public class ToDoService {
    private static List<ToDo> todos =new ArrayList<>();
private static int todoCount=1;
    static {
        todos.add(new ToDo(todoCount++, "Saiba", "Learn Spring", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(todoCount++, "Samira", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(todoCount++ ,"Sitara", "Learn Java", LocalDate.now().plusYears(1), true));
        todos.add(new ToDo(todoCount++, "Suhana", "Learn AWS", LocalDate.now().plusYears(2), true));

    }

    public List<ToDo> findByUserName(String username) {
        return todos;
    }
    public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
       todos.add(new ToDo(todoCount++, username, description, targetDate, isDone));

    }

    public void deleteById(int id) {
        Predicate<ToDo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }


    public ToDo findById(int id) {
        Predicate<ToDo> predicate = todo -> todo.getId() == id;
        ToDo todo= todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid ToDo todo) {
        deleteById(todo.getId());
        todos.add(todo);

    }
}
