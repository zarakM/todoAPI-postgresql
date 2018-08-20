package com.example.demo.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired

import com.example.demo.repo.TaskRepository
import com.example.demo.model.Task

@RestController
class TaskController {

	@Autowired
	lateinit var repository: TaskRepository

	@RequestMapping("/tasks")
	fun findAll() = repository.findAll()
	
	@RequestMapping("/findingtasks/{title}")
	fun findingtasks(@PathVariable title: String)= repository.findByTitle(title)
	
	@PostMapping("/tasks/add")
    fun addTask(@RequestBody task: Task )
            = repository.save(task)
	
	@PutMapping("update/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody task: Task) {
        repository.save(Task(task.title,task.description,task.done,id ))
    }

    @DeleteMapping("delete/{id}")
    fun removeTask(@PathVariable id: Long)
            = repository.deleteById(id)


}