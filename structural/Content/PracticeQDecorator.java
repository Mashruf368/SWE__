package Content;

public class PracticeQDecorator extends ContentDecorator {
    private double additionalCost = 10.0;
    public PracticeQDecorator(ModuleContent content) {
        super(content);
    }
    @Override
    public double calculatePrice() {
        return super.calculatePrice()+additionalCost;
    }
    @Override
    public void getdetails() {
        super.getdetails();
        System.out.println("Includes practice questions.");
    }
    
}
