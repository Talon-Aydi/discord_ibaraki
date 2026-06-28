package discord.ibaraki.Listeners;

import discord.ibaraki.helpers.JsonHelper;
import discord.ibaraki.records.Command;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MessageListener extends ListenerAdapter {
    private final Map<String, Command> commandCache = new HashMap<>();
    private Command command;

    public MessageListener() {
        Dotenv dotenv = Dotenv.load();
        String jsonPath = dotenv.get("COMMAND_LISTENER_PATH") != null ? dotenv.get("COMMAND_LISTENER_PATH") : System.getenv("COMMAND_LISTENER_PATH");

        JSONObject json = JsonHelper.read(jsonPath);
        JSONObject commands = json.getJSONObject("commands");

        System.out.println(json);
        for (String key : commands.keySet()) {
            JSONObject innerData = commands.getJSONObject(key);

            String response = innerData.getString("response");
            String emote = innerData.getString("emote");

            commandCache.put(key.toLowerCase(), new Command(response, emote));
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw().toLowerCase();
        if (commandCache.containsKey(message)) {

            command = commandCache.get(message);
            String finalReply = command.response() + " " + command.emote();
            event.getChannel().sendMessage(finalReply).queue();
        }
    }
}
