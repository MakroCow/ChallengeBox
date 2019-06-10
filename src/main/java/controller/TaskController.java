package controller;

import entities.Challenge;
import entities.Task;
import entities.Venturer;
import security.JWTAuthed;
import services.TaskService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@JWTAuthed
@Path("/task")
public class TaskController {

    @Inject
    TaskService taskService;

    @Path("/id/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTaskByID(@PathParam("id") int id) {
        return taskService.getTask(id);
    }

    @Path("/")
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Task createTask(Task task) {
        return taskService.createTask(task);
    }

    @Path("/all/{venturer_id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks(@PathParam("venturer_id") int venturer_id) {
        return taskService.getTasks(venturer_id);
    }

    @Path("/allFailed/{venturer_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getOpenTasks(@PathParam("venturer_id") int venturer_id) {
        return taskService.getOpenTasks(venturer_id);
    }


    @Path("/setDone/{task_id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Task setTaskDone(@PathParam("task_id") int task_id) {
        return taskService.setTaskDone(task_id);
    }

    @Path("/setFailed/{task_id}")
    @GET
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Task setTaskFailed(@PathParam("task_id") int task_id) {
        return taskService.setTaskFailed(task_id);
    }

}
