package discord.ibaraki.listeners;

import discord.ibaraki.helpers.CommandLoader;
import discord.ibaraki.records.Command;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MessageListener extends ListenerAdapter {
    private final CommandLoader loader;

    public MessageListener(CommandLoader loader) {
        this.loader = loader;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw().toLowerCase();

        Command cmd = loader.get(message);

        if (cmd != null) {
            event.getChannel().sendMessage(
                    cmd.response() + " " + cmd.emote()
            ).queue();
        }
    }
}
