package e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorByRows implements Iterator<Integer> {

    //Attributes
    private int currentRow;
    private int currentColumn;
    private Matrix matrix;
    private int currentValue;


    //Methods
    public IteratorByRows(Matrix matrix){
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
        if(currentRow == this.matrix.getNumberOfRows()){
            if(currentColumn == this.matrix.getNumberOfColumns()){
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

        else if(currentColumn == this.matrix.getNumberOfColumns()){
            this.currentRow++;
            this.currentColumn = 1;
            this.currentValue = this.matrix.getValue(currentRow, currentColumn);
            return currentValue;

        }

        else{
            this.currentColumn++;
            this.currentValue = this.matrix.getValue(currentRow, currentColumn);
            return currentValue;
        }

    }

    @Override
    public void remove() {
        //throw exception
        throw new UnsupportedOperationException();
    }
}
