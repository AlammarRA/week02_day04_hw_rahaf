package com.example.week02_day04_hw_rahaf;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class taskTrackerController {
    private ArrayList<Task> tasks = new ArrayList<>();

    @RequestMapping(path = "/getTasks", method = RequestMethod.GET)
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    @RequestMapping(path = "/addTasks", method = RequestMethod.POST)
    public message addTasks(@RequestBody Task task){
        tasks.add(task);
        return new message("Added!");
    }

    @RequestMapping(path = "/updateTasks/{index}", method = RequestMethod.PUT)
    public message updateTasks(@PathVariable int index , @RequestBody Task task){
        tasks.set(index,task);
        return new message("Updated!");
    }

    @RequestMapping(path = "/deleteTasks/{index}", method = RequestMethod.DELETE)
    public message deleteTasks(@PathVariable int index){
        tasks.remove(index);
        return new message("Deleted!");
    }

    @RequestMapping(path = "/changeStatus/{index}", method = RequestMethod.POST)
    public message changeStatus(@PathVariable int index , @RequestBody String status){
        Task task = tasks.get(index);
        task.setStatus(status);
        return new message("Status Changed!");

    }



    @RequestMapping(path = "/searchTasks", method = RequestMethod.GET)
    public ArrayList<Task> searchTask(@RequestParam String title){
        ArrayList<Task> tasks1 = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getTitle().equals(title)){
                tasks1.add(tasks.get(i));
            }
        }
    return tasks1;}



}
