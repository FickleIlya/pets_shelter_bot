package com.example.pets_shelter.listener;


import com.example.pets_shelter.commands.BotCommands;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotListener implements UpdatesListener {

    private final Logger logger = LoggerFactory.getLogger(BotListener.class);


    private final TelegramBot telegramBot;
    private final BotCommands botCommands;

    public BotListener(TelegramBot telegramBot) {

        this.telegramBot = telegramBot;
        this.botCommands = new BotCommands();
    }

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    /**
     * Updates the bot
     * @param updates available updates
     * @return
     */
    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            if (
                    update.message() != null &&
                            update.callbackQuery() == null
            ) {
                botCommands.handleCommand(update.message().text(), update.message(), telegramBot);
            } else if (
                    update.callbackQuery() != null
            ) {

                botCommands.handleCommand(update.callbackQuery().data(), update.callbackQuery().message(), telegramBot);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
