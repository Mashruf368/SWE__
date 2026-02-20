package Content;

public class DurationDiscount extends DiscountDecorator {
    private final static double discount = 12;
    private final static int time = 300;
    public DurationDiscount(CartContent cart) {
        super(cart);
    }
    @Override
    public double calculatePrice() {
        if(super.getduration()> time)
        {
            return super.calculatePrice() - discount;
        }
        return super.calculatePrice();
    }
    @Override
    public String gettitle() {
        return "Duration Discount";
    }
    @Override
    public void getdetails() {
        super.getdetails();
        if(super.getduration()> time)
        {
            //super.getdetails();
            System.out.println(gettitle()+" Duration exceeds "+time+" minutes. A discount of $"+discount+" is applied.");
        }
    }
    @Override
    public boolean isFromDevelopingCountry() {
        return cart.isFromDevelopingCountry();
    }
    
}
