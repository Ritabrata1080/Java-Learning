/**
 * Created by Ritabrata
 */

package callbacks;

import java.io.IOException;
import java.util.Scanner;

public class DownloadCallbackClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileDownloader fileDownloader = new FileDownloader();
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();
        fileDownloader.downloadFile(file, new DownloadCallback() {
            @Override
            public void onSuccess(String result) throws InterruptedException {
                System.out.println("File format is supported. Proceeding to download ...");
                Thread.sleep(5000);
                System.out.println("File downloaded successfully!!!");
            }

            @Override
            public void onFailure() throws IOException {
                throw new IOException("Only .zip and .xml file is supported!!!");

            }
        });
        sc.close();
    }
}
