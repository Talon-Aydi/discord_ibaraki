package discord.ibaraki.repositories;

import discord.ibaraki.records.CommandResponse;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandResponseRepository extends ListCrudRepository<CommandResponse, Long> {
    CommandResponse getCommandResponseByCommandId(Long commandId);
}
