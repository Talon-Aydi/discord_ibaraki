package discord.ibaraki.service;

import discord.ibaraki.records.ServerMod;
import discord.ibaraki.repositories.CommandRepository;
import discord.ibaraki.repositories.ServerModRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ServerModService {
    private final ServerModRepository serverModRepository;

    public ServerModService(ServerModRepository serverModRepository) {
        this.serverModRepository = serverModRepository;
    }

    public void createUser(ServerMod serverMod) {
        try {
            serverModRepository.save(serverMod);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    public ServerMod getUser(String user_id) {
        return serverModRepository.findServerModByUserId(user_id);
    }

}
