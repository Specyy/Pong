package com.pong.main;

public class Launcher {
   private Launcher() {
      (new Pong()).start();
   }

   public static void main(String[] args) {
      new Launcher();
   }
}
