package Content;

public class Main {
    public static void main(String[] args) {

        // ---------- Lessons ----------
        Lesson l1 = new Lesson(60, 20, "Java Basics");
        Lesson l2 = new Lesson(90, 30, "OOP Concepts");
        Lesson l3 = new Lesson(120, 40, "Design Patterns");
        Lesson l4 = new Lesson(45, 15, "Java Streams");
        Lesson l5 = new Lesson(30, 10, "Java Collections");

        // ---------- Courses ----------
        Course c1 = new Course("Java Fundamentals");
        c1.addlesson(l1);
        c1.addlesson(l2);

        Course c2 = new Course("Advanced Java");
        c2.addlesson(l3);

        Course c3 = new Course("Java Essentials");
        c3.addlesson(l5);

        // ---------- Module 1 ----------
        ModuleContent module1 = new Module("Java Mastery Module");
        module1.addcontent(c1);
        module1.addcontent(c2);
        //System.out.println("Adding a standalone lesson to the module:");
        module1.addcontent(l4);
        module1.getdetails();

        // Add-ons (Decorator on Module)
        module1 = new PracticeQDecorator(module1);
        module1 = new LiveSupportDecorator(module1);

        // ---------- Module 2 ----------
        ModuleContent module2 = new Module("Extra Java Module");
        module2.addcontent(c1);

        ModuleContent module3 = new Module("Empty Module");

        module2 = new PracticeQDecorator(module2);

        // ---------- Cart ----------
        Cart cart = new Cart(true); // from developing country
        cart.addContent(module1);
        //cart.addContent(module2);
        //cart.addContent(module3);
        cart.addContent(l4); // Adding a standalone lesson to the cart
        cart.addContent(c3);

        // ---------- Checkout ----------
        cart.checkout();
    }
}

