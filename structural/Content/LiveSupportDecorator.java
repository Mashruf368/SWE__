package Content;

public class LiveSupportDecorator extends ContentDecorator {
    private double additionalCost = 20.0;
    public LiveSupportDecorator(ModuleContent content) {
        super(content);
    }
    @Override
    public double calculatePrice() {
        return super.calculatePrice()+additionalCost;
    }
    @Override
    public void getdetails() {
        super.getdetails();
        System.out.println("Includes live support.");
    }
}
