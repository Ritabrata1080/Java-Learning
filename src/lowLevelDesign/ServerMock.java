package lowLevelDesign;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ritabrata
 */

public class ServerMock {
    private ServerListener listener;

    // Register a listener
    public void setListener(ServerListener listener) {
        this.listener = listener;
    }

    // Simulate an asynchronous server call
    public void fetchData() {

        // Advantage of executorService over normal thread spawns
        /**
         * You can create/manage/control life cycle of Threads & optimize thread creation cost overheads
         * You can control processing of tasks ( Work Stealing, ForkJoinPool, invokeAll) etc.
         * You can schedule tasks in Future time
         * You can monitor the progress and health of threads
         */

        // FIXME : Uncomment this below ExecutorService in future to handle complex server responses
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        executor.submit(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2); // Simulate network delay
//                if (listener != null) {
//                    listener.onResponse("Server Response: Data Loaded");
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executor.shutdown();

        // FIXME : Invoke proper delay and fetch response from some API
        new Thread(() ->
        {
            try {

                Thread.sleep(2000);
                if (listener != null) {
                    listener.onResponse("Server response received!!!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }
}
