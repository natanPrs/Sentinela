package com.sentinela.Sentinela;

import com.sentinela.Sentinela.events.MemberJoin;
import com.sentinela.Sentinela.commands.Ping;
import com.sentinela.Sentinela.events.MemberLeave;
import com.sentinela.Sentinela.events.StudyValidation;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SentinelaApplication {

	public static JDA jda;
	public static Map<Long, Character> prefixMap = new HashMap<>();

	public static void main(String[] args) throws LoginException, InterruptedException {
		jda = JDABuilder.create(System.getenv("DISCORD_BOT_TOKEN"),
				EnumSet.allOf(GatewayIntent.class)).build();

		jda.addEventListener(new Ping());
		jda.addEventListener(new MemberJoin());
		jda.addEventListener(new MemberLeave());
		jda.addEventListener(new StudyValidation());


		for(Guild guild: jda.awaitReady().getGuilds()) {
			prefixMap.put(guild.getIdLong(), '!');
		}


	}

}
