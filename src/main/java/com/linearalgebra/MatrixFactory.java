package com.linearalgebra;

public class MatrixFactory 
{
    public static Matrix createIntegerMatrix(int[] intArray, int rows, int columns)
    {
        IntegerElement[] integerElementArray = new IntegerElement[intArray.length];
        for (int i = 0; i < intArray.length; i++)
        {
            integerElementArray[i] = new IntegerElement(intArray[i]);
        }
        return new Matrix<>(integerElementArray, rows, columns, IntegerElement.class);
    }    

    public static Matrix createRGBMatrix(int rows, int columns, int[]... rgbValues)
    {
        RGBElement[] rgbElements = new RGBElement[rows*columns];
        for (int i = 0; i < rgbValues.length; i++)
        {
            int[] rgbValue = rgbValues[i];
            if (rgbValue.length != 3)
            {
                throw new ArrayIndexOutOfBoundsException("RGBElement must have 3 values");
            }
            rgbElements[i] = new RGBElement(rgbValue[0], rgbValue[1], rgbValue[2]);
        }

        return new Matrix(rgbElements, rows, columns, RGBElement.class);
    }    
}
