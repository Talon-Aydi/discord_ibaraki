package discord.ibaraki;

import discord.ibaraki.listeners.MessageListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ibaraki {
    static void main(String[] args) {
        SpringApplication.run(Ibaraki.class, args);
        Dotenv dotenv = Dotenv.load();

        String token = dotenv.get("DISCORD_TOKEN") != null ? dotenv.get("DISCORD_TOKEN") : System.getenv("DISCORD_TOKEN");

        if (token == null || token.isEmpty()) {
            System.err.println("CRITICAL ERROR: DISCORD_TOKEN is missing from both system environment and .env file!");
            System.exit(1);
        }

        JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new MessageListener())
                .build();
    }
}
