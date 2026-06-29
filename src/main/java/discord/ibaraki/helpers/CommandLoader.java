package discord.ibaraki.helpers;

import discord.ibaraki.records.Command;
import jakarta.annotation.PostConstruct;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommandLoader {
    private final Map<String, Command> commands = new HashMap<>();

    @PostConstruct
    public void init() {
        JSONObject json = read();

        if (!json.has("commands")) return;

        JSONObject cmds = json.getJSONObject("commands");

        for (String key : cmds.keySet()) {
            JSONObject obj = cmds.getJSONObject(key);

            commands.put(
                    key.toLowerCase(),
                    new Command(
                            obj.getString("response"),
                            obj.getString("emote")
                    )
            );
        }
    }

    public Command get(String key) {
        return commands.get(key.toLowerCase());
    }

    private JSONObject read() {
        try (InputStream is = getClass().getResourceAsStream("/listeners/CommandListener.json")) {
            if (is == null) {
                System.err.println("Missing JSON: " + "/commands.json");
                return new JSONObject();
            }
            return new JSONObject(new JSONTokener(is));
        } catch (Exception e) {
            System.err.println("JSON error: " + e.getMessage());
            return new JSONObject();
        }
    }
}
