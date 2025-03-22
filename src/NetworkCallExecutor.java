/**
 * Created by Ritabrata
 */

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class NetworkCallExecutor {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static JLabel resultLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NetworkCallExecutor::createAndShowUI);
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Network Call Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JButton fetchButton = new JButton("Fetch Data");
        resultLabel = new JLabel("Result will appear here", SwingConstants.CENTER);

        fetchButton.addActionListener(e -> performNetworkCall());

        frame.add(fetchButton, BorderLayout.NORTH);
        frame.add(resultLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static void performNetworkCall() {
        resultLabel.setText("Fetching data...");

        Future<String> future = executorService.submit(NetworkCallExecutor::mockAsyncServer);

        // Use a separate thread to wait for the response and update the UI
        executorService.execute(() -> {
            try {
                String response = future.get(); // Waits for async task to complete
                SwingUtilities.invokeLater(() -> resultLabel.setText(response));
            } catch (Exception e) {
                SwingUtilities.invokeLater(() -> resultLabel.setText("Error fetching data"));
            }
        });
    }

    // Simulated async mock server call
    private static String mockAsyncServer() throws InterruptedException {
        Thread.sleep(3000); // Simulate network delay
        return "Mock Server Response: Data received!";
    }
}
