package com.modbot.Commands.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class userinfoCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("userinfo")) {

            OptionMapping optionMapping = event.getOption("user");
            EmbedBuilder eb = new EmbedBuilder();
            String user = null;
            String userTag = null;
            String userID = null;
            String imageUser = null;
            int yearDate;
            int monthDate;
            int dayDate;

            if (optionMapping == null) {
                user = event.getUser().getName();
                userTag = event.getUser().getAsTag();
                userID = event.getUser().getId();
                yearDate = event.getUser().getTimeCreated().getYear();
                monthDate = event.getUser().getTimeCreated().getMonthValue();
                dayDate = event.getUser().getTimeCreated().getDayOfMonth();
                imageUser = event.getUser().getAvatarUrl();

            } else {
                user = optionMapping.getAsUser().getName();
                userTag = optionMapping.getAsUser().getAsTag();
                userID = optionMapping.getAsUser().getId();
                yearDate = optionMapping.getAsUser().getTimeCreated().getYear();
                monthDate = optionMapping.getAsUser().getTimeCreated().getMonthValue();
                dayDate = optionMapping.getAsUser().getTimeCreated().getDayOfMonth();
                imageUser = optionMapping.getAsUser().getAvatarUrl();
            }

            eb.setTitle(user);
            eb.addField("<:dce_user:1000814869248999536> **Discord tag**", "`" + userTag + "`", true);
            eb.addField("<:id:1000814889549443083> **Discord ID**", "`" + userID + "`", true);
            eb.addField("<:oskas:875739803189129236> **Account created in: **", "`" + yearDate + "/" + monthDate + "/" + dayDate + "`", true);
            eb.setThumbnail(imageUser);

            event.replyEmbeds(eb.build()).queue();
        }

    }
}
