package discord.ibaraki.records;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("commands")
public record Command (
        @Id Long id,
        String name,
        @Column("server_id") Long serverId,
        @Column("command_type_id") Long commandTypeId
) { }