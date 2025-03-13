/**
 * Created by Ritabrata
 */

package callbacks;

import java.io.IOException;

public class FileDownloader {
    public boolean isValid(String url) {
        return url.endsWith(".zip") || url.endsWith(".xml");
    }
    void downloadFile(String url, DownloadCallback callback) throws IOException, InterruptedException {
        if(isValid(url)) {
            callback.onSuccess("File format is supported");
        }
        else {
            callback.onFailure();
        }

    }
}
