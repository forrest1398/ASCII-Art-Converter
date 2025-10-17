package com.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AsciiConverter {
    public static void convert() throws IOException {
        // get gray image
        BufferedImage grayImage = ImageIO.read(new File("./res/img/output_gray.png"));
        int width = grayImage.getWidth();
        int height = grayImage.getHeight();

        // get gray level and create textfile
        String asciiList = "@&#%Y!*+=- ";

        File outputAsciiFile = new File("./res/html/output_ascii.html");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputAsciiFile));
        writer.write("<!DOCTYPE html>");
        writer.newLine();
        writer.write("<html>");
        writer.write("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />");
        writer.newLine();
        writer.write("<head>");
        writer.newLine();
        writer.write("<title>ACSII ART</title>");
        writer.newLine();
        writer.write("</head>");
        writer.newLine();
        writer.write("<body style=\"margin:0; font-family: \'consolas\'; line-height: 85%; letter-spacing:2px; font-size: 10px; align-content: center \"  >");
        writer.newLine();
        writer.write("<pre>");
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int grayLevel= (grayImage.getRGB(col, row)) & 0xFF;
                int asciiLevel = (int)Math.ceil(grayLevel/25.6);
                char a = asciiList.charAt(asciiLevel);
                writer.write(a);
            }
            writer.newLine();
        }
        writer.write("</pre>");
        writer.newLine();
        writer.write("</body>");
        writer.newLine();
        writer.write("</html>");
        writer.close();
    }
}
