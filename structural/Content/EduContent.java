package Content;

import java.util.ArrayList;
import java.util.List;

public abstract class EduContent implements Content {
    protected List<Content> contents = new ArrayList<>();
    protected String title;
    public EduContent(String title) {
        this.title = title;
    }

    @Override
    public double calculatePrice() {
        double cost = 0;
        for (Content content : contents) {
            cost += content.calculatePrice();
        }
        return cost;
    }
    @Override
    public int getduration() {
        int duration = 0;
        for (Content content : contents) {
            duration += content.getduration();
        }
        return duration;
    }
    @Override
    public String gettitle() {
        return title;
    }

    public void addcontent(Content content) {
        contents.add(content);
    }
    public void removecontent(Content content) {
        contents.remove(content);
    }
}