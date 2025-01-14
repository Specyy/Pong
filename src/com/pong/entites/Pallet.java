package com.pong.entites;

import com.pong.main.Pong;
import com.pong.utils.Score;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Pallet {
   public boolean won;
   protected Pong pong;
   protected float x;
   protected float y;
   protected float dx;
   protected float dy;
   protected int width;
   protected int height;
   protected Color color;
   protected Score score;
   protected float speed = 5.5F;

   public Pallet(Pong pong, Score score, float x, float y, int width, int height, Color color) {
      this.pong = pong;
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
      this.color = color;
      this.score = score;
      this.won = false;
   }

   public abstract void onCreate();

   public abstract void onRender(Graphics2D var1);

   public abstract void onUpdate();

   public Pong getPong() {
      return this.pong;
   }

   public float getX() {
      return this.x;
   }

   public void setX(float x) {
      this.x = x;
   }

   public float getY() {
      return this.y;
   }

   public void setY(float y) {
      this.y = y;
   }

   public float getDx() {
      return this.dx;
   }

   public void setDx(float dx) {
      this.dx = dx;
   }

   public float getDy() {
      return this.dy;
   }

   public void setDy(float dy) {
      this.dy = dy;
   }

   public int getWidth() {
      return this.width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public Score getScore() {
      return this.score;
   }

   public void setScore(Score score) {
      this.score = score;
   }

   public boolean hasWon() {
      return this.won;
   }

   public void setWon(boolean won) {
      this.won = won;
   }

   public float getSpeed() {
      return this.speed;
   }

   public void setSpeed(float speed) {
      this.speed = speed;
   }

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public Color getColor() {
      return this.color;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public Rectangle getBounds() {
      return new Rectangle((int)this.x, (int)this.y, this.width, this.height);
   }
}
