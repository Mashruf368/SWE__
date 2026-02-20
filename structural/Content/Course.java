package Content;

public class Course extends EduContent {
    
    public Course(String title) {
        super(title);
    }
    public void addlesson(Content lesson){
        if(lesson instanceof Lesson)
        {
            addcontent(lesson);
        }
        else {
            System.out.println("Only lessons can be added to a course.");
        }
    }
    public void removelesson(Content lesson)
    {
        removecontent(lesson);
    }
    
    @Override
    public void getdetails() {
        System.out.println("Course Title: " + title + ", Total Duration: " + getduration() + " minutes, Total Cost: $" + calculatePrice());
        System.out.println("Lessons:");
        for (Content lesson : contents) {
            lesson.getdetails();
        }
    }

    
}
