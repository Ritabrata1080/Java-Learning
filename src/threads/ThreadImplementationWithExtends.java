/**
 * Created by Ritabrata
 */

package threads;

/**
 * ### Ways to create threads ###
 * <p>
 * 1. By implementing the Runnable interface
 * 2. By extending the Thread class
 */

/**
 * This method will show how we can extend Thread class to write threaded code
 */
public class ThreadImplementationWithExtends extends Thread {
    private int threadNumber;

    public ThreadImplementationWithExtends(int threadNumber) {
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
