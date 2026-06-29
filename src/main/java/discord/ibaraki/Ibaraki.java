package discord.ibaraki;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ibaraki {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Ibaraki.class)
                .run(args);

        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        String token = dotenv.get("DISCORD_TOKEN") != null ? dotenv.get("DISCORD_TOKEN") : System.getenv("DISCORD_TOKEN");

        if (token == null || token.isEmpty()) {
            System.err.println("CRITICAL ERROR: DISCORD_TOKEN is missing from both system environment and .env file!");
            System.exit(1);
        }

        JDABuilder.createDefault(token)
                .build();
    }
}
