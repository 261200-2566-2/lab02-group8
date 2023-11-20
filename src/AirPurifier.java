import java.util.ArrayList;
import java.util.Collections;

public class AirPurifier {
    String model = "Pro";
    String serialNo;
    boolean power = false;
    String mode = "auto";
    static ArrayList<String> allModel = new ArrayList<>();
    static ArrayList<Integer> numberOfEachModel = new ArrayList<>();
    static int modelCount(){
        return allModel.size();
    };
    static int numberOfAPF = 0;
    static String mostPopularModel(){
        int maxNumber = Collections.max(numberOfEachModel);
        int index = numberOfEachModel.indexOf(maxNumber);
        return allModel.get(index);
    };
    static int numberOfThisModel(String model){
        int index = allModel.indexOf(model);
        return numberOfEachModel.get(index);
    }
    void showDisplay(){
        System.out.println("______________________" );
        System.out.println("  SerialNo : "+serialNo);
        System.out.println("     Model : "+model);
        if(power == true) System.out.println("     Power : on" );
        else System.out.println("     Power : off" );
        System.out.println("      Mode : "+mode );
        System.out.println("______________________" );
    }
    void turnOn(){ power = true; }
    void turnOff(){ power = false; }
    void toggleOnOff(){ power = !power;}
    void setMode(String mode){ this.mode = mode;}
    AirPurifier(String model,String serialNo){
        this.model = model;
        this.serialNo = serialNo;
        if(!allModel.contains(model)){
            allModel.add(model);
            numberOfEachModel.add(1);
        } else{
            int index = allModel.indexOf(model);
            numberOfEachModel.set(index,numberOfEachModel.get(index)+1);
        }
        numberOfAPF++;
    }
    AirPurifier(String serialNo){
        this("Pro",serialNo);
    }
    public static void main(String[] args) {
        AirPurifier a1 = new AirPurifier("001");
        AirPurifier a2 = new AirPurifier("ProMax","002");
        AirPurifier a3 = new AirPurifier("ProMax","003");
        AirPurifier a4 = new AirPurifier("ProMaxPlus","004");
        a1.showDisplay();
        a2.showDisplay();
        a3.showDisplay();
        a4.showDisplay();
        System.out.println(" ");
        System.out.println("ModelCount = "+ AirPurifier.modelCount() );
        System.out.println("MostPopular = "+ AirPurifier.mostPopularModel() );
        System.out.println("How many AirPurifier = "+ AirPurifier.numberOfAPF );
        System.out.println("How many Pro model = "+ AirPurifier.numberOfThisModel("Pro"));
        System.out.println(" ");
        System.out.println("a1 power: "+ a1.power );
        a1.turnOn();;
        System.out.println("a1 after turnOn: "+ a1.power );
        a1.turnOff();
        System.out.println("a1 after turnOff: "+ a1.power );
        a1.toggleOnOff();
        System.out.println("a1 after toggleOnOff: "+ a1.power );
        a1.toggleOnOff();
        System.out.println("a1 after toggleOnOff: "+ a1.power );
        System.out.println(" ");
        System.out.println("a2 mode: "+ a2.mode );
        a2.setMode("sleep");
        System.out.println("a2 after changeMode: "+ a2.mode );
        a2.setMode("custom");
        System.out.println("a2 after changeMode: "+ a2.mode );
    }
}