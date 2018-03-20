package nl.stormnetwork.stormbot;


import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import sun.plugin2.message.TextEventMessage;

public class MessageReceived extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        if (event.getAuthor().equals(jda.getSelfUser()))
            return;

        if (event.isFromType(ChannelType.PRIVATE)) {
            event.getChannel().sendMessage("Het heeft (nog) geen zin om een **private** bericht te sturen.").queue();
        } else if (event.isFromType(ChannelType.TEXT)) {

            TextChannel c;
            c = jda.getTextChannelById(ID.ChannelID);
            if (c != null) {
                MessageChannel m = event.getMessage().getTextChannel();
                Message M = event.getMessage();
                if (m.getId().equals(ID.IdeenChannelID)) {
                    M.addReaction("\uD83D\uDC4D").queue();
                    M.addReaction("\uD83D\uDC4E").queue();
                }

                if (M.getContentRaw().startsWith("!store")) {
                    m.sendMessage(":large_blue_circle: Het Buycraft linkie: http://stnetwerk.buycraft.net/ :large_blue_circle:").queue();
                } else if (M.getContentRaw().startsWith("!help")) {
                    m.sendMessage("**__COMMANDS__**").queue();
                    m.sendMessage("**!**store").queue();
                    m.sendMessage("**!**ip").queue();
                    m.sendMessage("**!**help").queue();


                } else if (M.getContentRaw().startsWith("!ip")) {
                    m.sendMessage(":large_blue_circle: Jordy speelt momenteel op het volgende **IP:** play.stormnetwork.nl :large_blue_circle:").queue();
                }


            }

        }
    }


}

