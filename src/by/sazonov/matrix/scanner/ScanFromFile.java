package by.sazonov.matrix.scanner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanFromFile {
    public static double[][] getNewArray () throws IOException {
        FileReader file = new FileReader(new File("src/resources/file.txt"));
        Scanner sc = new Scanner(file);

        double[][]array = new double[checkLineSizeOfFile()+1][checkColumnSizeOfFile()+1];


        int indexLine=0;
        int indexColumn=0;

        while(sc.hasNextDouble()){

            if (checkLineSizeOfFile() == indexColumn) {
                indexColumn=0;
                indexLine++;
            }
            array[indexLine][indexColumn]=sc.nextDouble();
            indexColumn++;
        }

        file.close();
        return getNewCloneMatrix(array,indexLine+1,indexColumn);
    }

    private static int checkLineSizeOfFile() throws IOException {
        FileReader file = new FileReader(new File("src/resources/file.txt"));
        Scanner sc = new Scanner(file);

        int count=0;
        String firstLine = "";
        while(sc.hasNextLine()) {
            if (count==1) {
                break;
            }
            firstLine = sc.nextLine();
            count++;
        }
        Pattern pattern = Pattern.compile("\\d{1,9}");
        Matcher matcher = pattern.matcher(firstLine);

        count = 0;
        while (matcher.find()) {
            count++;
        }

        file.close();
        return count;
    }

    private static int checkColumnSizeOfFile() throws IOException {
        FileReader file = new FileReader(new File("src/resources/file.txt"));
        Scanner sc = new Scanner(file);

        int count=0;
        while (sc.hasNextLine()){

            String str = sc.nextLine();
            count++;

        }
        file.close();
        return count;
    }

    private static double[][] getNewCloneMatrix(double[][]array,int lengthLine,int lengthColumn){
        double[][]newArray = new double[lengthLine][lengthColumn];
        for (int i=0;i<lengthLine;i++) {
            for (int j=0;j<lengthColumn;j++) {
                newArray[i][j]=array[i][j];
            }
        }
        return newArray;
    }
}
