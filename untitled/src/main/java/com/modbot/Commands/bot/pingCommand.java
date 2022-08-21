package com.modbot.Commands.bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
public class pingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        var invoke = event.getName();

        if (invoke.equals("ping")) {
            String user = event.getMember().getUser().getAsMention();
            double ping = event.getJDA().getGatewayPing();
            double pingApi = event.getJDA().getRestPing().complete();
            int shards = event.getJDA().getShardInfo().getShardTotal();
            int shardsServer = event.getGuild().getJDA().getShardInfo().getShardId();


            String emojiPing = null;
            String emojiPingApi = null;

            if (ping >= 100.0) {
                emojiPing = "<:ping_alto:1001680443055276162>";
            } else if (ping <= 50.0) {
                emojiPing = "<:ping_baixin:1001680667085643947>";
            } else if (ping > 50.0) {
                emojiPing = "<:ping_medio:1001680558415421530>";
            }

            if (pingApi >= 400.0) {
                emojiPingApi = "<:ping_alto:1001680443055276162>";
            } else if (pingApi <= 200.0) {
                emojiPingApi = "<:ping_baixin:1001680667085643947>";
            } else if (pingApi > 200.0) {
                emojiPingApi = "<:ping_medio:1001680558415421530>";
            }

            EmbedBuilder eb = new EmbedBuilder();
            eb.setDescription("\uD83C\uDFD3**|** " + user + " **Pong!** (<:dce_process:1000814244993957940> Shard " + shardsServer + "/" + shards + ")(<:modbotzin:991131805212221440>ModBot Cluster 1)\n" + emojiPing + "**| Gateway Ping:** `" + ping + "`\n" + emojiPingApi + "**| API Ping:** `" + pingApi + "`");

            event.replyEmbeds(eb.build()).queue();
    }
    }

}
