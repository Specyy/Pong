package com.pong.graphics;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
   private final JFrame window;
   private final Canvas screen;
   private final int WIDTH;
   private final int HEIGHT;
   private String title;

   public Window(String title, int width, int height) {
      this.window = new JFrame(title);
      this.screen = new Canvas();
      this.screen.setPreferredSize(new Dimension(width, height));
      this.screen.setMaximumSize(new Dimension(width, height));
      this.screen.setMinimumSize(new Dimension(width, height));
      this.screen.setFocusable(true);
      this.window.add(this.screen);
      this.window.pack();
      this.window.setDefaultCloseOperation(3);
      this.window.setLocationRelativeTo((Component)null);
      this.window.setResizable(false);
      this.window.setVisible(true);
      this.title = title;
      this.WIDTH = width;
      this.HEIGHT = height;
   }

   public int getWidth() {
      return this.WIDTH;
   }

   public int getHeight() {
      return this.HEIGHT;
   }

   public String getTitle() {
      return this.title;
   }

   public JFrame getFrame() {
      return this.window;
   }

   public Canvas getCanvas() {
      return this.screen;
   }

   public void setTitle(String title) {
      this.window.setTitle(title);
   }
}
