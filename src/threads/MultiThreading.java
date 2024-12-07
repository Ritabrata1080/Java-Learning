/**
 * Created by Ritabrata
 */

package threads;

public class MultiThreading {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
//            ThreadImplementationWithExtends threadImplementation = new ThreadImplementationWithExtends(i);
//            threadImplementation.start(); // start() will start a new thread apart from the main thread
            threadImplementationWithInterface threadImplementationWithInterface
                    = new threadImplementationWithInterface(i);
            Thread myThread = new Thread(threadImplementationWithInterface);
            myThread.start();
            try {
                myThread.join(); // This will make sure to hault the execution unless the prior thread has completed execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myThread.isAlive(); // This will provide us boolean value of whether a thread is active or not
        }
    }
}
