package marlin.graphicslib;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class G {
  public static Random RND = new Random();
  public static int rnd(int max){return RND.nextInt(max);}
  public static Color rndColor(){return new Color(rnd(256), rnd(256), rnd(256));}
  public static void fillBackground(Graphics g, Color c){
    g.setColor(c);
    g.fillRect(0,0,3000,3000);
  }

  //a vector
  public static class V{
    public int x, y;

    public V(V v){
      this.x = v.x;
      this.y = v.y;
    }
    public V(int x, int y){ this.x = x; this.y=y;}
    public void add(V v){this.x += v.x; this.y += v.y;}
    public void set(V v){this.x = v.x; this.y = v.y;}
    public void set(int x, int y){this.x = x; this.y = y;}
  }
  //vector size
  public static class VS{
    public V loc, size;
    //public VS(V loc, V size){this.loc = loc; this.size = size;}
    public VS(int x, int y, int w, int h){ this.loc = new V(x,y); this.size = new V(w,h);}
    public void fill(Graphics g, Color c){ g.setColor(c); g.fillRect(loc.x, loc.y, size.x, size.y);}
    public boolean hit(int x, int y){return loc.x <= x && loc.y <= y && (size.y + loc.x) >= x && (size.y + loc.y) >= y;}
    public void resize(int x, int y){size.x = x; size.y=y;}
    public int lox(){return loc.x;}
    public int mid(){return loc.x + size.x/2;}
    public int hix() {return loc.x + size.x;}
    public int loy() {return loc.y;}
    public int midy() {return loc.y + size.y / 2;}
    public int hiy() {return loc.y + size.y;}
  }
  public static class LoH{}
  public static class bBox{}

  //poly line
  public static class PL{
    public V[] points;
    public PL(int count){
      points = new V[count];
      for(int i=0; i< count;i++){
        points[i] = new V(0,0);
      }
    }

    public int size(){ return points.length;}

    public void drawN(Graphics g, int n){
      for(int i=1; i< n; i++){
        g.drawLine(points[i-1].x, points[i-1].y, points[i].x, points[i].y);
      }
    }

    public void draw(Graphics g){drawN(g, size());}
  }

}
