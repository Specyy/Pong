package com.pong.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.io.IOException;

public class Text {
   private Text() {
   }

   public static Font loadFont(String path, int size) {
      try {
         return Font.createFont(0, Text.class.getResourceAsStream(path)).deriveFont(0, (float)size);
      } catch (IOException | FontFormatException var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public static String drawText(Graphics2D g, Font font, String text, float x, float y, Color color, boolean center) {
      g.setFont(font);
      g.setColor(color);
      float xPos = x;
      float yPos = y;
      if (center) {
         FontMetrics fm = g.getFontMetrics(font);
         xPos = x - (float)(fm.stringWidth(text) / 2);
         yPos = y - (float)(fm.getHeight() / 2) + (float)fm.getAscent();
      }

      g.drawString(text, xPos, yPos);
      return text;
   }
}
