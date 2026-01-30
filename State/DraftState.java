package State;

import java.util.Scanner;

import Main.Course;
import Main.CourseStatus;

public class DraftState implements States{
    public boolean tryEnroll(Main.Course course,Main.Student s){
        System.out.println("Cannot enroll; course is DRAFT (not visible): " + course.code);
        return false;
    }
    public boolean addToWaitlist(Main.Course course,Main.Student s){
        System.out.println("Cannot waitlist; course not accepting waitlist: " + course.code);
        return false;
    }
    public boolean dropStudent(Main.Course course,Main.Student s){
        System.err.println("Cannot drop; course is DRAFT (not visible): " + course.code);
        return false;
    }
    public void setStatusAdmin(Main.Course course , CourseStatus newStatus){
        // if(newState instanceof OpenState){
        //     course.setState(newState);
        //     System.out.println(course.code + " transitioned DRAFT -> OPEN");
        // } else if(newState instanceof ClosedState){
        //     course.setState(newState);
        //     System.out.println(course.code + " transitioned DRAFT -> CLOSED");
        // } else if(newState instanceof CancelledState){
        //     course.cancelCourse();
        // }
        // else {
        //     System.out.println("Invalid transition from DRAFT to " + newState);
        // }
        switch(newStatus){
            case OPEN:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned DRAFT -> OPEN");
                break;
            case CLOSED:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned DRAFT -> CLOSED");
                break;
            case CANCELLED:
                course.cancelCourse();
                break;
            default:
                System.out.println("Invalid transition from DRAFT to " + newStatus);
                break;
        }
    }
    public boolean setStatusAdminInteractive(Course course,States newState, Scanner scanner){
        //only for closed to openre
        return false;
    }
}
