package discord.ibaraki.listeners;

import discord.ibaraki.records.Command;
import discord.ibaraki.records.CommandResponse;
import discord.ibaraki.records.ServerMod;
import discord.ibaraki.service.CommandResponseService;
import discord.ibaraki.service.CommandService;
import discord.ibaraki.service.ServerModService;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class MessageListener extends ListenerAdapter {
    private final CommandService commandService;
    private final CommandResponseService commandResponseService;

    public MessageListener(CommandService commandService, CommandResponseService commandResponseService, JdbcTemplate jdbcTemplate) {
        this.commandService = commandService;
        this.commandResponseService = commandResponseService;

        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            System.out.println("--- DATABASE CONNECTION TEST: SUCCESS! Result is " + result + " ---");
        } catch (Exception e) {
            System.err.println("--- DATABASE CONNECTION TEST: FAILED! ---");
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw().toLowerCase();
        System.out.println(event.getMessage().getStickers());
        List<Command> commands = commandService.getCommands();
        if (commands != null) {
            for (Command command : commands) {
                if (command.name().equalsIgnoreCase(message)) {
                    CommandResponse response = commandResponseService.getResponse(command.id());

                    event.getChannel().sendMessage(response.text()).queue();
                    break;
                }
            }
        }
    }
}
