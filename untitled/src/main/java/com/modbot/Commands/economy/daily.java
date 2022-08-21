package com.modbot.Commands.economy;

import com.modbot.connection.connectionFactory;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class daily extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("daily")){
            EmbedBuilder eb = new EmbedBuilder();
            Connection connect = connectionFactory.getConnect();

            int daily;
            int xp;
            String discid = event.getUser().getId();
            String username = event.getUser().getAsTag();

            daily = (int) (Math.random() * 15000) + 1;
            xp = (int) (Math.random() * 99) + 1;

            String sqlDaily = "insert into player (" +
                    "money," +
                    "exp," +
                    "discid," +
                    "username)" +
                    "values (" +
                    "?," +
                    "?," +
                    "?," +
                    "?);";

            try {
                PreparedStatement stmt = connect.prepareStatement(sqlDaily);
                stmt.setInt(1, daily);
                stmt.setInt(2, xp);
                stmt.setString(3, discid);
                stmt.setString(4, username);
                stmt.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            eb.setDescription("Daily resgatado com sucesso! Você ganhou:\n" + daily + " créditos\n" + xp + " xp");


            event.replyEmbeds(eb.build()).queue();

        }
    }
}
