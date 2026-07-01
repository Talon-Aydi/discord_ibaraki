package discord.ibaraki.records;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("command_responses")
public record CommandResponse(
        @Id Integer id,
        @Column("command_id") Long commandId,
        @Column("text") String text
) {
}
