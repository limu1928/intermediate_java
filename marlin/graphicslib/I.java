package marlin.graphicslib;

import java.awt.Graphics;


public interface I {

  public interface show{
    public void show(Graphics G);
  }

  public interface Area{
    public boolean hit(int x, int y);
    public void pressed(int x, int y);
    public void dragged(int x, int y);
    public void released(int x, int y);
  }
}
