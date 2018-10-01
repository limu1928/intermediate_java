package marlin.sandbox;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.invoke.VolatileCallSite;
import java.util.ArrayList;
import java.util.Collections;
import marlin.graphicslib.G;
import marlin.graphicslib.I;
import marlin.graphicslib.UC;
import sun.jvm.hotspot.debugger.win32.coff.COFFLineNumber;

public class Ink extends G.PL implements I.show {

  //every time things are going into this one buffer.
  public static Buffer BUFFER = new Buffer();

  public Ink() {
    super(BUFFER.n);
    for (int i = 0; i < BUFFER.n; i++) {
      this.points[i].set(BUFFER.points[i]);
    }
  }

  public void show(Graphics g) {
    g.setColor(Color.blue);
    draw(g);
  }

  public static class List extends ArrayList<Ink> implements I.show {

    public void show(Graphics g) {
      for (Ink ink : this) {
        ink.show(g);
      }
    }
  }

  public static class Buffer extends G.PL implements I.show, I.Area {

    public static final int MAX = UC.inkBufferMax;
    public int n = 0;

    //makes this Buffer class private and no other class can call it.
    private Buffer() {
      super(MAX);
    }

    public void add(int x, int y) {
      if (n < MAX) {
        points[n].set(x, y);
        n++;
      }
    }

    public void clear() {
      n = 0;
    }

    @Override
    public boolean hit(int x, int y) {
      return true;
    }

    @Override
    public void pressed(int x, int y) {
      clear();
      add(x, y);
    }

    @Override
    public void dragged(int x, int y) {
      add(x, y);
    }

    @Override
    public void released(int x, int y) {

    }

    @Override
    public void show(Graphics g) {
      g.setColor((Color.green));
      drawN(g, n);
    }
  }
}
