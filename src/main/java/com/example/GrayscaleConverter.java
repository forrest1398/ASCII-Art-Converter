package com.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GrayscaleConverter {
    public static BufferedImage convert() throws IOException {
        // get image
        BufferedImage image = ImageIO.read(new File("./res/img/input.png"));
        int width = image.getWidth();
        int height = image.getHeight();

        // convert image to array
        int[][] rgbaArray = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                rgbaArray[row][col] =  image.getRGB(col, row);
            }
        }

        // convert rgba to gray
        int[][] grayArray = new int[height][width];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgba =  rgbaArray[row][col];
                int a = (rgba >> 24) & 0xFF;
                int r = (rgba >> 16) & 0xFF;
                int g = (rgba >> 8) & 0xFF;
                int b = (rgba) & 0xFF;
                int gray = (int) Math.ceil(0.299*a+0.587*g+0.114*b);
                grayArray[row][col] = (gray>>24) | (gray<<16) | (gray<<8) | gray;
            }
        }

        // create gray image
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int gray = grayArray[row][col];
                int rgb = gray;
                result.setRGB(col, row, rgb);
            }
        }
        return result;
    }
}
