package seedu.address.model.attendance;

import seedu.address.model.attendance.Week;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Represents the attendance of a student in TA Toolkit. The attendance of someone is marked negatively.
 */
public class Attendance {
    private final Status[] attendanceList;

    public enum Status {
        PRESENT, ABSENT
    }

    public Attendance() {
        attendanceList = new Status[13];
        resetAttendance();
    }

    public boolean isAbsent(Week week) {
        return attendanceList[week.getWeekIndex().getZeroBased()].equals(Status.ABSENT);
    }

    /**
     * Changes the attendance status of a week. If the week is already modified, return false.
     * @param week The week to change the attendance status of
     * @param status The new status of the week
     */
    public void changeAttendanceStatus(Week week, Status status) {
        attendanceList[week.getWeekIndex().getZeroBased()] = status;
    }

    public void resetAttendance() {
        for (int i = 0; i < 13; i++) {
            attendanceList[i] = Status.PRESENT;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Weeks Absent: ");
        String absentWeeks = IntStream.rangeClosed(0, 12)
                .filter(i -> attendanceList[i] == Status.ABSENT)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        sb.append(absentWeeks.isEmpty() ? "0" : absentWeeks);
        return sb.toString();
    }
}