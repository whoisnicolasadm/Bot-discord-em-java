package com.modbot.Commands.staff;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

public class banCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("ban")) {
            OptionMapping optionMapping = event.getOption("user");
            String user = optionMapping.getAsUser().getAsMention();
            long userBanId = optionMapping.getAsUser().getIdLong();
            boolean permissions = event.getMember().hasPermission(Permission.BAN_MEMBERS);
            EmbedBuilder eb = new EmbedBuilder();
            Member userBan = optionMapping.getAsMember();
            Member bot = event.getGuild().getMemberById("764140529041670154");

            if (!permissions) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " You don't have the permission `BAN_MEMBERS` to use this command!");
            } else if (!bot.hasPermission(Permission.BAN_MEMBERS)) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " I don't have the permission `BAN_MEMBERS` to use this command!");
            } else {
                try {
                    assert userBan != null;
                    event.getGuild().ban(userBan, 7).queue();
                    eb.setDescription("<:concluido:1000814178833010708>| " + user + " The user has been successfully banned from this guild");
                } catch (IllegalArgumentException e) {
                    eb.setDescription("<:ero:877956567570481162>| " + user + " The user has a higher role than me");
                } catch (HierarchyException e) {
                    eb.setDescription("<:ero:877956567570481162>| " + user + " I can't ban someone with the same role as mine");
                }
            }

            if (userBanId == bot.getIdLong()) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " Did you seriously expect me to ban myself?");

            }

            event.replyEmbeds(eb.build()).queue();

        }
    }
}
