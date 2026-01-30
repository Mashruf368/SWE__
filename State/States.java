package State;

import Main.Course;
import Main.CourseStatus;
import Main.Student;
import java.util.Scanner;

public interface States {
    public boolean tryEnroll(Course course,Student s);
    public boolean addToWaitlist(Course course,Student s);
    public boolean dropStudent(Course course,Student s);
    public void setStatusAdmin(Course course , CourseStatus newStatus);
    public boolean setStatusAdminInteractive(Course course,States newState, Scanner scanner);
}
