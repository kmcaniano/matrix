package com.linearalgebra;
import java.awt.Color;

/**
 * The RGBElement is a 1x3 matrix that is stored as a Matrix<IntegerElement>. 
 * The values are the RGB (red, green, blue) values of a color. 
 */
public class RGBElement implements Element<RGBElement>{

    private Matrix<IntegerElement> matrix;

    public RGBElement(IntegerElement[] rgbValues)
    {
        matrix = new Matrix<>(rgbValues, 1, 3, IntegerElement.class);
    }

    public RGBElement(int red, int green, int blue)
    {
        IntegerElement[] rgb = new IntegerElement[]{new IntegerElement(red), new IntegerElement(green), new IntegerElement(blue)}; 
        matrix = new Matrix<>(rgb, 1, 3, IntegerElement.class);
    }

    @Override
    public RGBElement add(RGBElement other) {
        matrix.add(other.getMatrix());
        for (IntegerElement element : matrix.getArray())
        {
            if (element.getValue() > 255)
            {
                element.setValue(255);
            }
        }
        return this;
    }

    @Override
    public RGBElement subtract(RGBElement other) {
        matrix.subtract(other.getMatrix());
        
        for (IntegerElement element : matrix.getArray())
        {
            if (element.getValue() < 0)
            {
                element.setValue(0);
            }
        }
        return this;
    }

    @Override
    public RGBElement multiply(RGBElement other) 
    {
        IntegerElement[] product = new IntegerElement[matrix.size()];
        for (int i = 0; i < matrix.size(); i++)
        {
            product[i] = matrix.getElement(i).multiply(other.getMatrix().getElement(i)).mod(255);
        }
        matrix = new Matrix<>(product, 1, 3, IntegerElement.class);
        return this;
    }

    @Override
    public <T extends Number> RGBElement scalar(T scale) 
    {
        matrix.scalar(scale);    
        return this;
    }

    public Color toColor()
    {
        return new Color(getRed(), getGreen(), getBlue());
    }

    public Matrix<IntegerElement> getMatrix() {
        return matrix;
    }

    public int getRed()
    {
        return matrix.getElement(0).getValue();
    }

    public int getGreen()
    {
        return matrix.getElement(1).getValue();
    }

        public int getBlue()
    {
        return matrix.getElement(2).getValue();
    }

}
