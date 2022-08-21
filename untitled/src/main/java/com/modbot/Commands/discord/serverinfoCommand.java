package com.modbot.Commands.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class serverinfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("serverinfo")) {

            String name = event.getGuild().getName();
            String icon = event.getGuild().getIconUrl();
            int shardsServer = event.getJDA().getShardInfo().getShardId();
            String ID = event.getGuild().getId();
            String owner = event.getGuild().getOwnerId();
            String ownerMention = event.getGuild().getOwner().getEffectiveName();
            int textsChannel = event.getGuild().getTextChannels().size();
            int voiceChannels = event.getGuild().getVoiceChannels().size();
            int canais = textsChannel + voiceChannels;
            int yearDate = event.getGuild().getTimeCreated().getYear();
            int monthDate = event.getGuild().getTimeCreated().getMonthValue();
            int dayDate = event.getGuild().getTimeCreated().getDayOfMonth();
            int members = event.getGuild().getMemberCount();
            int boostCount = event.getGuild().getBoostCount();
            long time = event.getGuild().getTimeCreated().toEpochSecond();


            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("<:discord:1002019703276974210> " + name);
            eb.addField("**<:id:1000814889549443083> ID**", "" + ID + "", true);
            eb.addField("**<:dce_process:1000814244993957940> Shard ID **", "" + shardsServer + "", true);
            eb.addField("**<:dce_coroa:1000814197128564879> Owner**", "`" + owner + " : " + ownerMention + "`", true);
            eb.addField("**<:dce_dCanal:1000814202329509948> Channels (" + canais + ")\n<:dce_textEdit:1000815394711421071> Text:**(" + textsChannel + ")\n**\uD83D\uDD08 Voice: **(" + voiceChannels + ")", "", true);
            eb.addField("**<:oskas:875739803189129236> created in: **", "(<t:" + time + ":R>)\n" + yearDate + "/" + monthDate + "/" + dayDate, true);
            eb.addField("**<:dce_pessoas:1000814237356134420> Members: **", "`" + members + "`", true);
            eb.addField("**<:boost:1002038275273404476> Boosts:**", "`" + boostCount + "`", true);
            eb.setThumbnail(icon);

            event.replyEmbeds(eb.build()).queue();
        }

    }
}
