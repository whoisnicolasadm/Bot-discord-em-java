package com.modbot.Commands.staff;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class lockCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("lock")){
            String user = event.getMember().getAsMention();
            boolean permissions = event.getMember().hasPermission(Permission.MANAGE_CHANNEL);
            EmbedBuilder eb = new EmbedBuilder();


            Member bot = event.getGuild().getMemberById("764140529041670154");

            if (permissions == false) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " You don't have the permission `MANAGE_CHANNEL` to use this command!");
            } else if (!bot.hasPermission(Permission.MANAGE_CHANNEL)) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " I don't have the permission `MANAGE_CHANNEL` to use this command!");
            } else {
                event.getTextChannel().upsertPermissionOverride(event.getGuild().getPublicRole()).deny(Permission.MESSAGE_SEND).queue();
                eb.setDescription("<:concluido:1000814178833010708>| " + user + " channel has been successfully locked");
            }
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
