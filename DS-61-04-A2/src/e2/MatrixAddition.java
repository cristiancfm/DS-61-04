package e2;

public class MatrixAddition {

    public static Matrix sumMatrices(Matrix matrix1, Matrix matrix2){

        if(matrix1.getNumberOfRows() != matrix2.getNumberOfRows()){
            throw new ArithmeticException();
        }

        if(matrix1.getNumberOfColumns() != matrix2.getNumberOfColumns()){
            throw new ArithmeticException();
        }

        Matrix matrix3 = new Matrix(matrix1.getNumberOfRows(), matrix1.getNumberOfColumns());

        IteratorByRows iterator1 = matrix1.rowColumnIterator();
        IteratorByRows iterator2 = matrix2.rowColumnIterator();
        IteratorByRows iterator3 = matrix3.rowColumnIterator();

        while(iterator1.hasNext() && iterator2.hasNext()){
            matrix3.setValue(iterator3.getCurrentRow(), iterator3.getCurrentColumn(),
                    iterator1.getCurrentValue() + iterator2.getCurrentValue());

            iterator1.next();
            iterator2.next();
            iterator3.next();
        }

        //last element computation
        matrix3.setValue(iterator3.getCurrentRow(), iterator3.getCurrentColumn(),
                iterator1.getCurrentValue() + iterator2.getCurrentValue());

        return matrix3;

    }

}
