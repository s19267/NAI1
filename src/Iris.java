import java.util.ArrayList;

public class Iris {
    private ArrayList<Double> info=new ArrayList<>();
    private String resault;


    public Iris(String resault,double... coord){
        for(int i=0;i<coord.length;i++){
            info.add(coord[i]);
        }
        this.resault=resault;
    }

    public double distance(Iris iris){
       return Math.sqrt(Math.pow(this.getInfo(0)-iris.getInfo(0),2)+
                Math.pow(this.getInfo(1)-iris.getInfo(1),2)+
                Math.pow(this.getInfo(2)-iris.getInfo(2),2)+
                Math.pow(this.getInfo(3)-iris.getInfo(3),2));
    }

    private double getInfo(int i) {
        return info.get(i);
    }

    public String getResault() {
        return resault;
    }

    public void setResault(String resault) {
        this.resault = resault;
    }


    @Override
    public String toString() {
        return "Iris{" +
                "info=" + info +
                "correct= "+resault+
                '}';
    }

}
