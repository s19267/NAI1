import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {
    public static Iris readFromStandardIn(){
        Scanner scanner=new Scanner(System.in);
        Double[] tmp=new Double[4];
        System.out.println("podaj 4 wartości:");
        tmp[0]=scanner.nextDouble();
        if(tmp[0]==0)
            return null;
        tmp[1]=scanner.nextDouble();
        tmp[2]=scanner.nextDouble();
        tmp[3]=scanner.nextDouble();
        System.out.println("podaj wynik:");
        String result = scanner.nextLine();
        result = scanner.nextLine();
        return new Iris(result,tmp[0],tmp[1],tmp[2],tmp[3]);
    }

    public static ArrayList<Iris> readFromFile(String file) throws FileNotFoundException {
        ArrayList<Iris> listIris=new ArrayList<>();
        Scanner scanner=new Scanner(new File(file));

            while (scanner.hasNextLine()){
                String tmp=scanner.nextLine();
                String[] info=tmp.split(",");
                double[] infoDouble=new double[info.length-1];
                for(int i=0;i<infoDouble.length;i++){
                    infoDouble[i] = Double.parseDouble(info[i]);
                }

            Iris iris=new Iris(info[4],infoDouble[0],infoDouble[1],infoDouble[2],infoDouble[3]);

            listIris.add(iris);
        }
        return listIris;
    }
}
