package Content;

import java.util.List;

public abstract class CartContent extends EduContent{
    public List<Content> getContents() {
        return contents;
    }
    public CartContent(String title) {
        super(title);
    }
    //public abstract int getContentCount();
    public abstract boolean isFromDevelopingCountry();

    ///abstract class so that decorator works only on cart not on course or module
    
}
