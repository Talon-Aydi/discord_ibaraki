package discord.ibaraki.service;

import discord.ibaraki.records.Command;
import discord.ibaraki.repositories.CommandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {
    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public List<Command> getCommands() {
        return commandRepository.findAll();
    }
}
