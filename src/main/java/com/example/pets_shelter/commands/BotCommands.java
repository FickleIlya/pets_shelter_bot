package com.example.pets_shelter.commands;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.Data;

import java.util.List;


@Data
public class BotCommands {

    public static final String START_COMMAND = "/start";
    public static final String HELP_COMMAND = "/help";
    public static final String INFO_COMMAND = "/info";
    public static final String HOW_TAKE_A_DOG_COMMAND = "/howToTakeADog";
    public static final String CALL_VOLUNTEER_COMMAND = "/volunteer";

    public static final String SHELTER_INFO_COMMAND = "shelterInfo";
    public static final String SHELTER_SCHEDULE_COMMAND = "shelterSchedule";
    public static final String SHELTER_LOCATION_COMMAND = "shelterLocation";
    public static final String SHELTER_SAFETY_PRECAUTIONS_COMMAND = "shelterSafetyPrecautions";
    public static final String SHELTER_LEAVE_CONTACTS_COMMAND = "leaveContacts";

    public void handleCommand(String command, Message message, TelegramBot bot) {
        switch (command) {
            case START_COMMAND -> handleStartCommand(message, bot);
            case HELP_COMMAND -> handleHelpCommand(message, bot);
            case INFO_COMMAND -> handleInfoCommand(message, bot);
            case HOW_TAKE_A_DOG_COMMAND -> handleHowToTakeADog(message, bot);
            case CALL_VOLUNTEER_COMMAND -> handleCallVolunteer(message, bot);
            case SHELTER_INFO_COMMAND -> handleShelterInfo(message, bot);
            case SHELTER_SCHEDULE_COMMAND -> handleShelterSchedule(message, bot);
            case SHELTER_LOCATION_COMMAND -> handleShelterLocation(message, bot);
            case SHELTER_SAFETY_PRECAUTIONS_COMMAND -> handleShelterSafetyPrecautions(message, bot);
            case SHELTER_LEAVE_CONTACTS_COMMAND -> handleLeaveContacts(message, bot);
            
            default -> handleUnknownCommand(message, bot);
        }
    }

    private void handleStartCommand(Message message, TelegramBot bot) {
        SendMessage response = new SendMessage(
                message.chat().id(),
                """
Привет, я бот! Как я могу тебе помочь?

Я могу выполнить следующие команды:

/info - получить информацию о приюте
/howToTakeADog - как забрать собаку из приюта
/report - отослать отчет о питомце
/volunteer - позвать волонтера
/help - команды бота
"""
        );
        bot.execute(response);
    }

    private void handleHelpCommand(Message message, TelegramBot bot) {
        SendMessage response = new SendMessage(
                message.chat().id(),
                """
Я могу выполнить следующие команды:

/info - получить информацию о приюте
/howToTakeADog - как забрать собаку из приюта
/report - отослать отчет о питомце
/volunteer - позвать волонтера
/help - команды бота
"""
        );
        bot.execute(response);
    }

    private void handleInfoCommand(Message message, TelegramBot bot) {
        List<InlineKeyboardButton> inlineKeyboardButtons = List.of(
                new InlineKeyboardButton("Узнать о приюте").callbackData("shelterInfo"),
                new InlineKeyboardButton("Расписание работы").callbackData("shelterSchedule"),
                new InlineKeyboardButton("Схема проезда").callbackData("shelterLocation"),
                new InlineKeyboardButton("Техника безопасности").callbackData("shelterSafetyPrecautions"),
                new InlineKeyboardButton("Оставить контакты").callbackData("leaveContacts"),
                new InlineKeyboardButton("Позвать волонтера").callbackData("/volunteer")
        );
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        inlineKeyboardButtons.forEach(keyboard::addRow);
        SendMessage response = new SendMessage(
                message.chat().id(),
"""
Привет! Меня зовут PetsShelterBot! Мы помогаем милым животным найти любящего хозяина.
О чем ты хочешь узнать?

/help - команды бота
"""
        );
        response.replyMarkup(keyboard);
        bot.execute(response);
    }

    private void handleHowToTakeADog(Message message, TelegramBot bot) {
        SendMessage response = new SendMessage(
                message.chat().id(),
"""
Тут будет информация как забрать собаку из приюта
/help - команды бота
"""
        );
        bot.execute(response);
    }

    private void handleCallVolunteer(Message message, TelegramBot bot) {
        SendMessage response = new SendMessage(
                message.chat().id(),
"""
Зовем волонтера
/help - команды бота
"""
        );
        bot.execute(response);
    }

    private void handleShelterInfo(Message message, TelegramBot bot){
        SendMessage response = new SendMessage(
            message.chat().id(),
"""
Информация о приюте
/help - команды бота
"""
        );
        bot.execute(response);
    }
    private void handleShelterSchedule(Message message, TelegramBot bot){
        SendMessage response = new SendMessage(
            message.chat().id(),
"""
Расписание приюта
/help - команды бота
"""
        );
        bot.execute(response);
    }
    private void handleShelterLocation(Message message, TelegramBot bot){
        SendMessage response = new SendMessage(
            message.chat().id(),
"""
Местоположение приюта
/help - команды бота
"""
        );
        bot.execute(response);
    }
    private void handleShelterSafetyPrecautions(Message message, TelegramBot bot){
        SendMessage response = new SendMessage(
            message.chat().id(),
"""
Техника безопасности на территории приюта
/help - команды бота
"""
        );
        bot.execute(response);
    }
    private void handleLeaveContacts(Message message, TelegramBot bot){
        SendMessage response = new SendMessage(
            message.chat().id(),
"""
Оставить контакты
/help - команды бота
"""
        );
        bot.execute(response);
    }

    private void handleUnknownCommand(Message message, TelegramBot bot) {
        SendMessage response = new SendMessage(
                message.chat().id(),
                "Извините, я не понимаю эту команду."
        );
        bot.execute(response);
    }
}