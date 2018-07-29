package by.sazonov.matrix.runner;

import by.sazonov.matrix.scanner.ScanFromConsole;
import by.sazonov.matrix.domain.Matrix;
import by.sazonov.matrix.scanner.ScanFromFile;
import by.sazonov.matrix.service.SumBetweenValues;

import java.io.IOException;

public class Run {

    public static void main(String[]args) throws IOException {
        System.out.println("Enter the size of matrix");
        Matrix obj = new Matrix(ScanFromConsole.getIntValue(),ScanFromConsole.getIntValue());

        System.out.println("Enter the value of matrix");
        obj.fillAMatrixRandDouble(ScanFromConsole.getDoubleValue(),ScanFromConsole.getDoubleValue());





        System.out.println("Show Matrix");
        System.out.println(obj);




        System.out.println("Max");
        for (int i=0;i<obj.getLengthLine();i++) {
            System.out.println(obj.getMaxValueLine(i));
        }

        System.out.println("Min");
        for (int i=0;i<obj.getLengthColumn();i++) {
                System.out.println(obj.getMinValueColumn(i));

        }

        System.out.println("\n\nSort for key collumn");
        obj.sortMatrixForKeyColumn(1);
        System.out.println(obj);

        System.out.println("\n\nSort for key line");
        obj.sortMatrixForKeyLine(1);
        System.out.println(obj);

        System.out.println("Zero in last");
        obj.setValueOfMatrix(1,1,0);
        obj.transportZeroInLast();
        System.out.println();
        System.out.println(obj);


        System.out.println("Transport Matrix");
        System.out.println();
        obj.transportMatrix();
        System.out.println(obj);




        System.out.println("Scan from console");
        ScanFromConsole.setValueFromConsole(obj.getArray());

        System.out.println("Sum between positive numbers");
        for (int i=0;i<obj.getLengthLine();i++) {
            System.out.println(SumBetweenValues.getSumNegativeOfValue(obj.getArray(),i));
        }


        System.out.println("Read from file");
        obj = new Matrix(ScanFromFile.getNewArray());
        System.out.println(obj);


    }
}
