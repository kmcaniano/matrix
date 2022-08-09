package com.linearalgebra;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMethod
{
    public static void main(String[] args) throws IOException {

        
        String firstPath = "resources/arch.jpg";

        BufferedImage firstImage = ImageIO.read(new File(firstPath));
        RGBElement[] elements = new RGBElement[firstImage.getWidth() * firstImage.getHeight()];
        for (int i = 0; i < firstImage.getHeight(); i++)
        {
            for (int j = 0; j < firstImage.getWidth(); j++) {
                Color rgb = new Color(firstImage.getRGB(j, i));
                RGBElement rgbElement = new RGBElement(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
                elements[(i * (firstImage.getWidth())) + j] = rgbElement;
            }
        }
        Matrix<RGBElement> firstMatrix = new Matrix<>(elements, firstImage.getWidth(), firstImage.getHeight(), RGBElement.class);


        String secondPath = "resources/cat.jpg";
        BufferedImage secondImage = ImageIO.read(new File(secondPath));
        int moonWidth = secondImage.getWidth();
        RGBElement[] spaceElements = new RGBElement[secondImage.getWidth() * secondImage.getHeight()];
        for (int i = 0; i < secondImage.getHeight(); i++)
        {
            for (int j = 0; j < secondImage.getWidth(); j++)
            {
                Color rgb = new Color(secondImage.getRGB(j, i));
                RGBElement rgbElement = new RGBElement(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
                spaceElements[(i*(moonWidth))+j] = rgbElement;
            }
        }
        Matrix<RGBElement> secondMatrix = new Matrix<>(spaceElements, secondImage.getWidth(), secondImage.getHeight(), RGBElement.class);

        Matrix<RGBElement> product = firstMatrix.add(secondMatrix);

        for (int i = 0; i < firstImage.getHeight(); i++) {
            for (int j = 0; j < firstImage.getWidth(); j++) {
                Color color = product.getElement((i*(firstImage.getWidth())) + j).toColor();
                firstImage.setRGB(j, i, color.getRGB());
            }
        }
        ImageIO.write(firstImage, "jpg", new File("resources/generated.jpg"));
    }
}

