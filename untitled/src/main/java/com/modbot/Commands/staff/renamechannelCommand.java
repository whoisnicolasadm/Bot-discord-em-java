package com.modbot.Commands.staff;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import org.jetbrains.annotations.NotNull;

public class renamechannelCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if(invoke.equals("rename_channel")) {
            OptionMapping optionMapping = event.getOption("channel");
            OptionMapping optionMapping2 = event.getOption("name");
            String user = event.getMember().getAsMention();
            boolean permissions = event.getMember().hasPermission(Permission.MANAGE_CHANNEL);
            GuildChannel channel = optionMapping.getAsGuildChannel();
            String name = optionMapping2.getAsString();
            EmbedBuilder eb = new EmbedBuilder();
            String oldName = channel.getName();

        

            Member bot = event.getGuild().getMemberById("764140529041670154");

            if (permissions == false) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " You don't have the permission `MANAGE_CHANNEL` to use this command!");
            } else if (!bot.hasPermission(Permission.MANAGE_CHANNEL)) {
                eb.setDescription("<:ero:877956567570481162>| " + user + " I don't have the permission `MANAGE_CHANNEL` to use this command!");
            } else {
                
                channel.getManager().setName(name).queue();
                eb.setDescription("<:concluido:1000814178833010708>| " + user + " channel name has been successfully changed to: " + name + "\n old name: " + oldName);
            }
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
