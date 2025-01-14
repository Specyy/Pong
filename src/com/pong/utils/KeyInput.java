package com.pong.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
   private boolean[] currentKey = new boolean[1999];
   public boolean up;
   public boolean down;
   public boolean w;
   public boolean s;

   public void keyTyped(KeyEvent e) {
   }

   public void keyPressed(KeyEvent e) {
      this.currentKey[e.getKeyCode()] = true;
   }

   public void keyReleased(KeyEvent e) {
      this.currentKey[e.getKeyCode()] = false;
   }

   public void onUpdate() {
      this.up = this.isPressing("UP");
      this.down = this.isPressing("DOWN");
      this.w = this.isPressing("W");
      this.s = this.isPressing("S");
   }

   public boolean isPressing(String key) {
      if (key.equalsIgnoreCase("up")) {
         return this.currentKey[38];
      } else if (key.equalsIgnoreCase("down")) {
         return this.currentKey[40];
      } else if (key.equalsIgnoreCase("w")) {
         return this.currentKey[87];
      } else {
         return key.equalsIgnoreCase("s") ? this.currentKey[83] : false;
      }
   }
}
