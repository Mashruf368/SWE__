package Content;

public class DevelopingCountry extends DiscountDecorator {
    private double discount = 10;
    public DevelopingCountry(CartContent cart) {
        super(cart);
    }
    
    
    
    @Override
    public double calculatePrice() {
        if(cart.isFromDevelopingCountry()){
        return super.calculatePrice() - discount;
        }
        return super.calculatePrice();
    }
    @Override
    public String gettitle() {
        return "Developing Country Discount";
    }
    @Override
    public void getdetails() {
        super.getdetails();
        if(cart.isFromDevelopingCountry()){
            
            System.out.println(gettitle()+" A discount of $"+discount+" is applied for developing countries.");
        }
    }
    @Override
    public boolean isFromDevelopingCountry() {
        return cart.isFromDevelopingCountry();
    }
    
}
