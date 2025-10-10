package com.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GrayscaleConverter {
    public static BufferedImage convert() throws IOException {

        BufferedImage image = ImageIO.read(new File("./res/img/input.png"));
        int width = image.getWidth();
        int height = image.getHeight();


        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        return result;
    }
}
