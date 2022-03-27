package Task;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
    private final String taskID;
    private String taskName;
    private String taskDesc;
    private static final AtomicLong idGenerator = new AtomicLong();

    //CONSTRUCTOR
    /**
     * CONSTRUCTOR for the Task class
     *
     * @param passedName  this task's name.
     *                   Cannot be NULL. Cannot be blank. Cannot exceed 20 characters.
     * @param passedDesc this task's description.
     *                 Cannot be NULL. Cannot be blank. Cannot exceed 50 characters.
     */
    public Task(String passedName, String passedDesc) {
        //creates unique taskID
        this.taskID = String.valueOf(idGenerator.getAndIncrement());

        //set the task name
        this.taskName = nameLogic(passedName);

        //set the task description
        this.taskDesc = descLogic(passedDesc);

    }

    //SETTERS
    /**
     * Set the name of the task.
     * @param taskName this is the task's name.
     */
    public void setTaskName(String taskName) {
        this.taskName = nameLogic(taskName);
    }

    /**
     * Set the description of the task.
     * @param taskDesc this is the task's description.
     */
    public void setTaskDesc(String taskDesc) {
        this.taskDesc = descLogic(taskDesc);
    }

    //logic for the task name
    //can't be null, can't be blank, can't be > 20 characters
    private String nameLogic(String taskName) {
        if (taskName == null || taskName.isBlank()) {
            return "noName";
        } else if (taskName.length() > 20) {
            return taskName.substring(0, 20);
        }
        return taskName;
    }

    //logic for the task description
    //can't be null, can't be blank, can't be > 50 characters
    private String descLogic(String taskDesc) {
        if (taskDesc == null || taskDesc.isBlank()) {
            return "noDesc";
        } else if (taskDesc.length() > 50) {
            return taskDesc.substring(0, 50);
        }
        return taskDesc;
    }

    //GETTERS
    /**
     * @return the task's name.
     */
    public String getTaskName() {
        return this.taskName;
    }

    /**
     * @return the task's description.
     */
    public String getTaskDesc() {
        return this.taskDesc;
    }

    /**
     * @return the task's ID.
     */
    public String getTaskID() {
        return this.taskID;
    }
}
