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

        //name setting logic
        if (passedName == null || passedName.isBlank()) {
            this.taskName = "noName";
        } else if (passedName.length() > 20) {
            this.taskName = passedName.substring(0, 20);
        } else {
            this.taskName = passedName;
        }

        //description setting logic
        if (passedDesc == null || passedDesc.isBlank()) {
            this.taskDesc = "noName";
        } else if (passedDesc.length() > 20) {
            this.taskDesc = passedDesc.substring(0, 50);
        } else {
            this.taskDesc = passedDesc;
        }
    }

    //SETTERS
    /**
     * Set the name of the task.
     * @param taskName this is the task's name.
     */
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.isBlank()) {
            this.taskName = "noName";
        } else if (taskName.length() > 20) {
            this.taskName = taskName.substring(0, 20);
        } else {
            this.taskName = taskName;
        }
    }

    /**
     * Set the description of the task.
     * @param taskDesc this is the task's description.
     */
    public void setTaskDesc(String taskDesc) {
        if (taskDesc == null || taskDesc.isBlank()) {
            this.taskDesc = "noName";
        } else if (taskDesc.length() > 20) {
            this.taskDesc = taskDesc.substring(0, 50);
        } else {
            this.taskDesc = taskDesc;
        }
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
