package com.modbot.Listeners;

import com.modbot.Commands.ADM.serversListCommand;
import com.modbot.Commands.ADM.shutdownCommand;
import com.modbot.Commands.bot.botinfoCommand;
import com.modbot.Commands.bot.pingCommand;
import com.modbot.Commands.bot.shardsCommand;

import com.modbot.Commands.bot.statsCommand;
import com.modbot.Commands.discord.*;

import com.modbot.Commands.economy.daily;
import com.modbot.Commands.fun.cancelledCommand;

import com.modbot.Commands.fun.coinflipCommand;

import com.modbot.Commands.fun.eightballCommand;

import com.modbot.Commands.fun.jankenponCommand;

import com.modbot.Commands.interaction.*;
import com.modbot.Commands.staff.*;
import com.modbot.Commands.utility.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class commandManager extends ListenerAdapter {



    @Override
    public void onReady(@NotNull ReadyEvent event) {

        List<CommandData> commandData = new ArrayList<>();
        event.getJDA().addEventListener(
                new pingCommand(),
                new avatarCommand(),
                new helpCommand(),
                new botinfoCommand(),
                new serverinfoCommand(),
                new userinfoCommand(),
                new servericonCommand(),
                new inviteCommand(),
                new jankenponCommand(),
                new coinflipCommand(),
                new eightballCommand(),
                new cancelledCommand(),
                new anagramCommand(),
                new lockCommand(),
                new unlockCommand(),
                new apodCommand(),
                new renamechannelCommand(),
                new deletechannelCommand(),
                new shardsCommand(),
                new sourceCommand(),
                new feedbackCommand(),
                new BiteCommand(),
                new cuddleCommand(),
                new shrugCommand(),
                new handHoldCommand(),
                new helloCommand(),
                new highfiveCommand(),
                new hugCommand(),
                new killCommand(),
                new kissCommand(),
                new laughCommand(),
                new panCommand(),
                new patCommand(),
                new pokeCommand(),
                new punchCommand(),
                new triggeredCommand(),
                new blushCommand(),
                new slapCommand(),
                new channelInfoCommand(),
                new statsCommand()
        );


        //options data
        OptionData optionName2 = new OptionData(OptionType.STRING, "name", "value", true);
        OptionData optionFeedback = new OptionData(OptionType.STRING, "feedback", "value", true);
        OptionData optionChannel = new OptionData(OptionType.CHANNEL, "channel", "value", true);
        OptionData optionUser = new OptionData(OptionType.USER, "user", "valuer", false);
        OptionData optionUser2 = new OptionData(OptionType.USER, "user", "value", true);
        OptionData optionName = new OptionData(OptionType.STRING, "word", "value", true);
        OptionData optionAsk = new OptionData(OptionType.STRING, "doubt", "value", true);
        OptionData optionValue = new OptionData(OptionType.STRING, "value", "value", true).addChoice("Rock", "Rock").addChoice("Paper", "Paper").addChoice("Scissors", "Scissors");

        //registering commands

        //staff commands
        commandData.add(Commands.slash("rename_channel", "??Staff??? Rename the selected channel").addOptions(optionChannel, optionName2));
        commandData.add(Commands.slash("delete_channel", "??Staff??? Delete the selected channel").addOptions(optionChannel));
        commandData.add(Commands.slash("lock", "??Staff??? Lock the channel"));
        commandData.add(Commands.slash("unlock", "??Staff??? Unlock the channel"));


        //utility commands
        commandData.add(Commands.slash("ping", "??Utility??? ModBot Ping"));
        commandData.add(Commands.slash("help", "??Utility??? ModBot Help"));
        commandData.add(Commands.slash("botinfo", "??Utility??? ModBot info"));
        commandData.add(Commands.slash("source", "??Utility??? View ModBot source code on GitHub"));
        commandData.add(Commands.slash("anagram", "??Utility??? Get name or word anagram").addOptions(optionName));
        commandData.add(Commands.slash("feedback", "??Utility??? Give feedback about the bot to the creator").addOptions(optionFeedback));
        commandData.add(Commands.slash("apod", "??Utility??? Astronomic picture of the day"));

        //Discord commands
        commandData.add(Commands.slash("serverinfo", "??Discord??? server informations"));
        commandData.add(Commands.slash("userinfo", "??Discord??? Get the user info").addOptions(optionUser));
        commandData.add(Commands.slash("avatar", "??Discord??? Get the user avatar").addOptions(optionUser));
        commandData.add(Commands.slash("servericon", "??Discord??? Get the server icon"));
        commandData.add(Commands.slash("channel_info", "??Discord??? Get information about some channel").addOptions(optionChannel));



        //fun commands
        commandData.add(Commands.slash("jankenpon", "??Fun??? Play Rock, Paper or Scissors! (Or, as how the weebs call it, jankenpon)").addOptions(optionValue));
        commandData.add(Commands.slash("8ball", "??Fun??? Ask me anything").addOptions(optionAsk));
        commandData.add(Commands.slash("coinflip", "??Fun??? Let me flip acoin and see if it will land on heads or tails!"));
        commandData.add(Commands.slash("cancelled", "??Fun??? Your best friend was cancelled by Twitter's cancel culture! But... why were they cancelled?").addOptions(optionUser2));



        //bot commands
        commandData.add(Commands.slash("shards", "??Bot??? View all ModBot shards stats"));
        commandData.add(Commands.slash("invite", "??Bot??? Invite ModBot to your server"));
        commandData.add(Commands.slash("stats", "??Bot??? ModBot stats"));

        //Interaction commands
        commandData.add(Commands.slash("bite", "??Social??? bite some user").addOptions(optionUser2));
        commandData.add(Commands.slash("blush", "??Social??? blush at some user").addOptions(optionUser2));
        commandData.add(Commands.slash("cuddle", "??Social??? cuddle some user").addOptions(optionUser2));
        commandData.add(Commands.slash("hand_hold", "??Social??? hold some user's hand").addOptions(optionUser2));
        commandData.add(Commands.slash("hello", "??Social??? say hello to some user").addOptions(optionUser2));
        commandData.add(Commands.slash("high_five", "??Social??? Send a high five to some user").addOptions(optionUser2));
        commandData.add(Commands.slash("hug", "??Social??? hug some user").addOptions(optionUser2));
        commandData.add(Commands.slash("kill", "??Social??? kill some user").addOptions(optionUser2));
        commandData.add(Commands.slash("kiss", "??Social??? kiss some user").addOptions(optionUser2));
        commandData.add(Commands.slash("laugh", "??Social??? laugh at some user").addOptions(optionUser2));
        commandData.add(Commands.slash("pan", "??Social??? hit some user with a pan").addOptions(optionUser2));
        commandData.add(Commands.slash("pat", "??Social??? pat some user").addOptions(optionUser2));
        commandData.add(Commands.slash("poke", "??Social??? Poke some user").addOptions(optionUser2));
        commandData.add(Commands.slash("punch", "??Social??? Punch some user").addOptions(optionUser2));
        commandData.add(Commands.slash("shrug", "??Social??? Shrug at some user").addOptions(optionUser2));
        commandData.add(Commands.slash("slap", "??Social??? Slap some user").addOptions(optionUser2));
        commandData.add(Commands.slash("triggered", "??Social??? Be triggered by some user").addOptions(optionUser2));

        event.getJDA().updateCommands().addCommands(commandData).queue();
    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        event.getJDA().addEventListener(
                new shutdownCommand(),
                new serversListCommand(),
                new daily(),
                new setLogChannelCommand()
        );

        if(event.getGuild().getId().equals("991347975362195596")){
            OptionData shardId = new OptionData(OptionType.STRING, "shardid", "none", true);
            OptionData channel = new OptionData(OptionType.CHANNEL, "channel", "none", true);

            commandData.add(Commands.slash("shutdown_shard", "none").addOptions(shardId));
            commandData.add(Commands.slash("server_list", "none"));
            commandData.add(Commands.slash("daily", "??Currency??? Get the daily credits"));
            commandData.add(Commands.slash("set_logs_channel", "??staff??? Sets the logs channel").addOptions(channel));
            event.getGuild().updateCommands().addCommands(commandData).queue();
        }
    }
}
