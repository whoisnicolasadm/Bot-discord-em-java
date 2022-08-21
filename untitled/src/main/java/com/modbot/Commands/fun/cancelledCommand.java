package com.modbot.Commands.fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class cancelledCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();

        if (invoke.equals("cancelled")) {
            int n;
            String user = null;
            String resposta = null;
            OptionMapping optionMapping = event.getOption("user");
            user = optionMapping.getAsUser().getAsMention();
            int x;
            x = (int) (Math.random() * 41) + 1;

            for (int i = 0; i < x; i++) {
                n = (int) (Math.random() * 11) + 1;


                if (n == 1) {
                    resposta = "be too much cattle";
                } else if (n == 2) {
                    resposta = "be poser";
                } else if (n == 3) {
                    resposta = "lie to your fans";
                } else if (n == 4) {
                    resposta = "tell a lot of bad jokes";
                } else if (n == 5) {
                    resposta = "be a trash boy";
                } else if (n == 6) {
                    resposta = "have too much charm";
                } else if (n == 7) {
                    resposta = "be a big hottie";
                } else if (n == 8) {
                    resposta = "always be late";
                } else if (n == 9) {
                    resposta = "do nothing";
                } else if (n == 10) {
                    resposta = "be communist";
                } else if (n == 11) {
                    resposta = "be capitalist\n";
                } else {
                    resposta = "An error was ocurred";
                }
            }


            EmbedBuilder eb = new EmbedBuilder();
            eb.setDescription("<:dce_nMao:1000814228686503966> | " + user + " was cancelled by reason of " + resposta);
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
