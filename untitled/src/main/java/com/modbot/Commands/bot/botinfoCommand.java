package com.modbot.Commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.jetbrains.annotations.NotNull;

import java.lang.management.ManagementFactory;

public class botinfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("botinfo")) {
            String user = event.getMember().getUser().getAsMention();
            int servers = event.getJDA().getShardManager().getGuilds().size();

            final long duration = ManagementFactory.getRuntimeMXBean().getUptime();

            final long years = duration / 31104000000L;
            final long months = duration / 2592000000L % 12;
            final long days = duration / 86400000L % 30;
            final long hours = duration / 3600000L % 24;
            final long minutes = duration / 60000L % 60;
            final long seconds = duration / 1000L % 60;
            // final long milliseconds = duration % 1000;

            String uptime = (years == 0 ? "" : "**" + years + "y** ") + (months == 0 ? "" : "**" + months + "mm** ") + (days == 0 ? "" : "**" + days + "d** ") + (hours == 0 ? "" : "**" + hours + "** Hours, ")
                    + (minutes == 0 ? "" : "**" + minutes + "m** ") + (seconds == 0 ? "" : "**" + seconds + "s** ") /* + (milliseconds == 0 ? "" : milliseconds + " Milliseconds, ") */;


            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("<:modbotzin:991131805212221440>Hello, my name is ModBot!");
            eb.setDescription("Hello, my name is ModBot, and I'm a simple Brazilian bot for discord, with many incredible functions and never seen before!\n" +
                    "\nI'm currently spreading fun in **" + servers + " servers** with some innovative commands. I woke up " + uptime + " ago." +
                    " Since October 9, 2020 trying to make Discord the best place possible!\n" +
                    "\nI was developed in " +
                    "<:java:1000815420808368180> **[Java](https://www.java.com/pt-BR/download/help/whatis_java.html)** using " +
                    "<:jda:877978995252158504> **[JDA](https://github.com/DV8FromTheWorld/JDA)** and, if you want to see my source code (to see how my FIRST version was made), " +
                    "[click here](https://github.com/whoisnicolasadm)!\n\nIf you want to check out my website, click here, and if you want to add me to your server, " +
                    "[click here](https://discord.com/api/oauth2/authorize?client_id=764140529041670154&permissions=8&scope=applications.commands%20bot)!\n");
            eb.addField("<:modbotzin:991131805212221440>**Add me!**", "[Invite me!](https://discord.com/api/oauth2/authorize?client_id=991128428596183160&permissions=8&scope=applications.commands%20bot)", true);
            eb.addField("<:review:1000814923380707369>**Commands**", "[My commands!](https://joasknuicolas.wixsite.com/modbot/copy-of-faq)", true);
            eb.addField("<:firewall:1000815413267005470>**Support & Help**", "[My support server](https://discord.gg/7XGwzTGDka)", true);
            eb.addField("**<:github:1001671958204792894>Dev's GitHub**", "[GitHub](https://github.com/whoisnicolasadm)", true);
            eb.addField("**<:twitter:1001672138324988025>Dev's Twitter**", "[Twitter](https://twitter.com/SrUnicode)", true);
            eb.addField("**<:youtube:1001672248559685632>Dev's Youtube**", "[Youtube](https://www.youtube.com/channel/UCNKaVK3RufdYxEgYstD1DvQ)", true);
            eb.addField("<:dce_policia:1000814242443829381>**Honorable mention\n**", "•`Unicode#6658`, my creator, if it weren't for him I wouldn't exist\n•All the **" + servers + " servers** that welcomed me\n•And you, " + user + " for talking to me. Keep being an amazing person!", false);

            event.replyEmbeds(eb.build()).queue();
        }


    }
}

