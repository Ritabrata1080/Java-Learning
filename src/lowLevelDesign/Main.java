package lowLevelDesign;

/**
 * Created by Ritabrata
 */
public class Main {
    public static void main(String[] args) {
        DataSubject dataSubject = new DataSubject();
        Client client = new Client(dataSubject);

        ServerMock serverMock = new ServerMock();
        serverMock.setListener(client);

        System.out.println("Fetching data from server...");
        serverMock.fetchData();
    }
}
