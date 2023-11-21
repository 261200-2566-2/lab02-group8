public class lab2 {
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
        System.out.println("How many ProMax model = "+ AirPurifier.numberOfThisModel("ProMax"));
        System.out.println(" ");
        System.out.println("a1 power: "+ a1.power );
        a1.turnOn();
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
        System.out.println("a2 after changeMode(sleep): ");
        a2.showDisplay();
        a2.setMode("custom");
        System.out.println("a2 after changeMode(custom): ");
        a2.showDisplay();
    }
}
