package com.pong.states;

public enum States {
   MENU(0),
   PLAY(1),
   GAME_OVER(-1);

   private final int id;

   private States(int id) {
      this.id = id;
   }

   public static States fromID(int id) {
      if (id == MENU.id) {
         return MENU;
      } else {
         return id == PLAY.id ? PLAY : GAME_OVER;
      }
   }

   public static States forName(String name) {
      if (name.equalsIgnoreCase(MENU.name())) {
         return MENU;
      } else {
         return name.equalsIgnoreCase(PLAY.name()) ? PLAY : GAME_OVER;
      }
   }

   public int getID() {
      return this.id;
   }
}
