/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 5-1 Milestone: Appointment Service
 * Student: Preston Burkhardt
 * Date: 01 Apr 2022
 */

package Appointment;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public class AppointmentService {
    private final ArrayList<Appointment> apptServiceList = new ArrayList<>();

    //CONSTRUCTOR
    public AppointmentService() {}

    /**
     * Creates a new appointment and adds it to apptServiceList arraylist.
     *
     * @param apptDate appointment's name.
     * @param apptDesc appointment's description.
     */
    public void addNewAppt(String apptDate, String apptDesc) throws ParseException {
        Appointment newAppt = new Appointment(apptDate, apptDesc);
        apptServiceList.add(newAppt);
    }

    /**
     * Deletes a specific appointment from the apptServiceList arraylist.
     *
     * @param apptID task's ID number that you wish to delete.
     */
    public void deleteAppt(String apptID) {
        for (Appointment appt : apptServiceList) {
            if (Objects.equals(apptID, appt.getAppointmentID())) {
                apptServiceList.remove(appt);
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    /**
     * Returns an appointment by the appointment's index in the apptServiceList array list.
     * USED FOR TESTING PURPOSES.
     *
     * @param indexNum this is the index number of the task.
     * @return returns the appointment object
     */
    protected Appointment getApptByIndex(int indexNum) {
        return apptServiceList.get(indexNum);
    }

    /**
     * Returns total number of appointments in the apptServiceList array list.
     * USED FOR TESTING PURPOSES.
     * @return returns the count of appointments.
     */
    protected int getApptCount() {
        int count = 0;
        for (Appointment appt : apptServiceList) {
            count++;
        }
        return count;
    }
}
