package nl.stormnetwork.stormbot;


import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageReceived extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        if (event.getAuthor().equals(jda.getSelfUser()))
            return;

        if (event.isFromType(ChannelType.PRIVATE)) {
            event.getChannel().sendMessage("Het heeft (nog) geen zin om een **private** bericht te sturen.").queue();
        } else if (event.isFromType(ChannelType.TEXT)) {

            Guild g = jda.getGuildById(ID.ServerID);
            TextChannel c;
            if (g != null) {
                c = jda.getTextChannelById(ID.ChannelID);
                if (c != null) {
                    Message m = event.getMessage();
                    if (m.getChannel().getId().equals(ID.IdeenChannelID)) {
                        m.addReaction("\uD83D\uDC4D").queue();
                        m.addReaction("\uD83D\uDC4E").queue();
                    }

                    if (m.getContentRaw().startsWith("!forum")) {
                        c.sendMessage("https://forum.plopgroep.ga").queue();
                    }
                    else if (m.getContentRaw().startsWith("!help")) {
                        c.sendMessage("**__COMMANDS__**").queue();
                        c.sendMessage("**!**forum").queue();
                        c.sendMessage("**!**ip").queue();
                        c.sendMessage("**!**help").queue();


                    }
                    else if (m.getContentRaw().startsWith("!ip")) {
                        c.sendMessage("**IP:** play.stormnetwork.nl").queue();
                    }

                }

            }
        }


    }
}
