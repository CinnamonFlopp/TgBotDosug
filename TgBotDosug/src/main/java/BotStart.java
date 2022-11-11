import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.util.*;

public class BotStart extends TelegramLongPollingBot {
    public static String title;
    public static String subText;
    public static String img;
    public static String orgHref;
    public static String beginDate;
    public static String gotTeg;

    @Override
    public String getBotUsername() {return "DosugBot";}

    @Override
    public String getBotToken() {return "5146464980:AAFKAe8Kmp39ghrzGk9-Sgd52z3gYeA20VM";}

    @Override
    public void onUpdateReceived(Update update){
        if (update.hasCallbackQuery()) {
            try {
                handleCallBack(update.getCallbackQuery());
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }
        }else  if (update.hasMessage()) {
            try {
                handleMessage(update.getMessage());
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void handleCallBack(CallbackQuery callbackQuery) throws TelegramApiException, IOException {
        Message message = callbackQuery.getMessage();
        gotTeg = callbackQuery.getData();
        execute(
                SendMessage.builder()
                        .text("Вы выбрали - " + gotTeg)
                        .chatId(message.getChatId().toString())
                        .build());

        Elements postTitleElements;
        Document doc;
        String detailsLink;
        switch (gotTeg){
            case "performance":

                doc = Jsoup.connect("https://kudamoscow.ru/event/performance/").get();
                postTitleElements = doc.getElementsByClass("eventname");
                int i = 0;
                int c = 0;
                for (Element postTitleElement : postTitleElements) {
                    c++;
                    if (c > 5){
                        detailsLink = postTitleElement.attr("href");
                        title = postTitleElement.attr("title");
                        Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                        img = postDetailsDoc.getElementsByTag("figure").attr("src");
                        orgHref = postDetailsDoc.getElementsByClass("org_site").text();
                        beginDate = postDetailsDoc.getElementsByAttributeValue("itemprop","doorTime").first().ownText();
                        System.out.println(title  + "|" + img + "|" + orgHref + "|" + beginDate);
                        execute(
                                SendMessage.builder()
                                        .text(
                                                img + System.lineSeparator() +
                                                        title + System.lineSeparator()+
                                                        beginDate + System.lineSeparator()+
                                                        orgHref
                                                )
                                        .chatId(message.getChatId().toString())
                                        .build());
                        i++;
                        if(i==3){
                            break;
                        }
                    }
                }
                break;
            case "kids":

                doc = Jsoup.connect("https://kudamoscow.ru/event/kids/").get();
                postTitleElements = doc.getElementsByClass("eventname");
                i = 0;
                c = 0;
                for (Element postTitleElement : postTitleElements) {
                    c++;
                    if (c > 5) {
                        detailsLink = postTitleElement.attr("href");
                        title = postTitleElement.attr("title");
                        Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                        img = postDetailsDoc.getElementsByTag("figure").attr("src");
                        orgHref = postDetailsDoc.getElementsByClass("org_site").text();
                        beginDate = postDetailsDoc.getElementsByAttributeValue("itemprop", "doorTime").first().ownText();
                        ;
                        System.out.println(title + "|" + img + "|" + orgHref + "|" + beginDate);
                        execute(
                                SendMessage.builder()
                                        .text(
                                                img + System.lineSeparator() +
                                                        title + System.lineSeparator() +
                                                        beginDate + System.lineSeparator() +
                                                        orgHref
                                        )
                                        .chatId(message.getChatId().toString())
                                        .build());
                        i++;
                        if (i == 3) {
                            break;
                        }
                    }
                }
                break;
            case "show":

                doc = Jsoup.connect("https://kudamoscow.ru/event/show/").get();
                postTitleElements = doc.getElementsByClass("eventname");
                i = 0;
                c = 0;
                for (Element postTitleElement : postTitleElements) {
                    c++;
                    if (c > 5) {
                        detailsLink = postTitleElement.attr("href");
                        title = postTitleElement.attr("title");
                        Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                        img = postDetailsDoc.getElementsByTag("figure").attr("src");
                        orgHref = postDetailsDoc.getElementsByClass("org_site").text();
                        beginDate = postDetailsDoc.getElementsByAttributeValue("itemprop", "doorTime").first().ownText();
                        ;
                        System.out.println(title + "|" + img + "|" + orgHref + "|" + beginDate);
                        execute(
                                SendMessage.builder()
                                        .text(
                                                img + System.lineSeparator() +
                                                        title + System.lineSeparator() +
                                                        beginDate + System.lineSeparator() +
                                                        orgHref
                                        )
                                        .chatId(message.getChatId().toString())
                                        .build());
                        i++;
                        if (i == 3) {
                            break;
                        }
                    }
                }
                break;
            case "learn":

                doc = Jsoup.connect("https://kudamoscow.ru/event/learn/").get();
                postTitleElements = doc.getElementsByClass("eventname");
                i = 0;
                c = 0;
                for (Element postTitleElement : postTitleElements) {
                    c++;
                    if (c > 5) {
                        detailsLink = postTitleElement.attr("href");
                        title = postTitleElement.attr("title");
                        Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                        img = postDetailsDoc.getElementsByTag("figure").attr("src");
                        orgHref = postDetailsDoc.getElementsByClass("org_site").text();
                        beginDate = postDetailsDoc.getElementsByAttributeValue("itemprop", "doorTime").first().ownText();
                        ;
                        System.out.println(title + "|" + img + "|" + orgHref + "|" + beginDate);
                        execute(
                                SendMessage.builder()
                                        .text(
                                                img + System.lineSeparator() +
                                                        title + System.lineSeparator() +
                                                        beginDate + System.lineSeparator() +
                                                        orgHref
                                        )
                                        .chatId(message.getChatId().toString())
                                        .build());
                        i++;
                        if (i == 3) {
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    private void handleMessage(Message message) throws TelegramApiException, IOException {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (commandEntity.isPresent()) {
                String command = message.getText().substring(commandEntity.get().getOffset(), commandEntity.get().getLength());
                switch (command) {
                    case "/searchdosug":
                        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                        buttons.add(
                                Arrays.asList(
                                        InlineKeyboardButton.builder().text("С детьми " + "\uD83D\uDC6A").callbackData("kids").build(),
                                        InlineKeyboardButton.builder().text("Шоу " + "\uD83C\uDF89").callbackData("performance").build(),
                                        InlineKeyboardButton.builder().text("Выставки " + "\uD83D\uDDBC").callbackData("show").build(),
                                        InlineKeyboardButton.builder().text("Образование " + "\uD83C\uDF93").callbackData("learn").build()));

                        execute(
                                SendMessage.builder()
                                        .text("Выберите подходящий тэг:")
                                        .chatId(message.getChatId().toString())
                                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                                        .build());
                        break;
                    case "/randomdosug":
                        Document doc = Jsoup.connect("https://kudamoscow.ru/").get();
                        Elements postTitleElements = doc.getElementsByClass("eventname");
                        int i = 0;
                        int c = 0;
                        Random random = new Random();
                        int x = random.nextInt(5, 15);
                        for (Element postTitleElement : postTitleElements) {
                            c++;
                            if (c == x) {
                                String detailsLink = postTitleElement.attr("href");
                                title = postTitleElement.attr("title");
                                Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                                img = postDetailsDoc.getElementsByTag("figure").attr("src");
                                orgHref = postDetailsDoc.getElementsByClass("org_site").text();
                                beginDate = postDetailsDoc.getElementsByAttributeValue("itemprop", "doorTime").first().ownText();
                                ;
                                System.out.println(title + "|" + img + "|" + orgHref + "|" + beginDate);
                                execute(
                                        SendMessage.builder()
                                                .text(
                                                        img + System.lineSeparator() +
                                                                title + System.lineSeparator() +
                                                                beginDate + System.lineSeparator() +
                                                                orgHref
                                                )
                                                .chatId(message.getChatId().toString())
                                                .build());
                                i++;
                                if (i == 1) {
                                    break;
                                }
                            }
                        }

                }
            }
        }
    }


    public static void main(String[] args) throws TelegramApiException {
        BotStart bot = new BotStart();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
