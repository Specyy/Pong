package com.pong.entites;

import com.pong.main.Pong;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
   private Pong pong;
   private float x;
   private float y;
   private float dx;
   private float dy;
   private float radius;
   private Pallet[] players;
   private float startX;
   private float startY;

   public Ball(Pong pong, PlayerOne p1, PlayerTwo p2, float x, float y, float radius) {
      this.pong = pong;
      this.x = x;
      this.y = y;
      this.startX = x;
      this.startY = y;
      this.radius = radius;
      this.players = new Pallet[]{p2, p1};
      this.dx = 3.5F;
      this.dy = 3.5F;
   }

   public void onCreate() {
   }

   public void onRender(Graphics2D g) {
      g.setColor(Color.WHITE);
      g.fillOval((int)this.x, (int)this.y, (int)this.radius, (int)this.radius);
   }

   public void onUpdate() {
      this.x += this.dx;
      this.y += this.dy;
      if (this.x <= 0.0F) {
         this.players[0].score.add();
         System.out.println("[INFO] Player 2 gained a point");
         this.y = this.startY;
         this.x = this.startX;
         this.dx = 3.5F;
         this.dy = 3.5F;
      } else if (this.x >= 920.0F - this.radius) {
         this.players[1].score.add();
         System.out.println("[INFO] Player 1 gained a point");
         this.x = this.startX;
         this.y = this.startY;
         this.dx = 3.5F;
         this.dy = 3.5F;
      }

      if (this.y <= 0.0F || this.y >= 684.0F - this.radius) {
         this.dy *= -1.0F;
      }

      if (this.getBounds().intersects(this.players[1].getBounds())) {
         this.dx += 5.0F;
      } else if (this.getBounds().intersects(this.players[0].getBounds())) {
         this.dx -= 5.0F;
      }

   }

   public void setVelY(float dy) {
      this.dy = dy;
   }

   public void setVelX(float dx) {
      this.dx = dx;
   }

   public float getRadius() {
      return this.radius;
   }

   public void setRadius(float radius) {
      this.radius = radius;
   }

   public Pong getPong() {
      return this.pong;
   }

   public float getX() {
      return this.x;
   }

   public Rectangle getBounds() {
      return new Rectangle((int)this.x, (int)this.y, (int)this.radius, (int)this.radius);
   }
}
