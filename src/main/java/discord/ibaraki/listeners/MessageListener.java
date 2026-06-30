package discord.ibaraki.listeners;

import discord.ibaraki.records.Command;
import discord.ibaraki.service.CommandService;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageListener extends ListenerAdapter {
    private final CommandService commandService;

    public MessageListener(CommandService commandService) {
        this.commandService = commandService;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw().toLowerCase();

        List<Command> commands = commandService.getCommands();
        if (commands != null) {
            for (Command command : commands) {
                System.out.println(command.name());
                if (command.name().equalsIgnoreCase(message)) {
                    event.getChannel().sendMessage("You tried the following command: " + command.name());
                    break;
                }
            }
        }
    }
}
