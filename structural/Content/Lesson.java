package Content;

public class Lesson implements Content {
    private int duration;
    private double cost;
    private String title;
    public Lesson(int duration, double cost, String title) {
        this.title = title;
        this.duration = duration;
        this.cost = cost;
    }

    @Override
    public double calculatePrice() {
        return cost;
    }
    @Override
    public int getduration() {
        return duration;
    }
    @Override
    public String gettitle() {
        return title;
    }
    @Override
    public void getdetails() {
        System.out.println("Lesson Title: " + title + ", Duration: " + duration + " minutes, Cost: $" + cost);
    }
}
