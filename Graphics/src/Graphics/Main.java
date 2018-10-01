package Graphics;
import sandbox.Paint;

public class Main extends Paint {

  public static void main(String[] args){
    //resize the window will call again
    Window.PANEL = new Main();
    Window.launch();
  }

}
