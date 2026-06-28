package discord.ibaraki.helpers;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class JsonHelper {
    private JsonHelper() {
        throw new UnsupportedOperationException(" This is a utility class and cannot be instantiated");
    }

    public static JSONObject read(String fileName) {
        String path = fileName.startsWith("/") ? fileName : "/" + fileName;
        try (InputStream is = JsonHelper.class.getResourceAsStream(path)) {
            if (is == null) {
                System.err.println("Resource not found: " + path);
                return new JSONObject();
            }
            return new JSONObject(new JSONTokener(is));
        } catch (Exception e) {
            System.err.println("Failed to read JSON: " + e.getMessage());
            return new JSONObject();
        }
    }
}
