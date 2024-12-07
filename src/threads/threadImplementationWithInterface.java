/**
 * Created by Ritabrata
 */

package threads;

/**
 * ### Better way to implement threaded code as it will allow the class to extend some other class and implement other interfaces too ###
 */

public class threadImplementationWithInterface implements Runnable {
    private int threadNumber;

    public threadImplementationWithInterface(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread : " + threadNumber);
            if (threadNumber == 2) {
                throw new RuntimeException();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
