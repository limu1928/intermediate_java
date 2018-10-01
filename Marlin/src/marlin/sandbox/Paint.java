package marlin.sandbox;
import marlin.graphicslib.Window;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Paint extends Window {
  public static Random rnd = new Random();
  public static Path thePath = new Path();

  public static int rnd(int max){
    return rnd.nextInt(max);
  }

  public static int CLICK = 0;

  public Paint(){
    super("Paint", 1000, 800);
  }

  @Override
  protected void paintComponent(Graphics g){
    Color c = new Color(rnd(255), rnd(255), rnd(255));
    g.setColor(c);
    //left corner is the origin (0,0). Def
    //drawRect: just border
    //fillRect: rectangle with filled color
    g.fillRect(100,100, 200, 300);
    String msg = "CLICK =" + CLICK;
    int x = 400;
    int y = 200;
    //find the box around the string
    FontMetrics fm = g.getFontMetrics();
    int a = fm.getAscent();
    int d = fm.getDescent();
    int w = fm.stringWidth(msg);
    g.setColor(Color.YELLOW);
    g.fillRect(x, y-a, w, a + d);
    g.setColor(Color.BLACK);
    g.drawString(msg, x, y);
    g.drawOval(x,y,3,3);
    g.drawLine(100, 400,300,100);
    thePath.draw(g);
  }

  @Override
  public void mousePressed(MouseEvent me) {
    CLICK ++;
    thePath.clear();
    thePath.add(new Point(me.getPoint()));
    repaint();//repaint the whole window to capture the change
  }

  public void mouseDragged(MouseEvent me){
    thePath.add(me.getPoint());
    repaint();
  }


  public static class Path extends ArrayList<Point>{
    public void draw(Graphics g){
      for(int i=1; i < this.size(); i++){
        Point p = this.get(i-1), n = this.get(i);
        g.drawLine(p.x, p.y, n.x, n.y);
      }
    }

  }
}
