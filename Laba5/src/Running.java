import java.util.Random;

public class Running {

    public static void main(String args[]) {
        Parking p = new Parking();

        Car[] cars = new Car[5];

        for (int i = 0;i<cars.length;i++){
            cars[i] = new Car(""+i,p);
        }

        for (int i = 0;i<cars.length;i++){
            cars[i].start();
            Random rnd = new Random();
            try {
                Thread.sleep(rnd.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

