package Content;

public class Module extends ModuleContent {
    public Module(String title) {
        super(title);
    }
    
    public void addcourse(Content course){
        if(course instanceof Course)
        {
            addcontent(course);
        }
        else {
            System.out.println("Only courses can be added to a module.");
            throw new IllegalArgumentException("Only courses can be added to a module.");
        }
    }
    public void removecourse(Content course)
    {
        removecontent(course);
    }
    @Override
    public void getdetails() {
        System.out.println("Module Title: " + title + ", Total Duration: " + getduration() + " minutes, Total Cost: $" + calculatePrice());
        System.out.println("Courses:");
        for (Content course : contents) {
            course.getdetails();
        }
    }
    
}
