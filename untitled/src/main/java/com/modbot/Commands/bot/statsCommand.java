package com.modbot.Commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class statsCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("stats")){
            EmbedBuilder eb = new EmbedBuilder();
            String botAuthor = "Unicode#6658";
            String website = "None";
            int shardId = event.getJDA().getShardInfo().getShardId();
            int servers = event.getJDA().getShardManager().getGuilds().size();
            int textChannels = event.getJDA().getShardManager().getTextChannels().size();
            int voiceChannels = event.getJDA().getShardManager().getVoiceChannels().size();
            int channels = textChannels + voiceChannels;
            int members = event.getJDA().getShardManager().getUsers().size();
            long memoryTotal1 = Runtime.getRuntime().totalMemory();
            long memoryFree1 = Runtime.getRuntime().freeMemory();

            long memoryTotal = memoryTotal1 / 1048576;
            long memoryFree = memoryFree1 / 1048576;

            long memoryUsing = memoryTotal - memoryFree;


            final long duration = ManagementFactory.getRuntimeMXBean().getUptime();

            final long years = duration / 31104000000L;
            final long months = duration / 2592000000L % 12;
            final long days = duration / 86400000L % 30;
            final long hours = duration / 3600000L % 24;
            final long minutes = duration / 60000L % 60;
            final long seconds = duration / 1000L % 60;
            // final long milliseconds = duration % 1000;

            String uptime = (years == 0 ? "" : "**" + years + "y** ") + (months == 0 ? "" : "**" + months + "mm** ") + (days == 0 ? "" : "**" + days + "d** ") + (hours == 0 ? "" : "**" + hours + "** h, ")
                    + (minutes == 0 ? "" : "**" + minutes + "m** ") + (seconds == 0 ? "" : "**" + seconds + "s** ") /* + (milliseconds == 0 ? "" : milliseconds + " Milliseconds, ") */;


            eb.setDescription("**<:modbotzin:991131805212221440> ModBot v0.20.22**\n**[Official Bot Sevrer Invite](https://discord.gg/7XGwzTGDka)**");
            eb.addField("**Author**", "[Unicode#6658](https://discord.gg/7XGwzTGDka)", true);
            eb.addField("**Shard**", ""+shardId, true);
            eb.addField("**Uptime**", uptime, true);
            eb.addField("**Servers**", ""+servers, true);
            eb.addField("**Channels**", ""+channels, true);
            eb.addField("**Members**", ""+members, true);
            eb.addField("**Memory Usage**", memoryUsing + "Mb / " + memoryTotal + "Mb", true);

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
