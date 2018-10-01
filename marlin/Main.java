package marlin;
import marlin.graphicslib.Window;
import marlin.sandbox.PaintInk;


public class Main {

    public static void main(String[] args) {
        //resize the window will call again
        Window.PANEL = new PaintInk();
        Window.launch();
    }

}