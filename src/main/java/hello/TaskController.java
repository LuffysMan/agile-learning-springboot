package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
//    private static final String template = "Hello, %s!";
    private static final List<Task> TaskList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "/api/tasks")
    public List<Task> getAllTasks() {
        return TaskList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/tasks/")
    public List<Task> createNewTask(@RequestBody Task task) {
        TaskList.add(task);
        return TaskList;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/api/tasks/{id}")
    public Task getTaskById(@PathVariable(name="id")long id){
        Task result = null;
        for (Task task : TaskList) {
            if (id == task.getId()) {
                result = task;
                break;
            }
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/tasks/{id}")
    public List<Task> deleteTaskById(@PathVariable(name = "id") long id) {
        TaskList.remove(getTaskById(id));
        return  TaskList;
    }

}