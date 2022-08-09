package com.linearalgebra;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class MatrixTest 
{
    Matrix first2x2 = MatrixFactory.createIntegerMatrix(new int[]{1, 2, 3, 4}, 2, 2);

    Matrix matrix3x2 = MatrixFactory.createIntegerMatrix(new int[]{1, 2, 3, 4, 5, 6}, 3, 2);

    
    @Test   
    public void squareMatrixAdd()
    {
        Matrix second2x2 = MatrixFactory.createIntegerMatrix(new int[]{3, 4, 5, 6}, 2, 2);
        Matrix resultMatrix = first2x2.add(second2x2);
        assertEquals(new IntegerElement(4), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(6), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(8), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(10), resultMatrix.getElement(3));
    }    

    @Test   
    public void squareMatrixSubtract()
    {
        Matrix second2x2 = MatrixFactory.createIntegerMatrix(new int[]{3, 4, 5, 6}, 2, 2);
        Matrix resultMatrix = first2x2.subtract(second2x2);
        assertEquals(new IntegerElement(-2), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(-2), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(-2), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(-2), resultMatrix.getElement(3));
    }    

    @Test   
    public void squareMatrixMultiply()
    {
        Matrix second2x2 = MatrixFactory.createIntegerMatrix(new int[]{3, 4, 5, 6}, 2, 2);
        Matrix resultMatrix = first2x2.multiply(second2x2);
        assertEquals(new IntegerElement(13), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(16), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(29), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(36), resultMatrix.getElement(3));
        assertEquals(2, resultMatrix.getNumOfRows());
        assertEquals(2, resultMatrix.getNumOfColumns());
    }    

    @Test   
    public void squareMatrixTranspose()
    {
        Matrix resultMatrix = first2x2.transpose();
        assertEquals(new IntegerElement(1), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(3), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(2), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(4), resultMatrix.getElement(3));
    } 

    @Test   
    public void matrix3x2Add()
    {
        Matrix second3x2 = MatrixFactory.createIntegerMatrix(new int[]{10, 11, 12, 13, 14, 15}, 3, 2);
        Matrix resultMatrix = matrix3x2.add(second3x2);
        assertEquals(new IntegerElement(11), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(13), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(15), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(17), resultMatrix.getElement(3));
        assertEquals(new IntegerElement(19), resultMatrix.getElement(4));
        assertEquals(new IntegerElement(21), resultMatrix.getElement(5));
    }    

    @Test   
    public void matrix3x2Subtract()
    {
        Matrix second3x2 = MatrixFactory.createIntegerMatrix(new int[]{1, 1, 1, 1, 1, 1}, 3, 2);
        Matrix resultMatrix = matrix3x2.subtract(second3x2);
        assertEquals(new IntegerElement(0), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(1), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(2), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(3), resultMatrix.getElement(3));
        assertEquals(new IntegerElement(4), resultMatrix.getElement(4));
        assertEquals(new IntegerElement(5), resultMatrix.getElement(5));
    }
    
    @Test   
    public void matrix3x2MultiplyFailure()
    {
        Matrix second3x2 = MatrixFactory.createIntegerMatrix(new int[]{10, 11, 12, 13, 14, 15}, 3, 2);
        Exception exception = assertThrows(IllegalMatrixOperation.class, () -> {matrix3x2.multiply(second3x2);});
    
        assertEquals("For matrix multiplication, the number of columns in the first matrix must equal the number of rows in the second matrix.", exception.getMessage());
    }    


    @Test   
    public void matrix3x2MultiplySuccess()
    {
        Matrix matrix2x3 = MatrixFactory.createIntegerMatrix(new int[]{10, 11, 12, 13, 14, 15}, 2, 3);
        Matrix resultMatrix = matrix3x2.multiply(matrix2x3);
        assertEquals(new IntegerElement(36), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(39), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(42), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(82), resultMatrix.getElement(3));
        assertEquals(new IntegerElement(89), resultMatrix.getElement(4));
        assertEquals(new IntegerElement(96), resultMatrix.getElement(5));
        assertEquals(new IntegerElement(128), resultMatrix.getElement(6));
        assertEquals(new IntegerElement(139), resultMatrix.getElement(7));
        assertEquals(new IntegerElement(150), resultMatrix.getElement(8));

        assertEquals(3, resultMatrix.getNumOfRows());
        assertEquals(3, resultMatrix.getNumOfColumns());
        assertEquals(9, resultMatrix.size());
    }

    @Test   
    public void transpose3x2Matrix()
    {
        Matrix resultMatrix = matrix3x2.transpose();
        assertEquals(new IntegerElement(1), resultMatrix.getElement(0));
        assertEquals(new IntegerElement(3), resultMatrix.getElement(1));
        assertEquals(new IntegerElement(5), resultMatrix.getElement(2));
        assertEquals(new IntegerElement(2), resultMatrix.getElement(3));
        assertEquals(new IntegerElement(4), resultMatrix.getElement(4));
        assertEquals(new IntegerElement(6), resultMatrix.getElement(5));

        assertEquals(2, resultMatrix.getNumOfRows());
        assertEquals(3, resultMatrix.getNumOfColumns());
    } 
}
