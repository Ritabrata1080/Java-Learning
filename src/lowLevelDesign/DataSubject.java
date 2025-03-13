package lowLevelDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ritabrata
 */

public class DataSubject {
    private List<DataObserver> observers = new ArrayList<>();
    private String data;

    // Register an observer
    public void addObserver(DataObserver observer) {
        observers.add(observer);
    }

    // Notify all observers when data is updated
    private void notifyObservers() {
        for (DataObserver observer : observers) {
            observer.onDataUpdated(data);
        }
    }

    // Update data and notify observers
    public void updateData(String newData) {
        this.data = newData;
        notifyObservers();
    }
}
