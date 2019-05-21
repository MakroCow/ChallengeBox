package controller;

import entities.Challenge;
import entities.Task;
import services.TaskService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/task")
public class TaskController {

    TaskService taskService = new TaskService();

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Task getTaskByID(@PathParam("id") int id){
        return taskService.getTasks(id);
    }

    @Path("/")
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Task createTask(@FormParam("challenge_id") int challengeId
                           //@FormParam("user_id")int userId
    ) {
        return taskService.createTask(challengeId);
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getTasks() {
        return taskService.getTasks();
    }

    @Path("/allDone")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getDoneTasks() {
        return taskService.getDoneTasks();
    }

    @Path("/allFailed")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getOpenTasks() {
      return taskService.getOpenTasks();
    }

    @Path("/allTerminated")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Challenge> getTerminatedTasks() {
        return taskService.getTerminatedTasks();
    }

}
