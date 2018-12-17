/*
package Utils;

import com.saucelabs.saucerest.SauceREST;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created by kiranmaid on 8/9/18.
 *//*

public class SauceUtils {
    private static SauceREST sauceRESTClient;

    private static SauceREST getSauceRestClient(String username, String accessKey){
        if (sauceRESTClient == null) {
            sauceRESTClient = new SauceREST(username, accessKey);
        }
        return sauceRESTClient;
    }

    public static void UpdateResults(String username, String accessKey, boolean testResults, String sessionId)
            throws JSONException, IOException {
        SauceREST client = getSauceRestClient(username, accessKey);
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed", testResults);
        client.updateJobInfo(sessionId, updates);
    }
}
*/
