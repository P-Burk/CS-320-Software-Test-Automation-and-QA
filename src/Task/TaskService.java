/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 4-1 Milestone: Task Service
 * Student: Preston Burkhardt
 * Date: 26 March 2022
 */

package Task;

import java.util.ArrayList;
import java.util.Objects;

public class TaskService {
    private final ArrayList<Task> taskServiceList = new ArrayList<>();

    //CONSTRUCTOR
    public TaskService() {}

    /**
     * Creates a new task and adds it to taskServiceList arraylist.
     *
     * @param taskName task's name.
     * @param taskDesc task's description.
     */
    public void addNewTask(String taskName, String taskDesc) {
        Task newTask = new Task(taskName, taskDesc);
        taskServiceList.add(newTask);
    }

    /**
     * Update a task's name per task ID.
     *
     * @param taskID this is the task's ID that you wish to update.
     * @param newName this is the updated name for the task.
     */
    public void updateTaskName(String taskID, String newName) {
        Task task = getTaskByID(taskID);
        if (task != null) {
            task.setTaskName(newName);
        }
    }

    /**
     * Update a task's description per task ID.
     *
     * @param taskID this is the task's ID that you wish to update.
     * @param newDesc this is the description name for the task.
     */
    public void updateTaskDesc(String taskID, String newDesc) {
        Task task = getTaskByID(taskID);
        if (task != null) {
            task.setTaskDesc(newDesc);
        }
    }

    /**
     * Deletes a specific task from the taskService arraylist.
     *
     * @param taskID task's ID number that you wish to delete.
     */
    public void deleteTask(String taskID) {
        Task task = getTaskByID(taskID);
        if (task != null) {
            taskServiceList.remove(task);
        }
    }

    /**
     * Returns a task by task ID.
     *
     * @param taskID this is the task's ID number.
     */
    public Task getTaskByID(String taskID) {
        for (Task task : taskServiceList) {
            if (Objects.equals(taskID, task.getTaskID())) {
                return task;
            }
        }
        System.out.println("Task not found.");
        return null;
    }

    /**
     * Returns a task by the task's index in the taskServiceList array list.
     * USED FOR TESTING PURPOSES.
     *
     * @param indexNum this is the index number of the task.
     */
    public Task getTaskByIndex(int indexNum) {
        return taskServiceList.get(indexNum);
    }
}
