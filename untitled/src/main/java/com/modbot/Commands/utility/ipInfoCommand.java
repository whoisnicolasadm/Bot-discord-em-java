package com.modbot.Commands.utility;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class ipInfoCommand extends ListenerAdapter {

    private final Pattern urlRegEX = Pattern.compile(
            "^(([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)\\.){3}([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)$"
    );

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        var invoke = event.getName();
        if (invoke.equals("ipinfo")) {


        }
    }
}
