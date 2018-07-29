package by.sazonov.matrix.service;

public class SumBetweenValues {
    public static double getSumNegativeOfValue(double[][] array, int indexLine) {
        double sum = 0;
        int count = 0, indexColumnFirst = 0, indexColumnSecond = 0;
        for (int i = 0; i < array[i].length; i++) {
            if ((count == 0) && (array[indexLine][i] > 0)) {
                count++;
                indexColumnFirst = i;
                continue;
            }
            if ((count == 1) && (array[indexLine][i] > 0)) {
                count++;
                indexColumnSecond = i;
                break;
            }
        }
        for (int j = indexColumnFirst + 1; j < indexColumnSecond; j++) {
            sum += array[indexLine][j];
        }
        return sum;
    }
}
