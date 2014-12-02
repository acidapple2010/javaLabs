import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car extends Thread{

    private String nameCar;
    private Parking places;

    public Car(String nameThread,Parking places) {
        super();
        this.nameCar = nameThread;
        this.places = places;
    }

    @Override
    public void run(){
        super.run();
        System.out.println(nameCar + " заехал на парковку.");
            try {
                Random rnd = new Random();
                if(!(places.semaphore.tryAcquire(rnd.nextInt(5000)+1000, TimeUnit.MILLISECONDS))) {
                    System.out.println(nameCar + " не дождался, уехал с парковки.");
                    return;
                }

                System.out.println(nameCar + " занял место.");
                sleep(rnd.nextInt(8000)+2000);
                System.out.println(nameCar + " освободил место, уехал с парковки.");
                places.semaphore.release();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
