package com.sentinela.Sentinela.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberLeave extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {

        TextChannel textChannel = event.getGuild().getTextChannelById(1259003216734191737L);
        String userName = event.getUser().getName();

        textChannel.sendMessage("("+ userName + ") foi pra casa do k*lho!").queue();
    }
}
