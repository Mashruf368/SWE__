package Content;

public abstract class ContentDecorator extends ModuleContent {
    protected ModuleContent content;
    public ContentDecorator(ModuleContent content) {
        super(content.gettitle());
        this.content = content;
    }
    @Override
    public double calculatePrice() {
        return content.calculatePrice();
    }
    @Override
    public int getduration() {
        return content.getduration();
    }  
    @Override
    public String gettitle() {
        return content.gettitle();
    }
    @Override
    public void getdetails() {
        content.getdetails();
    }

    
    
}
