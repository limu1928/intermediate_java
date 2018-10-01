package marlin.sandbox;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import marlin.graphicslib.G;
import marlin.graphicslib.UC;
import marlin.graphicslib.Window;
import marlin.sandbox.Ink.List;

public class PaintInk extends Window {
  public static List inkList = new List();

  public PaintInk() {super("PaintInk", UC.screenWidth, UC.screenHeight);}


  public void paintComponent(Graphics g) {
    G.fillBackground(g, Color.white);
    g.setColor(Color.red); g.fillRect(100,100,100,100);
    inkList.show(g);

    Ink.BUFFER.show(g);
  }

  public void mousePressed(MouseEvent me) {
    Ink.BUFFER.pressed(me.getX(), me.getY());
    repaint();
  }

  public void mouseDragged(MouseEvent me) {
    Ink.BUFFER.dragged(me.getX(), me.getY());
    repaint();
  }

  public void mouseReleased(MouseEvent me) {
    inkList.add(new Ink());
    repaint();
  }

}
