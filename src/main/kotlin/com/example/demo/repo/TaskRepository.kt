package com.example.demo.repo
 
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
 
import com.example.demo.model.Task
 
 
@Repository
interface TaskRepository : CrudRepository<Task, Long> {

	fun findByTitle(title:String) : Iterable<Task>	
}