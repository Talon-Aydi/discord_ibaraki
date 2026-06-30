package discord.ibaraki.repositories;

import discord.ibaraki.records.Command;
import org.springframework.data.repository.ListCrudRepository;

public interface CommandRepository extends ListCrudRepository<Command, Long> {
}