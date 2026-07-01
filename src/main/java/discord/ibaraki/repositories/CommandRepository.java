package discord.ibaraki.repositories;

import discord.ibaraki.records.Command;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends ListCrudRepository<Command, Long> {
}