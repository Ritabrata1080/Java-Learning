/**
 * Created by Ritabrata, 22/12/2024
 *
 * factorialAsyncTask.java -> Calculates Factorial of a number through async operation
 */

package asyncTasks;

import java.util.concurrent.*;

public class factorialAsyncTask {

    public static Future<Integer> computeAddition(int[] a, ExecutorService executorService){
        return executorService.submit(() -> {
            int sum = 0;
            for(int p : a){
                sum += p;
            }
            return sum;
        });
    }

    // Method to compute factorial asynchronously
    public static Future<Long> computeFactorial(int number, ExecutorService executor) {
        return executor.submit(() -> {
            if (number < 0) {
                throw new IllegalArgumentException("Number must be non-negative");
            }
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        });
    }

    public static void main(String[] args) {
        // Number to compute the factorial of
        int number = 5;
        int[] nums = {12,3,5,7};

        // Create a thread pool using ExecutorService
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            // Submit the task and get the Future object
            Future<Long> futureResult = computeFactorial(number, executor);
            Future<Integer> futureResult1 = computeAddition(nums, executor);

            // Simulate doing other tasks while factorial is being calculated
            System.out.println("Performing factorial operations...");

            // Get the result of the computation
            long factorial = futureResult.get(); // Blocks until computation is complete
            System.out.println("Factorial of " + number + " is: " + factorial);
            System.out.println("Performing sum operations...");
            int resultSum = futureResult1.get();
            Thread.sleep(3000);

            System.out.println("Sum of array is: " + resultSum);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error occurred during computation: " + e.getMessage());
        } finally {
            // Shut down the executor to free resources
            executor.shutdown();
        }
    }
}
