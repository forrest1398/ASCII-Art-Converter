package com.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AsciiConverter {
    public static void convert() throws IOException {

        // 흑백 이미지 불러오기
        BufferedImage grayImage = ImageIO.read(new File("./res/img/output_gray.png"));
        int width = grayImage.getWidth();
        int height = grayImage.getHeight();

        // 명암에 따른 ASCII 문자
        String asciiList = "@&#%Y!*+=- ";

        // 해상도 조절
        int scope= 2;
        File outputAsciiFile = new File("./res/html/output_ascii_scope_"+scope+".html");

        // html 생성
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputAsciiFile));
        writer.write("<!DOCTYPE html>\n<html>\n<head>\n<meta charset='UTF-8'>\n<title>ASCII Art</title>\n");
        writer.write("<style>\n");

        // body style
        writer.write("body {\n");
        writer.write("  margin: 0;\n");
        writer.write("  align-items: center;\n");
        writer.write("}\n");

        // pre style
        writer.write("pre {\n");
        writer.write("  margin: 0;\n");
        writer.write("  white-space: pre;\n");
        // 가로와 세로 중, 긴 쪽을 기준
        if (width > height) {
            // 가로가 더 긴 경우 → 가로를 100vw 기준으로 맞춤
            writer.write("  font-size: calc(100vw / " + (width / scope) + ");\n");
        } else {
            // 세로가 더 긴 경우 → 세로를 100vh 기준으로 맞춤
            writer.write("  font-size: calc(100vh / " + (height / scope) + ");\n");
        }

        writer.write("  letter-spacing: 2px;\n");
        writer.write("  transform-origin: top left;\n");
        writer.write("}\n");
        writer.write("</style>\n");
        writer.write("</head>\n<body>\n");

        // 원본 이미지
        writer.write("<img src='../img/input.png' alt='Original Image'>\n");
        // 흑백 이미지
        writer.write("<img src='../img/output_gray.png' alt='Gray Image'>\n");

        writer.write("<pre>\n");
        for (int row = 0; row < height; row+=scope) {
            for (int col = 0; col < width; col+=scope) {
                int grayLevel= (grayImage.getRGB(col, row)) & 0xFF;
                int asciiLevel = (int)Math.ceil(grayLevel/25.6);
                char a = asciiList.charAt(asciiLevel);
                writer.write(a);
            }
            writer.newLine();
        }
        writer.write("</pre>\n</body>\n</html>");
        writer.close();
    }
}
