import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AirPurifier {
    String model ;
    String serialNo;
    boolean power = false;
    String mode = "auto";
    private int speedFan = 1;
    int pm = (int) (Math.random() * 370) ;
    static ArrayList<String> allModel = new ArrayList<>();
    static ArrayList<Integer> numberOfEachModel = new ArrayList<>();
    static int modelCount(){
        return allModel.size();
    }
    static int numberOfAPF = 0;
    static String mostPopularModel(){
        int maxNumber = Collections.max(numberOfEachModel);
        int index = numberOfEachModel.indexOf(maxNumber);
        return allModel.get(index);
    }
    static int numberOfThisModel(String model){
        int index = allModel.indexOf(model);
        return numberOfEachModel.get(index);
    }
    void showDisplay(){
        System.out.println("______________________" );
        System.out.println("  SerialNo : "+serialNo);
        System.out.println("     Model : "+model);
        System.out.println("        Pm : "+pm);
        System.out.println("      PmLv : "+ pmLv());
        if(power) System.out.println("     Power : on" );
        else System.out.println("     Power : off" );
        System.out.println("      Mode : "+mode );
        System.out.println("  speedFan : "+speedFan);
        System.out.println("______________________" );
    }
    void turnOn(){ power = true; }
    void turnOff(){ power = false; }
    void toggleOnOff(){ power = !power;}
    void setMode(String _mode){
        if(_mode.equals("auto") || _mode.equals("sleep" ) || _mode.equals("custom") ){
            this.mode = _mode;
        }else {
            System.out.println("This mode does not exist.");
            return;
        }

        this.setSpeedFan();
    }

    String pmLv(){
        String Lv = "Safe";
        if(pm<=64) Lv = "Safe";
        if(pm>64 && pm<=124)  Lv = "Moderate";
        if(pm>124)  Lv = "Unhealthy";
        return Lv;
    }
    void setSpeedFan(){
        if(this.mode.equals("sleep")) speedFan = 1;
        if(this.mode.equals("custom")){
            Scanner s = new Scanner(System.in);
            System.out.println("[Custom Mode] Enter the fan speed :");
            int speed = s.nextInt();
            if(speed >= 1 && speed <= 3){
                speedFan = speed;
            } else{
                System.out.println("speedFan should be between 1 to 3.");
                setSpeedFan();
            }
        }
        if(this.mode.equals("auto")){
            if(pm<=64) speedFan = 1;
            if(pm>64 && pm<=124) speedFan =2;
            if(pm>124) speedFan = 3;
        }
    }
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
        this.setSpeedFan();
    }
    AirPurifier(String serialNo){
        this("Pro",serialNo);
    }
}