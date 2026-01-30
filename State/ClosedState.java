package State;

import Main.Course;
import Main.CourseStatus;
import Main.Student;
import java.util.Scanner;


public class ClosedState implements States {
    public boolean tryEnroll(Course course,Student s){
        System.out.println("Cannot enroll; course is CLOSED: " + course.code);
        return false;
    }

    public boolean addToWaitlist(Course course,Student s){
        System.out.println("Cannot waitlist; course not accepting waitlist: " + course.code);
        return false;
    }

    public boolean dropStudent(Course course,Student s){
        System.err.println("Cannot drop; course is CLOSED: " + course.code);
        return false;
    }


    public void setStatusAdmin(Course course, CourseStatus newStatus){
        
        // if (newState instanceof OpenState) {
        //     course.setState(newState);
        //     System.out.println(course.code + " transitioned CLOSED -> OPEN");
        // } else if (newState instanceof DraftState) {
        //     course.setState(newState);
        //     System.out.println(course.code + " transitioned CLOSED -> DRAFT");
        // } else if (newState instanceof CancelledState) {
        //         course.cancelCourse();
        // } else {
        //     System.out.println("Invalid transition from CLOSED to " + newState);
        // }
        switch(newStatus){
            case OPEN:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned CLOSED -> OPEN");
                break;
            case DRAFT:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned CLOSED -> DRAFT");
                break;
            case CANCELLED:
                course.cancelCourse();
                break;
            default:
                System.out.println("Invalid transition from CLOSED to " + newStatus);
                break;
        // }
        }
    }
    public boolean setStatusAdminInteractive(Course course,States newState, Scanner scanner){
        //only for closed to open
        return false;
    }

}
