package discord.ibaraki.records;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("commands")
public record Command (@Id Long id, String name, String response, String emote) { }
