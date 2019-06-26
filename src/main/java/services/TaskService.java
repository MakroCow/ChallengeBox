package services;

import entities.Challenge;
import entities.Task;
import entities.Venturer;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@RequestScoped
public class TaskService {

    @PersistenceContext
    EntityManager em;

    public Task getTask(int id) {
        return em.find(Task.class, id);
    }

    public Task createTask(Task task) {
        Venturer venturer = em.find(Venturer.class, task.venturer.id);
        task.accepted = new Date();
        task.venturer = venturer;
        em.persist(task);
        return task;
    }

    public List<Task> getTasks(int venturer_id) {
        Query query = em.createNamedQuery("findAllTasks");
        query.setParameter("venturer_id", venturer_id);
        return query.getResultList();
    }

    public List<Task> getOpenTasks(int venturer_id) {
        Query query = em.createNamedQuery("findOpenTasks");
        query.setParameter("venturer_id", venturer_id);
        return query.getResultList();
    }

    public Task setTaskDone(int task_id) {
        Task t = em.find(Task.class, task_id);
        t.done = new Date();
        // Add Task Points to Venturer Score
        t.venturer.setMentalScore(t.getVenturer().getMentalScore() + t.getChallenge().getMentalPoints());
        t.venturer.setNutritionScore(t.getVenturer().getNutritionScore() + t.getChallenge().getNutritionPoints());
        t.venturer.setSportScore(t.getVenturer().getSportScore() + t.getChallenge().getSportPoints());
        em.merge(t);
        return t;
    }

    public Task setTaskFailed(int task_id) {
        Task t = em.find(Task.class, task_id);
        t.failed = new Date();
        em.merge(t);
        return t;
    }
}
