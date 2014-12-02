import java.util.concurrent.Semaphore;

public class Parking {

    public Semaphore semaphore;
    public Parking() {
        super();
        this.semaphore = new Semaphore(2);
    }
}
