package controller;

import entities.Challenge;
import entities.Task;
import entities.Venturer;
import services.TaskService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/task")
public class TaskController {

    @Inject
    TaskService taskService;

    @Path("/id/{id}")
    @GET
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getTasks(@PathParam("venturer_id") int venturer_id) {
        return taskService.getTasks(venturer_id);
    }

    @Path("/allDone/{venturer_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getDoneTasks(@PathParam("venturer_id") int venturer_id) {
        return taskService.getDoneTasks(venturer_id);
    }

    @Path("/allFailed/{venturer_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getOpenTasks(@PathParam("venturer_id") int venturer_id) {
        return taskService.getOpenTasks(venturer_id);
    }

    @Path("/allTerminated/{venturer_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getTerminatedTasks(@PathParam("venturer_id") int venturer_id) {
        return taskService.getTerminatedTasks(venturer_id);
    }

}
