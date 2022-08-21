package com.modbot.Commands.discord;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class inviteCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("invite")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setDescription("Do you want to add me on other Discord servers/guilds? Then [click here](https://discord.com/api/oauth2/authorize?client_id=991128428596183160&permissions=8&scope=applications.commands%20bot) to add me on another server!\nAnd, of course, join my guild to make suggestions, report bugs and much more! [Support server](https://discord.gg/7XGwzTGDka)");
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
