/**
 * Created by Ritabrata, 22/12/2024
 */

package asyncTasks;

import java.util.concurrent.*;

public class ECommerceOrderProcessing {

    // Simulates order validation
    public static CompletableFuture<Boolean> validateOrder(String orderId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Validating order: " + orderId);
            sleep(1000); // Simulate delay
            return orderId.startsWith("ORD");
        });
    }

    // Simulates checking product availability
    public static CompletableFuture<Boolean> checkProductAvailability(String productId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Checking availability for product: " + productId);
            sleep(1500); // Simulate delay
            return productId.equals("PROD123");
        });
    }

    // Simulates delivery charge calculation
    public static CompletableFuture<Double> calculateDeliveryCharges(String location) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating delivery charges for location: " + location);
            sleep(1200); // Simulate delay
            if (location.equals("Remote")) {
                return 50.0; // Remote locations have higher charges
            }
            return 20.0;
        });
    }

    // Simulates payment processing
    public static CompletableFuture<String> processPayment(String paymentDetails) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Processing payment with details: " + paymentDetails);
            sleep(2000); // Simulate delay
            return "PAYMENT_SUCCESS";
        });
    }

    // Simulates sending a notification
    public static CompletableFuture<Void> sendNotification(String userId) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Sending notification to user: " + userId);
            sleep(800); // Simulate delay
            System.out.println("Notification sent to user: " + userId);
        });
    }

    // Simulates a delay (blocking for demo purposes)
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) {
        String orderId = "ORD456";
        String productId = "PROD123";
        String location = "Remote";
        String paymentDetails = "Card123";
        String userId = "User001";

        System.out.println("Order processing started...");

        CompletableFuture<Void> orderProcess = validateOrder(orderId)
                .thenCompose(validOrder -> {
                    if (!validOrder) {
                        throw new RuntimeException("Order validation failed!");
                    }
                    return checkProductAvailability(productId);
                })
                .thenCompose(available -> {
                    if (!available) {
                        throw new RuntimeException("Product is not available!");
                    }
                    return calculateDeliveryCharges(location);
                })
                .thenCombine(processPayment(paymentDetails), (deliveryCharges, paymentStatus) -> {
                    if (!paymentStatus.equals("PAYMENT_SUCCESS")) {
                        throw new RuntimeException("Payment failed!");
                    }
                    System.out.println("Delivery Charges: $" + deliveryCharges);
                    System.out.println("Payment processed successfully!");
                    return null;
                })
                .thenComposeAsync(n -> sendNotification(userId))
                .exceptionally(e -> {
                    System.err.println("Error during order processing: " + e.getMessage());
                    return null;
                });

        // Wait for the entire process to complete
        orderProcess.join();

        System.out.println("Order processing completed!");
    }
}
