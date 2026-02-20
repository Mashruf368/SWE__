package Content;

import java.util.List;

public abstract class DiscountDecorator extends CartContent {
    protected CartContent cart;
    public DiscountDecorator(CartContent cart) {
        super(cart.gettitle());
        this.cart = cart;
    }
    @Override
    public double calculatePrice() {
        return cart.calculatePrice();        //// starts working with carts content price
    }
    @Override
    public int getduration() {
        return cart.getduration();           ///// starts workng with carts content duration
    } 
    public int getsize() {
        return cart.contents.size();
    }
    public int getmodulecount() {
        int moduleCount = 0;
        for (Content content : getContents()) {
            if (content instanceof ModuleContent) {
                moduleCount++;
            }
        }
        return moduleCount;
    }
    @Override
    public void getdetails() {
        cart.getdetails();                   //// starts working with carts content details
    }
    @Override
    public List<Content> getContents() {
        return cart.getContents();           //// starts working with carts content list
    }   
    
}
