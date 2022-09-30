package com.modbot.Commands.economy;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class daily extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("daily")){



            EmbedBuilder eb = new EmbedBuilder();
            String userid = event.getUser().getId();
            int daily;
            int xp;
            String discid = event.getUser().getId();
            String username = event.getUser().getAsTag();

            daily = (int) (Math.random() * 15000) + 1;
            xp = (int) (Math.random() * 99) + 1;

            String sql = "SELECT * FROM player where username like '";







            String sqlDaily = "IF NOT EXISTS INSERT into player (" +
                    "money," +
                    "exp," +
                    "discid," +
                    "username)" +
                    "values (" +
                    "?," +
                    "?," +
                    "?," +
                    "?)";

            eb.setDescription("Daily resgatado com sucesso! Você ganhou:\n" + daily + " créditos\n" + xp + " xp");


            event.replyEmbeds(eb.build()).queue();

        }
    }

}
