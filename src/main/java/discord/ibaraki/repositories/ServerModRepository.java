package discord.ibaraki.repositories;

import discord.ibaraki.records.ServerMod;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServerModRepository extends ListCrudRepository<ServerMod, Long> {
    ServerMod findServerModByUserId(String userId);
}
