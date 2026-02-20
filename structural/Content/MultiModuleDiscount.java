package Content;

public class MultiModuleDiscount extends DiscountDecorator {
    private double discount=15;; 
    public MultiModuleDiscount(CartContent cart) {
        super(cart);
    }
    @Override
    public double calculatePrice() {
        int size = getmodulecount();
        if(size>=2)
        {
            return super.calculatePrice() - discount;
        }
        return super.calculatePrice();
    }
    @Override
    public String gettitle() {
        return "Multi Module Discount";
    }
    @Override
    public void getdetails() {
        super.getdetails();
        int moduleCount = getmodulecount();
        System.out.println("Number of modules in the cart: " + moduleCount);
        if(moduleCount>=2)
        {
            System.out.println(gettitle()+" More than 2 modules in the cart. A discount of $"+discount+" is applied.");
        }
    }
    @Override
    public boolean isFromDevelopingCountry() {
        return cart.isFromDevelopingCountry();
    }
    
}
