package com.sentinela.Sentinela.commands;

import com.sentinela.Sentinela.SentinelaApplication;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

public class Ping extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");
        TextChannel textChannel = (TextChannel) event.getChannel();

        if (args[0].equalsIgnoreCase( SentinelaApplication.prefixMap.get(event.getGuild().getIdLong())+ "ping")) {

            textChannel.sendMessage((SentinelaApplication.jda.getGatewayPing()) + "ms").queue();
        }
    }
}