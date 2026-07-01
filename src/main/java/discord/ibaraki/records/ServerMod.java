package discord.ibaraki.records;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("server_mods")
public record ServerMod (
        @Id Integer id,
        String name,
        @Column("permissions") String permission,
        @Column("user_id") String userId
){}