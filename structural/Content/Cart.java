package Content;


public class Cart extends CartContent {
    //private List<Content> contents = new ArrayList<>();
    //private int contentCount = 0;
    private boolean isFromDevelopingCountry;
    // public Cart(boolean isFromDevelopingCountry, String title) {
    //     super(title);
    //     this.isFromDevelopingCountry = isFromDevelopingCountry;
    // }
    public Cart(boolean isFromDevelopingCountry) {
        super("Cart");
        this.isFromDevelopingCountry = isFromDevelopingCountry;
    }

    public void addContent(Content content) {
        contents.add(content);
        //contentCount++;
    }
    public void removeContent(Content content) {
        contents.remove(content);
        //contentCount--;
    }
    @Override
    public void getdetails() {
        System.out.println("Cart Details:");
        int i = 1;
        for (Content content : contents) {
            System.out.println("Content " + i + ":");
            content.getdetails();
            i++;
            System.out.println("-------------------");
        }
        System.out.println("Total Price: $" + calculatePrice());
        System.out.println("Total Duration: " + getduration() + " minutes");
    }
    public boolean isFromDevelopingCountry() {
        return isFromDevelopingCountry;
    }
    public void checkout() {
        CartContent discountedCart = this;
        discountedCart = new DurationDiscount(discountedCart);
        discountedCart = new DevelopingCountry(discountedCart);
        discountedCart = new MultiModuleDiscount(discountedCart);
        discountedCart.getdetails();

        double finalprice = discountedCart.calculatePrice();
        System.out.println("Final Price after discounts: $" + finalprice);
    }

    
    
}
