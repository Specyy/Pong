package com.pong.utils;

public class Score {
   private int score;

   public Score() {
      this(0);
   }

   public Score(int start) {
      this.score = start;
   }

   public void onCreate() {
   }

   public void onUpdate() {
   }

   public int add() {
      return this.add(1);
   }

   public int add(int amount) {
      return this.score += amount;
   }

   public int remove() {
      return this.remove(1);
   }

   public int remove(int amount) {
      return this.score -= amount;
   }

   public int setScore(int amount) {
      return this.score = amount;
   }

   public int getScore() {
      return this.score;
   }
}
