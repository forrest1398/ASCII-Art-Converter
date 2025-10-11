package com.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedImage grayImage = GrayscaleConverter.convert();
        File outputFile = new File("./res/img/output_gray.png");
        ImageIO.write(grayImage, "png", outputFile);
        System.out.println("✅ 흑백 이미지 저장 완료: " + outputFile.getAbsolutePath());

    }
}