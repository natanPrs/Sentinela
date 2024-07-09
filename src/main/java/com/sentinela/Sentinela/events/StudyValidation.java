package com.sentinela.Sentinela.events;

import com.sentinela.Sentinela.SentinelaApplication;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class StudyValidation extends ListenerAdapter {

    private final Random random = new Random();
    private Timer timer = new Timer();
    private boolean messageSent = false;

    @Override
    public void onReady(ReadyEvent event) {
        scheduleRandomMessage();
    }


    private void scheduleRandomMessage() {
        if (!messageSent) {
            sendRandomMessage();
            messageSent = true;
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                messageSent = false;
            }
        }, TimeUnit.MINUTES.toMillis(50));
    }

    private void sendRandomMessage() {
        Guild guild = SentinelaApplication.jda.getGuildById("1184619317527072768");
        if (guild != null) {
            List<VoiceChannel> voiceChannels = guild.getVoiceChannels();
            for (VoiceChannel voiceChannel : voiceChannels) {
                if (!voiceChannel.getMembers().isEmpty()) {
                    voiceChannel.getGuild().getTextChannelById("1184619318382698509").sendMessage("Será que tem alguém estudando? Estou vendo pessoas na Call. Sou cético, só acredito vendo. Então, cadê o print?\n").queue();
                    return;
                }
            }
        }
    }
}
