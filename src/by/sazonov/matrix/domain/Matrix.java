package by.sazonov.matrix.domain;

public class Matrix {



    private double[][]array;
    private int lengthLine;
    private int lengthColumn;

    public Matrix(int len1,int len2){

        if (!(checkNegativeNumber(len2))||!(checkNegativeNumber(len1))) {
            return;
        }

        lengthLine=len1;
        lengthColumn=len2;

        array=new double[lengthLine][lengthColumn];

    }
    public Matrix() {

    }
    public Matrix(double[][]array) {
        if (array==null) {
            return;
        }
        lengthLine=array.length;
        lengthColumn=array[0].length;
        this.array = array.clone();
    }


    public double[][] getArray() {
        return array;
    }
    public void setArray(double[][]array) {
        if (array==null) {
            return;
        }
        lengthLine=array.length;
        lengthColumn=array[0].length;
        this.array=array.clone();
    }

    public void setValueOfMatrix(int indexLine, int indexColumn, double value){
        if (!(checkLengthSizeLine(indexLine))||!(checkLengthSizeColumn(indexColumn))) {
            return;
        }
        array[indexLine][indexColumn] = value;
    }

    public double getValueOfMatrix(int indexLine,int indexColumn) {
        if (!(checkLengthSizeLine(indexLine))||!(checkLengthSizeColumn(indexColumn))) {
            return 0;
        }
        return array[indexLine][indexColumn];
    }


    public void sortMatrixForKeyLine (int keyLine) {
        for (int i = 1; i <lengthColumn; i++) {
            for (int j = 0; j < lengthColumn - 1; j++) {
                if (array[keyLine][i] < array[keyLine][j]) {
                    double temp = array[keyLine][i];
                    array[keyLine][i]=array[keyLine][j];
                    array[keyLine][j]=temp;
                }
            }
        }
    }
    public void sortMatrixForKeyColumn (int keyColumn) {
        for (int i = 1; i <lengthLine; i++) {
            for (int j = 0; j < lengthLine - 1; j++) {
                if (array[i][keyColumn] < array[j][keyColumn]) {
                    double temp = array[i][keyColumn];
                    array[i][keyColumn]=array[j][keyColumn];
                    array[j][keyColumn]=temp;
                }
            }
        }
    }

    public void fillAMatrixRandDouble(double startValue,double endValue) {
        double[][]newArray = new double[lengthLine][lengthColumn];
        for (int i=0;i<lengthLine;i++) {
            for (int j=0;j<lengthColumn;j++) {
                newArray[i][j]=getRandDoubleValue(startValue,endValue);
            }
        }
        array=newArray;
    }

    private double getRandDoubleValue (double startValue,double endValue) {
        return startValue + ( Math.random() * endValue);
    }

    public int getLengthColumn() {
        return lengthColumn;
    }

    public int getLengthLine() {
        return lengthLine;
    }

    public double getMaxValueLine(int indexLine) {

        double max=array[indexLine][0];
        for (int i=0;i<lengthColumn;i++) {
            if (max < array[indexLine][i]){
                max = array[indexLine][i];
            }
        }
        return max;
    }

    public double getMinValueColumn(int indexColumn) {
        double min = array[0][indexColumn];
        for (int i=0;i<lengthLine;i++) {
            if (min > array[i][indexColumn]) {
                min = array[i][indexColumn];
            }
        }
        return min;
    }

    public void transportMatrix() {
        if (lengthColumn!=lengthLine) {
            return;
        }
        double[][]newArray = new double[lengthLine][lengthColumn];
        for (int i=0;i<lengthLine;i++){
            for (int j=0;j<lengthColumn;j++) {
                newArray[i][j]=array[j][i];
            }
        }
        array=newArray;
    }

    public void transportZeroInLast() {
        int count=0;
        for (int i = 0; i < lengthLine; i++) {
            for (int j = 0; j < lengthColumn; j++) {
                if (((int)array[i][j]==0)&&(count<checkCountZero(array))) {
                    operationZero(i, j);
                    count++;
                }
            }
        }

    }

    private void operationZero(int indexLine, int indexColumn) {
        double temp=array[indexLine][indexColumn];
        int count = 0;
        for (int i=indexLine;i<lengthLine;i++){
            if (count>0){
                for (int j=0;j<lengthColumn;j++) {
                    if ((j==lengthColumn-1) && (i!=lengthLine-1)) {
                        array[i][j]=array[i+1][0];
                        continue;
                    }
                    if ((j==lengthColumn-1) && (i==lengthLine-1)) {
                        //array[i][j]=array[i+1][0];
                        continue;
                    }
                    array[i][j]=array[i][j+1];
                }
            }
            if (count==0) {
                for (int j=indexColumn;j<lengthColumn;j++) {
                    if ((j==lengthColumn-1) && (i!=lengthLine-1)) {
                        array[i][j]=array[i+1][0];
                        continue;
                    }
                    if ((j==lengthColumn-1) && (i==lengthLine-1)) {
                        //array[i][j]=array[i+1][0];
                        continue;
                    }
                    array[i][j]=array[i][j+1];
                }
                count++;
            }


        }
        array[lengthLine-1][lengthColumn-1]=temp;
    }

    private int checkCountZero (double[][]arg) {
        int count=0;
        for (int i=0;i<arg.length;i++) {
            for (int j=0;j<arg[i].length;j++){
                if ((int)arg[i][j]==0) {
                    count++;
                }
            }
        }
        return count;
    }


    private boolean checkNegativeNumber (int index) {
        if (index <0) {
            return false;
        }
        return true;
    }
    private boolean checkLengthSizeLine(int index) {
        if ((index<0)||(index>lengthLine)) {
            return false;
        }
        return true;
    }
    private boolean checkLengthSizeColumn(int index) {
        if ((index<0)||(index>lengthColumn)) {
            return false;
        }
        return true;
    }

    private boolean checkEqualsArray (double[][]arr) {
        for (int i=0;i<lengthLine;i++) {
            for (int j=0;j<lengthColumn;j++) {
                if (arr[i][j]!=array[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stroka = new StringBuilder();
        for (int i=0;i<lengthLine;i++) {
            stroka.append("[");
            for (int j=0;j<lengthColumn;j++) {
                stroka.append(String.valueOf(array[i][j]) + " ");
            }
            stroka.append("]\n");
        }
        return new String(stroka);
    }


    @Override
    public int hashCode() {
        return 31 * lengthLine + lengthColumn + ((array==null) ? 0 : array.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Matrix matrix =(Matrix)obj;

        if (array!=((Matrix) obj).array){
            return false;
        }
        if (null == array) {
            return false;
        } else {
            if ((lengthLine!=((Matrix) obj).lengthLine)&&(lengthColumn!=((Matrix) obj).lengthColumn)&&(!checkEqualsArray(((Matrix) obj).getArray()))) {
                return false;
            }
        }
        return true;
    }
}
