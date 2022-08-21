package com.modbot.Commands.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.time.OffsetDateTime;

public class channelInfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("channel_info")){
            EmbedBuilder eb = new EmbedBuilder();
            OptionMapping optionMapping = event.getOption("channel");
            String channelName = optionMapping.getAsGuildChannel().getName();
            String channelId = optionMapping.getAsGuildChannel().getId();
            ChannelType channelType = optionMapping.getAsGuildChannel().getType();
            long channelTime = optionMapping.getAsGuildChannel().getTimeCreated().toEpochSecond();

            eb.setTitle("<:info:1000815419503939726>**Information about:**  " + channelName);
            eb.addField("<:id:1000814889549443083>**Channel Id**", "`" + channelId + "`", true);
            eb.addField("<:id:1000814889549443083>**Created at**", "<t:" + channelTime + ":R>", true);
            eb.addField("<:id:1000814889549443083>**Channel type**", "" + channelType, true);

            event.replyEmbeds(eb.build()).queue();
        }
    }
}
