package com.sentinela.Sentinela.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        TextChannel textChannel = event.getGuild().getTextChannelById(1259003216734191737L);
        String userName = event.getUser().getName();

        textChannel.sendMessage("("+ userName + ") entrou pro grupo dos gola alta!").queue();
    }
}
