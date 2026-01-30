package State;

import Main.Course;
import Main.CourseStatus;
import Main.Student;
import java.util.Scanner;

public class CancelledState implements States{
    public boolean tryEnroll(Course course,Student s){
        System.out.println("Cannot enroll; course is CANCELLED: " + course.code);
        return false;
    }
    public boolean addToWaitlist(Course course,Student s){
        System.out.println("Cannot waitlist; course not accepting waitlist: " + course.code);
        return false;
    }
    public boolean dropStudent(Course course,Student s){
        System.err.println("Cannot drop; course is CANCELLED: " + course.code);
        return false;
    }
    public void setStatusAdmin(Course course , CourseStatus newStatus){
        // if(newState instanceof DraftState){
        //     course.setState(newState);
        //     System.out.println(course.code + " transitioned CANCELLED -> DRAFT (reinstating course)");
        // } else {
        //     System.out.println("Invalid: CANCELLED can only transition to DRAFT for " + course.code);
        // }
        switch (newStatus) {
            case DRAFT:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned CANCELLED -> DRAFT (reinstating course)");
                
                break;
        
            default:
                System.out.println("Invalid: CANCELLED can only transition to DRAFT for " + course.code);
                break;
        }
    }
    public boolean setStatusAdminInteractive(Course course,States newState, Scanner scanner){
        //only for closed to open
        return false;
    }
}
