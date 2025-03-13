/**
 * Created by Ritabrata
 */

package callbacks;

import java.io.IOException;

public interface DownloadCallback {
    void onSuccess(String result) throws InterruptedException;
    void onFailure() throws IOException;
}
