package Main;

import java.util.ArrayList;

public class Mediator {

    private static Mediator instance = null;
    private Mediator() {
    }

    public static Mediator getInstance() {
        if (instance == null) {
            instance = new Mediator();
        }
        return instance;
    }
    public boolean isVisibleToStudents(Course course){
        return course.isVisibleToStudents();
    }
    
    
    
    
    ///enroll methods
    public void enroll(Student s,Course course){
        //course.getState().tryEnroll(course, s);
        course.tryEnroll(s);
    }
    public void addtoenroll(Course course,Student s){
        course.getenrolledlist().add(s);
        //System.out.println(course.getEnrolledCount());
        s.addEnrolledCourseDirect(course);
    }



    //waitlist methods
    public void waitlist(Student s,Course course){
        course.getwaitlist().add(s);
        s.addWaitlistCourseDirect(course);
    }
    public void addtowaitlist(Course course,Student s){
        course.addToWaitlist(s);
    }
    //drop from course side
    public void dropfromenroll(Student s,Course course){
        course.getenrolledlist().remove(s);
        s.removeCourseDirect(course);
    }
    public void dropfromwaitlist(Student s,Course course){
        course.getwaitlist().remove(s);
        s.removeCourseDirect(course);
    }
    //drop from student side
    public void dropStudentSide(Course course,Student s){
        course.dropStudent(s);
    }

    public void PromoteFromWaitlist(Course course){
        if(course.getEnrolledCount()<course.getCapacity() && !course.getwaitlist().isEmpty()){
            Student promoted = course.getwaitlist().poll();
            course.getenrolledlist().add(promoted);
            promoted.addEnrolledCourseDirect(course);
            System.out.println("Promoted from waitlist: " + promoted.name + " into " + course.code);
            

        }
    }
    public void promoteRandom(Course course,Student s){
        s.addEnrolledCourseDirect(course);
    }
    public void CancelCourse(Course course){
        for (Student s : new ArrayList<>(course.getenrolledlist())) {
            s.removeCourseDirect(course);
        }
        for (Student s : new ArrayList<>(course.getwaitlist())) {
            s.removeCourseDirect(course);
        }
        course.getenrolledlist().clear();
        course.getwaitlist().clear();
        System.out.println(course.code + " has been CANCELLED. All students dropped and waitlist cleared.");
    }
}
