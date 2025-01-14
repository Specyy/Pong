package com.pong.entites;

import com.pong.main.Pong;
import com.pong.states.States;
import com.pong.utils.Score;
import com.pong.utils.Text;
import java.awt.Color;
import java.awt.Graphics2D;

public class PlayerOne extends Pallet {
   public PlayerOne(Pong pong, Score score, float x, float y, int width, int height, Color color) {
      super(pong, score, x, y, width, height, color);
   }

   public void onCreate() {
   }

   public void onRender(Graphics2D g) {
      g.setColor(this.color);
      g.fillRect((int)this.x, (int)this.y, this.width, this.height);
      Text.drawText(g, Pong.fnt, String.valueOf(this.score.getScore()), 305.0F, 60.0F, Color.WHITE, true);
   }

   public void onUpdate() {
      float screenOffset = 10.0F;
      this.dy = 0.0F;
      this.dx = 0.0F;
      if (this.pong.getKeyInput().w) {
         this.dy = -this.speed;
      } else if (this.pong.getKeyInput().s) {
         this.dy = this.speed;
      }

      if (this.score.getScore() == 5) {
         Pong.currentState = States.GAME_OVER;
         System.out.println("[INFO] Player 1 won!");
         this.won = true;
      }

      this.x = Pong.clamp(this.x, screenOffset, 920.0F - ((float)this.width + screenOffset));
      this.y = Pong.clamp(this.y, screenOffset, 684.0F - ((float)this.height + screenOffset));
      this.x += this.dx;
      this.y += this.dy;
   }
}
