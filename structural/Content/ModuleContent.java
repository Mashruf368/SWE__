package Content;

public abstract class ModuleContent extends EduContent {
    public ModuleContent(String title) {
        super(title);
    }

    ////abstract class created so that content decorator only works on module not on course or cart
}
