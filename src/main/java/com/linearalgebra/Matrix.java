package com.linearalgebra;
import java.lang.reflect.Array;

/**
 * Matrix implementation. Since Matrix extends Element this easily allows for support of n-dimensional matricies.
 * 
 * Matrix has a 1-dimensional array where the user must define dimensions of the mxn matrix. Storing in a 1-dimensional 
 * array allows for faster operations for some functions.
 */
public class Matrix<E extends Element> implements Element<Matrix>
{
    private E[] matrix;

    private int rows;

    private int columns;

    private final Class<E> clazz;

    public Matrix(E[] elementArray, int m, int n, Class<E> clazz)
    {
        matrix = elementArray;
        this.rows = m;
        this.columns = n;
        this.clazz = clazz;
    }

    @Override
    public Matrix add(Matrix other)
    {
        if (rows == other.getNumOfRows() && columns == other.getNumOfColumns())
        {
            for (int i = 0; i < matrix.length; i++)
            {
                matrix[i].add(other.getElement(i));
            }
        }
        else
        {
            throw new IllegalMatrixOperation("For matrix addition, the number of rows and columns between matricies need to be equal.");
        }
        return this;
    }

    @Override
    public Matrix subtract(Matrix other) {
        if (rows == other.getNumOfRows() && columns == other.getNumOfColumns())
        {
            for (int i = 0; i < matrix.length; i++)
            {
                matrix[i].subtract(other.getElement(i));
            }
        }
        else
        {
            throw new IllegalMatrixOperation("Number of rows and columns are not equal");
        }
        return this;
    }

    @Override
    public Matrix multiply(Matrix other) 
    {
        E[] matrixProduct = (E[]) Array.newInstance(clazz, rows * other.getNumOfColumns());

        if (columns == other.getNumOfRows())
        {
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < other.getNumOfColumns(); j++)
                {
                    for (int k = 0; k < other.getNumOfRows(); k++)
                    {
                        E newResult = matrixProduct[(i*rows)+j];
                        E newProduct = (E) getElement((i*columns)+k).multiply(other.getElement((k*other.getNumOfColumns())+j));
                        if (newResult == null)
                        {
                            matrixProduct[(i*rows)+j] = newProduct;
                        }
                        else
                        {
                            matrixProduct[i*rows+j] = (E) newResult.add(newProduct);
                        }
                    }
                }
            }
        }
        else
        {
            throw new IllegalMatrixOperation("For matrix multiplication, the number of columns in the first matrix must equal the number of rows in the second matrix.");
        }
        return new Matrix<>(matrixProduct, rows, other.getNumOfColumns(), clazz);
    }

    @Override
    public <T extends Number> Matrix scalar(T scale) {
        for (E element : matrix)
        {
            element.scalar(scale);
        }
        return this;
    }

    public E getElement(int index)
    {
        return matrix[index];
    }

    public Matrix transpose()
    {
        E[] transposeArray = (E[]) Array.newInstance(clazz, rows * columns);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                transposeArray[(j * rows) + i ] = matrix[(i*columns) + j];
            }
        }
        return new Matrix(transposeArray, columns, rows, clazz);
    }

    public int getNumOfRows()
    {
        return rows;
    }

    public int getNumOfColumns()
    {
        return columns;
    }

    public int size()
    {
        return matrix.length;
    }

    public E[] getArray()
    {
        return matrix;
    }
}
