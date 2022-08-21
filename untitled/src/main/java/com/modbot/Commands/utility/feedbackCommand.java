package com.modbot.Commands.utility;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class feedbackCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("feedback")){
            OptionMapping optionMapping = event.getOption("feedback");
            String feedbackMsg = optionMapping.getAsString();
            String user = event.getUser().getAsTag();
            String user2 = event.getUser().getAsMention();
            String userId = event.getUser().getId();
            TextChannel textChannel = event.getJDA().getGuildById("991347975362195596").getTextChannelById("1000805408971178055");
            EmbedBuilder eb = new EmbedBuilder();
            EmbedBuilder eb2 = new EmbedBuilder();
            String serverName = event.getGuild().getName();
            String serverId = event.getGuild().getId();

            eb2.setDescription(user2  + "\n<:conc:877956757576638476>** | Your feedback was sent sucessfully**");

            eb.setTitle("Feedback Recebido de: " + serverName);
            eb.setDescription("```" + feedbackMsg + "```\nServer: " + serverName + " (" + serverId + ")\nUser: " + user + " (" + userId + ")");
            eb.setFooter(user);

            event.replyEmbeds(eb2.build()).queue();
            textChannel.sendMessageEmbeds(eb.build()).queue();

        }
    }
}
