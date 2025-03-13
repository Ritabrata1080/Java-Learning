package lowLevelDesign;

/**
 * Created by Ritabrata
 */

public class Client implements ServerListener, DataObserver {
    private DataSubject dataSubject;

    public Client(DataSubject dataSubject) {
        this.dataSubject = dataSubject;
        dataSubject.addObserver(this);
    }

    // Observer method: Reacts to data updates
    @Override
    public void onDataUpdated(String data) {
        System.out.println("Observer: Data Updated - " + data);
    }

    // Listener method: Reacts to server response
    @Override
    public void onResponse(String data) {
        System.out.println("Listener: Received from Server - " + data);
        dataSubject.updateData(data);
    }
}
