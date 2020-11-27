package e2;

import java.util.Arrays;
import java.util.Iterator;


public class Matrix implements Iterable<Integer>{

    //Attributes
    private final int rows;
    private final int columns;
    private int[][] values;
    private boolean iterateByRows = true;

    //Constructors
    public Matrix(int rows, int columns) {

        if(rows < 1 || columns < 1){
            throw new IllegalArgumentException();
        }

        this.rows = rows;
        this.columns = columns;
        this.values = new int[this.rows][this.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++){
                this.values[i][j] = values[0][0];
            }
        }
    }

    public Matrix(int[][] otherMatrix) {

        //Rectangular, non-ragged array checking
        for(int i = 0; i < otherMatrix.length; i++) {
            if (otherMatrix[i] == null) //columns can not be null
                throw new IllegalArgumentException();
        }

        for(int i = 0; i < otherMatrix.length - 1; i++){
            if (otherMatrix[i].length != otherMatrix[i + 1].length) //columns must have the same length
                throw new IllegalArgumentException();
        }


        this.rows = otherMatrix.length;
        this.columns = otherMatrix[0].length;
        this.values = new int[this.rows][this.columns];

//        for (int i = 0; i < this.rows; i++) {
//            for (int j = 0; j < this.columns; j++){
//                this.values[i][j] = otherMatrix[i][j];
//            }
//        }

        for(int i = 0; i < this.rows; i++){
            this.values[i] = Arrays.copyOf(otherMatrix[i], this.columns);
        }

    }

    //Methods
    public int getNumberOfRows(){
        return this.rows;
    }

    public int getNumberOfColumns(){
        return this.columns;
    }

    public int getValue(int row, int column){

        if(row < 1 || row > this.rows){
            throw new IllegalArgumentException();
        }

        if(column < 1 || column > this.columns){
            throw new IllegalArgumentException();
        }

        return this.values[row-1][column-1];
    }

    public void setValue(int row, int column, int value){

        if(row < 1 || row > this.rows){
            throw new IllegalArgumentException();
        }

        if(column < 1 || column > this.columns){
            throw new IllegalArgumentException();
        }

        this.values[row-1][column-1] = value;

    }

    public int[][] getMatrix(){
        return this.values;
    }

    public int[] getRow(int row){

        if(row < 1 || row > this.rows){
            throw new IllegalArgumentException();
        }

        return this.values[row-1];
    }

    public int[] getColumn(int column){

        if(column < 1 || column > this.columns){
            throw new IllegalArgumentException();
        }

        int[] auxArray = new int[this.rows];

        for (int i = 0; i < this.rows; i++) {
            auxArray[i] = this.values[i][column-1];
        }

        return auxArray;
    }

    public String getString(){

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < this.rows; i++) {

            string.append(Arrays.toString(this.values[i]));
            string.append("\n");

        }

        return string.toString();

    }

    public boolean isIterateByRows() {
        return this.iterateByRows;
    }

    public void setIterateByRows(boolean value) {
        this.iterateByRows = value;
    }


    //Iterators
    public IteratorByRows rowColumnIterator(){
        return new IteratorByRows(this);
    }

    public IteratorByColumns columnRowIterator(){
        return new IteratorByColumns(this);
    }

    @Override
    public Iterator<Integer> iterator() {
        if(this.isIterateByRows()){
           return new IteratorByRows(this);
        }

        //else
        return new IteratorByColumns(this);
    }

}
