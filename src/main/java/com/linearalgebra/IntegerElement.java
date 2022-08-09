package com.linearalgebra;

/**
 * Element to be used in place of primitive integers. 
 * This is needed because Java does not support operator overloading, 
 * so we cannot define what the behavior would be for other classes using '+' or '-'
 */
public class IntegerElement implements Element<IntegerElement>{

    private int value;

    public IntegerElement(int value)
    {
        this.value = value;
    }


    @Override
    public IntegerElement add(IntegerElement other)
    {
        value += other.value;
        return this;
    }

    @Override
    public IntegerElement subtract(IntegerElement other) {
        value -= other.value;
        return this;
    }

    @Override
    public <T extends Number> IntegerElement scalar(T scale)
    {
        value *= scale.doubleValue();
        return this;
    }

    public IntegerElement multiply(IntegerElement other)
    {
        return new IntegerElement(value * other.value);
    }

    public void divide(IntegerElement other)
    {
        value /= other.value;
    }

    public IntegerElement mod(int modValue)
    {
        value %= modValue;
        return this;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int newValue)
    {
        this.value = newValue;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean equals = false;
        if (obj.getClass() == IntegerElement.class)
        {
            IntegerElement other = (IntegerElement) obj;
            equals = value == other.getValue();
        }
        return equals;
    }

    @Override
    public String toString()
    {
        return Integer.toString(value);
    }
}
