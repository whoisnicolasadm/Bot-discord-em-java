package com.modbot.Commands.staff;

import com.modbot.DB.CRUD;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.Channel;
import java.sql.SQLException;

public class setLogChannelCommand extends ListenerAdapter{
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("set_logs_channel")){
            OptionMapping optionMapping = event.getOption("channel");
            String channel = optionMapping.getAsTextChannel().getAsMention();
            String channelId = optionMapping.getAsTextChannel().getId();
            String guildId = event.getGuild().getId();
            EmbedBuilder eb = new EmbedBuilder();

            try {
                CRUD.insert(guildId, channelId);
                eb.setDescription("<:concluido:1000814178833010708> | The log channel has been set to: " + channel);
                event.replyEmbeds(eb.build()).queue();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
