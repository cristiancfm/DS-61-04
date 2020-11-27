package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorByColumns implements Iterator<Integer> {

    //Attributes
    private int currentRow;
    private int currentColumn;
    private Matrix matrix;
    private int currentValue;


    //Methods
    public IteratorByColumns(Matrix matrix){
        this.currentRow = 1;
        this.currentColumn = 1;
        this.matrix = matrix;
        this.currentValue = matrix.getValue(1, 1);
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    @Override
    public boolean hasNext() {
        if(currentColumn == this.matrix.getNumberOfColumns()){
            if(currentRow == this.matrix.getNumberOfRows()){
                return false;
            }
        }

        //else
        return true;

    }

    @Override
    public Integer next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }

        else if(currentRow == this.matrix.getNumberOfColumns()){
            this.currentRow = 1;
            this.currentColumn++;
            this.currentValue = matrix.getValue(currentRow, currentColumn);
            return currentValue;

        }

        else{
            this.currentRow++;
            this.currentValue = matrix.getValue(currentRow, currentColumn);
            return currentValue;
        }

    }

    @Override
    public void remove() {
        //throw exception
        throw new UnsupportedOperationException();
    }

}
