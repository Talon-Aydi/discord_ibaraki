package discord.ibaraki.service;

import discord.ibaraki.records.CommandResponse;
import discord.ibaraki.repositories.CommandResponseRepository;
import org.springframework.stereotype.Service;

@Service
public class CommandResponseService {
    private final CommandResponseRepository commandResponseRepository;

    public CommandResponseService(CommandResponseRepository commandResponseRepository) {
        this.commandResponseRepository = commandResponseRepository;
    }

    public CommandResponse getResponse(Long commandId)
    {
        return commandResponseRepository.getCommandResponseByCommandId(commandId);
    }
}
