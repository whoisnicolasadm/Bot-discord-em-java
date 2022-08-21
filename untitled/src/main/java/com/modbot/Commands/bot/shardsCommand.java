package com.modbot.Commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class shardsCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("shards")){
            EmbedBuilder eb = new EmbedBuilder();
            int shardsTotal = event.getJDA().getShardInfo().getShardTotal();

            JDA.Status shardInfo = event.getJDA().getShardManager().getShardById(0).getStatus();
            JDA.Status shardInfo1 = event.getJDA().getShardManager().getShardById(1).getStatus();
            JDA.Status shardInfo2 = event.getJDA().getShardManager().getShardById(2).getStatus();
            JDA.Status shardInfo3 = event.getJDA().getShardManager().getShardById(3).getStatus();
            JDA.Status shardInfo4 = event.getJDA().getShardManager().getShardById(4).getStatus();
            JDA.Status shardInfo5 = event.getJDA().getShardManager().getShardById(5).getStatus();
            JDA.Status shardInfo6 = event.getJDA().getShardManager().getShardById(6).getStatus();
            JDA.Status shardInfo7 = event.getJDA().getShardManager().getShardById(7).getStatus();
            JDA.Status shardInfo8 = event.getJDA().getShardManager().getShardById(8).getStatus();
            JDA.Status shardInfo9 = event.getJDA().getShardManager().getShardById(9).getStatus();

            int shard0 = event.getJDA().getShardManager().getShardById(0).getGuilds().size();
            int shard1 = event.getJDA().getShardManager().getShardById(1).getGuilds().size();
            int shard2 = event.getJDA().getShardManager().getShardById(2).getGuilds().size();
            int shard3 = event.getJDA().getShardManager().getShardById(3).getGuilds().size();
            int shard4 = event.getJDA().getShardManager().getShardById(4).getGuilds().size();
            int shard5 = event.getJDA().getShardManager().getShardById(5).getGuilds().size();
            int shard6 = event.getJDA().getShardManager().getShardById(6).getGuilds().size();
            int shard7 = event.getJDA().getShardManager().getShardById(7).getGuilds().size();
            int shard8 = event.getJDA().getShardManager().getShardById(8).getGuilds().size();
            int shard9 = event.getJDA().getShardManager().getShardById(9).getGuilds().size();

            int shardUser0 = event.getJDA().getShardManager().getShardById(0).getUsers().size();
            int shardUser1 = event.getJDA().getShardManager().getShardById(1).getUsers().size();
            int shardUser2 = event.getJDA().getShardManager().getShardById(2).getUsers().size();
            int shardUser3 = event.getJDA().getShardManager().getShardById(3).getUsers().size();
            int shardUser4 = event.getJDA().getShardManager().getShardById(4).getUsers().size();
            int shardUser5 = event.getJDA().getShardManager().getShardById(5).getUsers().size();
            int shardUser6 = event.getJDA().getShardManager().getShardById(6).getUsers().size();
            int shardUser7 = event.getJDA().getShardManager().getShardById(7).getUsers().size();
            int shardUser8 = event.getJDA().getShardManager().getShardById(8).getUsers().size();
            int shardUser9 = event.getJDA().getShardManager().getShardById(9).getUsers().size();

            String message0;
            String message1;
            String message2;
            String message3;
            String message4;
            String message5;
            String message6;
            String message7;
            String message8;
            String message9;

            long shardPing = event.getJDA().getGatewayPing();


            int serversTotal = event.getJDA().getShardManager().getGuilds().size();
            int usersTotal = event.getJDA().getShardManager().getUsers().size();

            String emojiOnOff = null;
            String emojiOnOff1 = null;
            String emojiOnOff2 = null;
            String emojiOnOff3 = null;
            String emojiOnOff4 = null;
            String emojiOnOff5 = null;
            String emojiOnOff6 = null;
            String emojiOnOff7 = null;
            String emojiOnOff8 = null;
            String emojiOnOff9 = null;

            if (shardInfo == JDA.Status.CONNECTED) {
                emojiOnOff = "\uD83D\uDFE2";
                message0 = shardPing + " ms ping\n" + shardUser0 + " users\n" + shard0 + " guilds";
            }else if(shardInfo == JDA.Status.SHUTDOWN){
                emojiOnOff = "\uD83D\uDD34";
                message0 = "Offline";
            }else {
                emojiOnOff = "\uD83D\uDFE1";
                message0 = "Initializing";
            }

            if (shardInfo1 == JDA.Status.CONNECTED) {
                emojiOnOff1 = "\uD83D\uDFE2";
                message1 = shardPing + " ms ping\n" + shardUser1 + " users\n" + shard1 + " guilds";
            }else if(shardInfo1 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff1 = "\uD83D\uDD34";
                message1 = "Offline";
            }else {
                emojiOnOff1 = "\uD83D\uDFE1";
                message1 = "Initializing";
            }

            if (shardInfo2 == JDA.Status.CONNECTED) {
                emojiOnOff2 = "\uD83D\uDFE2";
                message2 = shardPing + " ms ping\n" + shardUser2 + " users\n" + shard2 + " guilds";
            }else if(shardInfo2 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff2 = "\uD83D\uDD34";
                message2 = "Offline";
            }else {
                emojiOnOff2 = "\uD83D\uDFE1";
                message2 = "Initializing";
            }

            if (shardInfo3 == JDA.Status.CONNECTED) {
                emojiOnOff3 = "\uD83D\uDFE2";
                message3 = shardPing + " ms ping\n" + shardUser3 + " users\n" + shard3 + " guilds";
            }else if(shardInfo3 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff3 = "\uD83D\uDD34";
                message3 = "Offline";
            }else {
                emojiOnOff3 = "\uD83D\uDFE1";
                message3 = "Initializing";
            }

            if (shardInfo4 == JDA.Status.CONNECTED) {
                emojiOnOff4 = "\uD83D\uDFE2";
                message4 = shardPing + " ms ping\n" + shardUser4 + " users\n" + shard4 + " guilds";
            }else if(shardInfo4 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff4 = "\uD83D\uDD34";
                message4 = "Offline";
            }else {
                emojiOnOff4 = "\uD83D\uDFE1";
                message4 = "Initializing";
            }

            if (shardInfo5 == JDA.Status.CONNECTED) {
                emojiOnOff5 = "\uD83D\uDFE2";
                message5 = shardPing + " ms ping\n" + shardUser5 + " users\n" + shard5 + " guilds";
            }else if(shardInfo5 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff5 = "\uD83D\uDD34";
                message5 = "Offline";
            }else {
                emojiOnOff5 = "\uD83D\uDFE1";
                message5 = "Initializing";
            }

            if (shardInfo6 == JDA.Status.CONNECTED) {
                emojiOnOff6 = "\uD83D\uDFE2";
                message6 = shardPing + " ms ping\n" + shardUser6 + " users\n" + shard6 + " guilds";
            }else if(shardInfo6 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff6 = "\uD83D\uDD34";
                message6 = "Offline";
            }else {
                emojiOnOff6 = "\uD83D\uDFE1";
                message6 = "Initializing";
            }

            if (shardInfo7 == JDA.Status.CONNECTED) {
                emojiOnOff7 = "\uD83D\uDFE2";
                message7 = shardPing + " ms ping\n" + shardUser7 + " users\n" + shard7 + " guilds";
            }else if(shardInfo7 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff7 = "\uD83D\uDD34";
                message7 = "Offline";
            }else {
                emojiOnOff7 = "\uD83D\uDFE1";
                message7 = "Initializing";
            }

            if (shardInfo8 == JDA.Status.CONNECTED) {
                emojiOnOff8 = "\uD83D\uDFE2";
                message8 = shardPing + " ms ping\n" + shardUser8 + " users\n" + shard8 + " guilds";
            }else if(shardInfo8 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff8 = "\uD83D\uDD34";
                message8 = "Offline";
            }else {
                emojiOnOff8 = "\uD83D\uDFE1";
                message8 = "Initializing";
            }

            if (shardInfo9 == JDA.Status.CONNECTED) {
                emojiOnOff9 = "\uD83D\uDFE2";
                message9 = shardPing + " ms ping\n" + shardUser9 + " users\n" + shard9 + " guilds";
            }else if(shardInfo9 == JDA.Status.SHUTDOWN || shardInfo1 == JDA.Status.DISCONNECTED){
                emojiOnOff9 = "\uD83D\uDD34";
                message9 = "Offline";
            }else {
                emojiOnOff9 = "\uD83D\uDFE1";
                message9 = "Initializing";
            }



            String shardS;
            if(shardsTotal < 2){
                shardS = "shard";
            }else{
                shardS = "shards";
            }

            eb.setTitle("Shard Information");
            eb.setDescription("Currently serving " + usersTotal + " users in " + serversTotal + " servers.");
            eb.addField("Shard #0 " + emojiOnOff, message0, true);
            eb.addField("Shard #1 " + emojiOnOff1, message1, true);
            eb.addField("Shard #2 " + emojiOnOff2, message2, true);
            eb.addField("Shard #3 " + emojiOnOff3, message3, true);
            eb.addField("Shard #4 " + emojiOnOff4, message4, true);
            eb.addField("Shard #5 " + emojiOnOff5, message5, true);
            eb.addField("Shard #6 " + emojiOnOff6, message6, true);
            eb.addField("Shard #7 " + emojiOnOff7, message7, true);
            eb.addField("Shard #8 " + emojiOnOff8, message8, true);
            eb.addField("Shard #9 " + emojiOnOff9, message9, true);
            event.replyEmbeds(eb.build()).queue();
        }
    }


}
