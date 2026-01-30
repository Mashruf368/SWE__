package State;

import java.util.Scanner;


import Main.Course;
import Main.Mediator;
import Main.Student;
import Main.CourseStatus;

public class FullState implements States {
    public boolean tryEnroll(Course course,Student s){
        System.out.println("Cannot enroll; course is FULL. You may waitlist: " + course.code);
        return false;
    }
    public boolean addToWaitlist(Course course,Student s){
        if (course.getenrolledlist().contains(s)) {
            System.out.println("Already enrolled; no need to waitlist: " + s.name + " for " + course.code);
            return false;
        }
        if (course.getwaitlist().contains(s)) {
            System.out.println("Already waitlisted: " + s.name + " for " + course.code);
            return false;
        }
        Mediator.getInstance().waitlist(s, course);
        System.out.println("Waitlisted: " + s.name + " for " + course.code);
        return true;
    }
    public boolean dropStudent(Course course,Student s){
        if (s == null) return false;
        boolean changed = false;
        if(course.getenrolledlist().contains(s)){
            Mediator.getInstance().dropfromenroll(s, course);
            System.out.println("Dropped from enrolled: " + s.name + " from " + course.code);  
            changed = true;
        
        
            Mediator.getInstance().PromoteFromWaitlist(course);
        }
        else if (course.getwaitlist().contains(s)) {
            Mediator.getInstance().dropfromwaitlist(s, course);
            System.out.println("Removed from waitlist: " + s.name + " for " + course.code);
            changed = true;
        } else {
            System.out.println(s.name + " is neither enrolled nor waitlisted for " + course.code);
        }
        return changed;
    }

    public void setStatusAdmin(Course course, CourseStatus newStatus){
        // if (newState instanceof ClosedState) {
        //     course.closeWithRandomWaitlistSelection(course.getCapacity());
        //     System.out.println(course.code + " transitioned FULL -> CLOSED");
        // }else if(newState instanceof CancelledState){
        //     course.cancelCourse();
        // } else {
        //     System.out.println("Invalid transition from FULL to " + newState + " (FULL->OPEN is automatic on drop)");

        // }
        switch(newStatus){
            case CLOSED:
                course.closeWithRandomWaitlistSelection(course.getCapacity());
                //System.out.println(course.code + " transitioned FULL -> CLOSED");
                break;
            case CANCELLED:
                course.cancelCourse();
                break;
            default:
                System.out.println("Invalid transition from FULL to " + newStatus + " (FULL->OPEN is automatic on drop)");
                break;
        }
            
        
    }
    public boolean setStatusAdminInteractive(Course course,States newState, Scanner scanner){
        //only for full to closed
        if (newState == null) return true;
        if (newState instanceof FullState) {
            System.out.println("No change: " + course.code + " already in FullState" );
            return true;
        }
        if(newState instanceof ClosedState) {
            if (!course.getwaitlist().isEmpty()) {
                System.out.println(course.code + " has " + course.getwaitlist().size() + " student(s) on waitlist.");
                System.out.print("Do you want to increase capacity before closing? (Enter new capacity, or 0 to not increase): ");
                try {
                    int newCapacity = Integer.parseInt(scanner.nextLine().trim());
                    if (newCapacity > 0) {
                        if (newCapacity > course.getCapacity()) {
                            course.setCapacity(newCapacity);
                            System.out.println("Capacity increased to " + newCapacity);
                            course.closeWithRandomWaitlistSelection(newCapacity);
                        } else {
                            System.out.println("New capacity must be greater than current capacity (" + course.getCapacity() + "). No change.");
                            course.closeWithRandomWaitlistSelection(course.getCapacity());
                        }
                    } else {
                        System.out.println("No capacity increase.");
                        course.closeWithRandomWaitlistSelection(course.getCapacity());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Closing without capacity increase.");
                    course.closeWithRandomWaitlistSelection(course.getCapacity());
                }
            } else {
                // No waitlist, just close
                course.closeWithRandomWaitlistSelection(course.getCapacity());
            }
            return true;
        }
        return true;
    }
    
}
