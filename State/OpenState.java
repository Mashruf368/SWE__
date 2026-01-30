package State;

import Main.Course;
import Main.CourseStatus;
import Main.Student;
import java.util.Scanner;
import Main.Mediator;
public class OpenState implements States{
    //Course course;

    public OpenState(){
        //this.course = course;
    }
    public boolean tryEnroll(Course course,Student s){
        if(course.getenrolledlist().contains(s)){
            System.out.println("Already enrolled: " + s.name + " in " + course.code);
            return true;
        }
        else if(course.getEnrolledCount()<course.getCapacity()){
            Mediator.getInstance().addtoenroll(course, s);
            System.out.println("Enrolled: " + s.name + " in " + course.code);
            if(course.getEnrolledCount()>=course.getCapacity()){
                System.out.println(course.code + " is now FULL.");
                course.setStatus(CourseStatus.FULL);
            }
            return true;
        }
        else 
        {    
            //System.out.println(course.code + " reached capacity; status set to FULL. Try waitlisting.");
            System.out.println("Cannot enroll; course is FULL. You may waitlist: " + course.code);
            //change the course status here *******
            course.setStatus(CourseStatus.FULL);
            return false;         
        }
    }
    public boolean addToWaitlist(Course course,Student s){
        System.out.println("Course is OPEN; try enrolling instead: " + course.code);
        return false;
    }
    public boolean dropStudent(Course course,Student s){
        if (s == null) return false;
        boolean changed = false;
        if(course.getenrolledlist().contains(s)){
            // course.getenrolledlist().remove(s);
            // s.removeCourseDirect(course);
            Mediator.getInstance().dropfromenroll(s, course);
            System.out.println("Dropped from enrolled: " + s.name + " from " + course.code);  
            changed = true;
        
        
            Mediator.getInstance().PromoteFromWaitlist(course);
        }
        else if (course.getwaitlist().contains(s)) {
            // course.getwaitlist().remove(s);
            // s.removeCourseDirect(course);
            Mediator.getInstance().dropfromwaitlist(s, course);
            System.out.println("Removed from waitlist: " + s.name + " for " + course.code);
            changed = true;
        } else {
            System.out.println(s.name + " is neither enrolled nor waitlisted for " + course.code);
        }
        return changed;
    }
    public void setStatusAdmin(Course course ,CourseStatus newStatus){
        // if (newState instanceof OpenState) {
        //     course.setStatus(newStatus);
        //     System.out.println("No change: " + course.code + " already open");
        //     return;
        // }
        // if (newState instanceof FullState) {
        //     course.perfromTransition(newStatus);
        //     //System.out.println(course.code + " transitioned OPEN -> FULL");
        //     return;
        // }
        // if(newState instanceof ClosedState){
        //     course.perfromTransition(newStatus);
        //     System.out.println(course.code + " transitioned OPEN -> CLOSED");
        // }
        // if(newState instanceof DraftState){
        //     System.out.println(course.code + " transitioned OPEN -> DRAFT");
        //     course.perfromTransition(newStatus);
        // }
        // if(newState instanceof CancelledState){
        //     course.cancelCourse();
        // }else {
        //     System.out.println("Invalid transition from OPEN to " + newState);
        // }
        switch (newStatus) {
            case OPEN:
                System.out.println("No change: " + course.code + " already open");
                break;
            case CLOSED:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned OPEN -> CLOSED");
                break;
            case DRAFT:
                course.setStatus(newStatus);
                System.out.println(course.code + " transitioned OPEN -> DRAFT");
                break;
            case CANCELLED:
                course.cancelCourse();
                break;
            default:
                System.out.println("Invalid transition from OPEN to " + newStatus);
                break;
        }


    }
    public boolean setStatusAdminInteractive(Course course,States newState, Scanner scanner){
        //only for full to closed
        return false;
    }
}
