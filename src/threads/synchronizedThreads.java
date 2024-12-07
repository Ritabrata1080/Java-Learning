/**
 * Created by Ritabrata
 */

package threads;


class counterLogic {
    int count = 0;

    // Synchronize the increment method to get the final count value properly
    // Synchronized will ensure only one thread works with this incrementCount()
    // It's kind of a critical section logic where a method can be accessed by one thread at a time.
    public synchronized void incrementCount() {
        count++;
    }
}

public class synchronizedThreads {
    public static void main(String[] args) throws InterruptedException {
        counterLogic c = new counterLogic();

        /**
         * The new Runnable() method is now deprecated and can be replaced by Lambda function
         * as done in the second thread. But keeping this convention for a better understanding
         * of how the run() of the thread class gets overridden
         */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 1001; i++) {
                    c.incrementCount();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 1001; i++) {
                c.incrementCount();
            }
        });

        t1.start();
        t2.start();

        t1.join(); // Hault the main thread to complete the job of t1 and then print the count
        t2.join(); // Hault the main thread to complete the job of t2 and then print the count

        System.out.println("Counter value is : " + c.count);

    }
}
