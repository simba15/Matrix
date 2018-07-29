package by.sazonov.matrix.scanner;

import java.util.Scanner;

public class ScanFromConsole {
    static Scanner sc = new Scanner(System.in);

    public static int getIntValue() {
        return sc.nextInt();
    }

    public static double getDoubleValue () {
        return sc.nextDouble();
    }

    public static void setValueFromConsole(double[][]array) {
        for (int i=0;i<array.length;i++) {
            for (int j=0;j<array[i].length;j++) {
                array[i][j]=getDoubleValue();
            }
        }
    }
}
