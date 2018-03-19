package nl.stormnetwork.stormbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;
import java.util.Map;

public class Main {
    Map<String, String> env = System.getenv();


    public static void main(String[] args) throws LoginException {
        System.out.println("STARTING");
        // Note: It is important to register your ReadyListener before building
        JDA jda = new JDABuilder(AccountType.BOT)
                .setToken(ID.TOKEN)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setGame(Game.playing("Laden..."))
                .buildAsync();

        jda.addEventListener(new MessageReceived());
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setGame(Game.playing("STBot"));

    }

}