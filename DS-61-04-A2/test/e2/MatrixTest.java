package e2;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testMatrixConstructors() {

        Matrix matrix1 = new Matrix(3,3);
        int[][] array1
                = {{0,0,0},
                {0,0,0},
                {0,0,0}};
        assertArrayEquals(array1, matrix1.getMatrix());


        int[][] array2
                = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        Matrix matrix2 = new Matrix(array2);
        assertArrayEquals(array2, matrix2.getMatrix());


        //exception: non rectangular matrix
        int[][] nonRectangularArray
                = {{1,1,1},
                {1,1},
                {1}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(nonRectangularArray));


        //exception: invalid row or column
        assertThrows(IllegalArgumentException.class, () -> new Matrix(-1,-1));

    }

    @Test
    void testMatrixMethods(){

        int[][] array1
                = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        Matrix matrix1 = new Matrix(array1);


        //get number of rows
        assertEquals(3,matrix1.getNumberOfRows());

        //get number of columns
        assertEquals(3,matrix1.getNumberOfColumns());

        //get values
        assertEquals(1, matrix1.getValue(1,1));
        assertEquals(5, matrix1.getValue(2,2));
        assertEquals(9, matrix1.getValue(3,3));

        assertThrows(IllegalArgumentException.class, () -> matrix1.getValue(5,1));
        assertThrows(IllegalArgumentException.class, () -> matrix1.getValue(1,5));


        //get rows
        int[] row1 = {1,2,3};
        int[] row2 = {4,5,6};
        int[] row3 = {7,8,9};
        assertArrayEquals(row1, matrix1.getRow(1));
        assertArrayEquals(row2, matrix1.getRow(2));
        assertArrayEquals(row3, matrix1.getRow(3));

        assertThrows(IllegalArgumentException.class, () -> matrix1.getRow(5));


        //get columns
        int[] column1 = {1,4,7};
        int[] column2 = {2,5,8};
        int[] column3 = {3,6,9};
        assertArrayEquals(column1, matrix1.getColumn(1));
        assertArrayEquals(column2, matrix1.getColumn(2));
        assertArrayEquals(column3, matrix1.getColumn(3));

        assertThrows(IllegalArgumentException.class, () -> matrix1.getColumn(5));


        //get String representation
        assertEquals("[1, 2, 3]\n[4, 5, 6]\n[7, 8, 9]\n", matrix1.getString());


        //set values
        matrix1.setValue(1, 1, 0);
        assertEquals(0, matrix1.getValue(1, 1));

        assertThrows(IllegalArgumentException.class, () -> matrix1.setValue(5, 1, 0));
        assertThrows(IllegalArgumentException.class, () -> matrix1.setValue(1, 5, 0));

    }

    @Test
    void testMatrixIterators() {

        int[][] array1
                = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        Matrix matrix1 = new Matrix(array1);

        //iteration by rows
        matrix1.setIterateByRows(true);
        Iterator<Integer> iterator1 = matrix1.iterator();

        assertTrue(iterator1.hasNext());
        assertEquals(2, iterator1.next());
        assertEquals(3, iterator1.next());

        while (iterator1.hasNext()){
            iterator1.next();
        }
        assertThrows(NoSuchElementException.class, () -> iterator1.next());

        assertThrows(UnsupportedOperationException.class, () -> iterator1.remove());


        //iteration by columns
        matrix1.setIterateByRows(false);
        Iterator<Integer> iterator2 = matrix1.iterator();

        assertTrue(iterator2.hasNext());
        assertEquals(4, iterator2.next());
        assertEquals(7, iterator2.next());

        while (iterator2.hasNext()){
            iterator2.next();
        }
        assertThrows(NoSuchElementException.class, () -> iterator2.next());

        assertThrows(UnsupportedOperationException.class, () -> iterator2.remove());

    }

    @Test
    void testMatrixAddition() {

        //matrices with same dimensions
        int[][] array1
                = {{1,1,1},
                {1,1,1},
                {1,1,1}};
        Matrix matrix1 = new Matrix(array1);

        assertEquals("[2, 2, 2]\n[2, 2, 2]\n[2, 2, 2]\n", MatrixAddition.sumMatrices(matrix1, matrix1).getString());


        //matrices with different dimensions
        int[][] array2
                = {{1,1},
                {1,1}};
        Matrix matrix2 = new Matrix(array2);

        assertThrows(ArithmeticException.class, () -> MatrixAddition.sumMatrices(matrix1, matrix2));

    }
}