package com.pong.main;

import com.pong.entites.Ball;
import com.pong.entites.Pallet;
import com.pong.entites.PlayerOne;
import com.pong.entites.PlayerTwo;
import com.pong.graphics.Window;
import com.pong.states.States;
import com.pong.utils.KeyInput;
import com.pong.utils.Score;
import com.pong.utils.Text;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Pong implements Runnable {
   public static final Color BACKGROUND_COLOR;
   public static final int WIDTH = 920;
   public static final int HEIGHT = 684;
   private static final String TITLE = "Pong";
   public static States currentState;
   private Thread gameThread;
   private boolean isRunning = false;
   private BufferStrategy bs;
   private Graphics2D g;
   private Window window = new Window("Pong", 920, 684);
   private KeyInput keyInput;
   private Pallet playerOne;
   private Pallet playerTwo;
   private Ball ball;
   private Score scorePlayerOne;
   private Score scorePlayerTwo;
   public static Font fnt;

   public Pong() {
      currentState = States.PLAY;
   }

   public static float clamp(float value, float min, float max) {
      if (value >= max) {
         return max;
      } else {
         return value <= min ? min : value;
      }
   }

   public synchronized void start() {
      if (!this.isRunning) {
         this.isRunning = true;
         System.out.println("[INFO] Started");
         if (this.gameThread == null) {
            this.gameThread = new Thread(this, "Pong Thread");
         }

         this.gameThread.start();
      }
   }

   public synchronized void shutdown() {
      if (this.isRunning) {
         this.isRunning = false;

         try {
            this.gameThread.join();
            System.exit(0);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }

      }
   }

   public void run() {
      this.window.getFrame().requestFocus();
      this.window.getCanvas().requestFocus();
      this.create();
      int fps = 60;
      double maxFps = (double)(1000000000 / fps);
      double lastTime = (double)System.nanoTime();
      double delta = 0.0D;
      double timer = 0.0D;
      int updates = 0;
      int frames = 0;

      while(this.isRunning) {
         double now = (double)System.nanoTime();
         delta += (now - lastTime) / maxFps;
         timer += now - lastTime;
         lastTime = now;
         if (delta >= 1.0D) {
            ++updates;
            this.update();
            --delta;
         }

         ++frames;
         this.render();
         if (timer >= 1.0E9D) {
            this.window.setTitle("Pong | UPS: " + updates + " | FPS: " + frames);
            updates = 0;
            frames = 0;
            timer = 0.0D;
         }
      }

      this.shutdown();
   }

   private void create() {
      if (currentState == States.PLAY) {
         this.keyInput = new KeyInput();
         this.window.getCanvas().addKeyListener(this.keyInput);
         this.playerOne = new PlayerOne(this, new Score(), 0.0F, 334.0F, 16, 64, Color.WHITE);
         this.playerOne.onCreate();
         this.playerTwo = new PlayerTwo(this, new Score(), 920.0F, 334.0F, 16, 64, Color.WHITE);
         this.playerTwo.onCreate();
         this.ball = new Ball(this, (PlayerOne)this.playerOne, (PlayerTwo)this.playerTwo, 457.0F, 339.0F, 20.0F);
         this.ball.onCreate();
         fnt = Text.loadFont("/slkscrb.ttf", 80);
      }

   }

   private void update() {
      if (currentState == States.PLAY) {
         this.keyInput.onUpdate();
         this.ball.onUpdate();
         this.playerOne.onUpdate();
         this.playerTwo.onUpdate();
      }

   }

   private void render() {
      this.bs = this.window.getCanvas().getBufferStrategy();
      if (this.bs == null) {
         this.window.getCanvas().createBufferStrategy(3);
      } else {
         this.g = (Graphics2D)this.bs.getDrawGraphics();
         this.g.setColor(BACKGROUND_COLOR);
         this.g.fillRect(0, 0, this.window.getWidth(), this.window.getHeight());
         if (currentState == States.PLAY) {
            this.g.setColor(Color.WHITE);
            int lineWidth = 15;
            int lineHeight = 40;
            int lineX = 460 - lineWidth;
            this.g.fillRect(lineX, 40, lineWidth, lineHeight);
            this.g.fillRect(lineX, 120, lineWidth, lineHeight);
            this.g.fillRect(lineX, 200, lineWidth, lineHeight);
            this.g.fillRect(lineX, 280, lineWidth, lineHeight);
            this.g.fillRect(lineX, 360, lineWidth, lineHeight);
            this.g.fillRect(lineX, 440, lineWidth, lineHeight);
            this.g.fillRect(lineX, 520, lineWidth, lineHeight);
            this.g.fillRect(lineX, 600, lineWidth, lineHeight);
            this.ball.onRender(this.g);
            this.playerOne.onRender(this.g);
            this.playerTwo.onRender(this.g);
         }

         if (currentState == States.GAME_OVER) {
            if (this.playerTwo.won) {
               Text.drawText(this.g, fnt, "PLAYER 2 WINS!", 460.0F, 342.0F, Color.WHITE, true);
            } else if (this.playerOne.won) {
               Text.drawText(this.g, fnt, "PLAYER 1 WINS!", 460.0F, 342.0F, Color.WHITE, true);
            }
         }

         this.g.dispose();
         this.bs.show();
      }
   }

   public KeyInput getKeyInput() {
      return this.keyInput;
   }

   static {
      BACKGROUND_COLOR = Color.BLACK.brighter().brighter().brighter().brighter().brighter();
   }
}
