package discord.ibaraki.listeners;

import discord.ibaraki.helpers.JsonHelper;
import discord.ibaraki.records.Command;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MessageListener extends ListenerAdapter {
    private final Map<String, Command> commandCache = new HashMap<>();

    public MessageListener() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        String jsonPath = dotenv.get("COMMAND_LISTENER_PATH") != null ?
                dotenv.get("COMMAND_LISTENER_PATH")
                : System.getenv("COMMAND_LISTENER_PATH");

        if (jsonPath == null || jsonPath.isEmpty()) {
            System.err.println("WARNING: COMMAND_LISTENER_PATH environment variable is missing!");
            return;
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw().toLowerCase();
        if (commandCache.containsKey(message)) {

            Command command = commandCache.get(message);
            String finalReply = command.response() + " " + command.emote();
            event.getChannel().sendMessage(finalReply).queue();
        }
    }
}
