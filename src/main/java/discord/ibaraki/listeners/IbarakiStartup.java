package discord.ibaraki.listeners;

import net.dv8tion.jda.api.JDA;
import org.springframework.stereotype.Component;

@Component
public class IbarakiStartup {
    public IbarakiStartup(JDA jda) throws InterruptedException {
        jda.awaitReady();
        System.out.println("Ibaraki is ready");
    }
}
