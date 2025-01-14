package com.pong.states;

import com.pong.main.Pong;
import java.awt.Graphics2D;

public abstract class State {
   protected Pong pong;

   public State(Pong pong) {
      this.pong = pong;
   }

   public abstract void onCreate();

   public abstract void onRender(Graphics2D var1);

   public abstract void onUpdate();
}
