package com.linearalgebra;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RGBTest 
{
    @Test   
    public void addRedAndGreen()
    {
        Matrix red = MatrixFactory.createRGBMatrix(1, 1, new int[]{255, 0, 0});
        Matrix green = MatrixFactory.createRGBMatrix(1, 1, new int[]{0, 255, 0});


        Matrix result = red.add(green);

        assertEquals(1, result.getNumOfRows());
        assertEquals(1, result.getNumOfColumns());

        RGBElement singleValue = (RGBElement) result.getElement(0);
        assertEquals(255,singleValue.getRed());
        assertEquals(255, singleValue.getGreen());
        assertEquals(0, singleValue.getBlue());
    }

    @Test   
    public void subRedAndGreen()
    {
        Matrix red = MatrixFactory.createRGBMatrix(1, 1, new int[]{255, 0, 0});
        Matrix green = MatrixFactory.createRGBMatrix(1, 1, new int[]{0, 255, 0});


        Matrix result = red.subtract(green);

        assertEquals(1, result.getNumOfRows());
        assertEquals(1, result.getNumOfColumns());

        RGBElement singleValue = (RGBElement) result.getElement(0);
        assertEquals(255,singleValue.getRed());
        assertEquals(0, singleValue.getGreen());
        assertEquals(0, singleValue.getBlue());
    }

    @Test   
    public void addImageTogether()
    {
        Matrix image1 = MatrixFactory.createRGBMatrix(2, 2, new int[]{255, 0, 0}, new int[]{62, 66, 108}, new int[]{38, 76, 96}, new int[]{37, 252, 98});
        Matrix image2 = MatrixFactory.createRGBMatrix(2, 2, new int[]{0, 255, 0}, new int[]{225, 135, 228}, new int[]{180, 51, 162}, new int[]{2, 178, 200});


        Matrix result = image1.add(image2);

        assertEquals(2, result.getNumOfRows());
        assertEquals(2, result.getNumOfColumns());

        RGBElement firstColor = (RGBElement) result.getElement(0);
        assertEquals(255,firstColor.getRed());
        assertEquals(255, firstColor.getGreen());
        assertEquals(0, firstColor.getBlue());

        RGBElement secondColor = (RGBElement) result.getElement(1);
        assertEquals(255, secondColor.getRed());
        assertEquals(201, secondColor.getGreen());
        assertEquals(255, secondColor.getBlue());

        RGBElement thirdColor = (RGBElement) result.getElement(2);
        assertEquals(218, thirdColor.getRed());
        assertEquals(127, thirdColor.getGreen());
        assertEquals(255, thirdColor.getBlue());

        RGBElement fourthColor = (RGBElement) result.getElement(3);
        assertEquals(39, fourthColor.getRed());
        assertEquals(255, fourthColor.getGreen());
        assertEquals(255, fourthColor.getBlue());
    }

    @Test   
    public void subImageTogether()
    {
        Matrix image1 = MatrixFactory.createRGBMatrix(2, 2, new int[]{255, 0, 0}, new int[]{62, 66, 108}, new int[]{38, 76, 96}, new int[]{37, 252, 98});
        Matrix image2 = MatrixFactory.createRGBMatrix(2, 2, new int[]{0, 255, 0}, new int[]{225, 135, 228}, new int[]{180, 51, 162}, new int[]{2, 178, 200});


        Matrix result = image1.subtract(image2);

        assertEquals(2, result.getNumOfRows());
        assertEquals(2, result.getNumOfColumns());

        RGBElement firstColor = (RGBElement) result.getElement(0);
        assertEquals(255,firstColor.getRed());
        assertEquals(0, firstColor.getGreen());
        assertEquals(0, firstColor.getBlue());

        RGBElement secondColor = (RGBElement) result.getElement(1);
        assertEquals(0, secondColor.getRed());
        assertEquals(0, secondColor.getGreen());
        assertEquals(0, secondColor.getBlue());

        RGBElement thirdColor = (RGBElement) result.getElement(2);
        assertEquals(0, thirdColor.getRed());
        assertEquals(25, thirdColor.getGreen());
        assertEquals(0, thirdColor.getBlue());

        RGBElement fourthColor = (RGBElement) result.getElement(3);
        assertEquals(35, fourthColor.getRed());
        assertEquals(74, fourthColor.getGreen());
        assertEquals(0, fourthColor.getBlue());
    }
}