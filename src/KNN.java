import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KNN {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int k = Integer.parseInt(args[0]);
        String trainName = args[1];
        String testName = args[2];
        ArrayList<Iris> irisTrain;
        ArrayList<Iris> irisTest;

        irisTrain = Read.readFromFile(trainName);
        irisTest = Read.readFromFile(testName);

        System.out.println("1. wyniki dla pliku testoego\n2. wyniki dla podanych testów");
        int tmp = scanner.nextInt();

        switch (tmp) {
            case 1:
                for (int i = 0; i < irisTest.size(); i++)
                    test(irisTrain, irisTest.get(i), k);
                break;
            case 2:
                Iris iris;
                do {
                    iris = Read.readFromStandardIn();
                    if (iris != null) {
                        test(irisTrain, iris, k);
                        System.out.println("aby zakonczyc wpisz 0");
                    }
                } while (iris != null);
                break;
            default:
                System.out.println("bład");
                break;
        }
    }

    public static void test(ArrayList<Iris> train, Iris test, int k) {
        int[] minIndexes = new int[k];
        double[] minDistances = new double[k];
        for (int i = 0; i < minDistances.length; i++)
            minDistances[i] = Double.MAX_VALUE;

        for (int i = 0; i < train.size(); i++) {
            for (int ki = 0; ki < k; ki++) {
                double distanceTmp = test.distance(train.get(i));
                if (distanceTmp < minDistances[ki]) {
                    minDistances[ki] = distanceTmp;
                    minIndexes[ki] = i;
                    break;
                }
            }
        }
        int is = 0, ive = 0, ivi = 0;
        for (int i = 0; i < k; i++) {
            if (train.get(minIndexes[i]).getResault().equals("Iris-setosa"))
                is++;
            else if (train.get(minIndexes[i]).getResault().equals("Iris-versicolor"))
                ive++;
            else if (train.get(minIndexes[i]).getResault().equals("Iris-virginica"))
                ivi++;
        }

        double accuracy = 0.5;
        System.out.print(test);
        if (is > ive && is > ivi) {
            accuracy = is / (double) k;
            System.out.println(" wynik: Iris-setosa, dokladnosc: " + accuracy);
        } else if (ive > is && ive > ivi) {
            accuracy = ive / (double) k;
            System.out.println(" wynik: Iris-versicolor, dokladnosc: " + accuracy);
        } else if (ivi > ive && ivi > is) {
            accuracy = ivi / (double) k;
            System.out.println(" wynik: Iris-virginica, dokladnosc: " + accuracy);
        } else
            System.out.println(" nie można rozstrzygnać, dokladność: Iris-setosa:" + is / (double) k + " Iris-versicolor:" + ive / (double) k + " Iris-virginica:" + ivi / (double) k);

    }
}
