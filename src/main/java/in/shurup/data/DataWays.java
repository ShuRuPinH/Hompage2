package in.shurup.data;



import in.shurup.model.Page;
import in.shurup.model.Way;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Configuration
public class DataWays {

    @Bean
    public static Map<Integer, Page> getWays() {
        var rezult = new HashMap<Integer, Page>();

        rezult.put(0, new Page("Are you bot?<br><t>Вы робот ?</t>", List.of(
                new Way("1", "yes", "1/y"),
                new Way("11", "no", "0/n"))));

        rezult.put(1, new Page("User-agent: *<br>Disallow: /<br><br>User-agent: Yandex<br>Disallow:<br>" +
                "User-agent: Mail.Ru<br>Disallow:<br>User-agent: StackRambler<br>Disallow:<br>" +
                "User-agent: msnbot<br>Disallow:<br>User-agent: psbot<br>Disallow:<br>",
                List.of(
                        new Way("11", "Im not bot.", "0"),
                        new Way("11", "Я не робот", "1"))));
        /* MAIN MENU*/
        rezult.put(11, new Page("What are you looking for?<br><t>Что вы ищете?</t>", List.of(
                new Way("13", "contacts /<t>контакты</t>", "0"),
                new Way("14", "interactive fiction /<t>текстовый квест</t>", "1"),
                new Way("15", "joke /<t>анекдот</t>", "2"),
                new Way("https://www.pinterest.com/", "nothing /<t>ничего</t>", "3")
        )));

        /*  contacts block    */
        rezult.put(13, new Page("<a class=\"intext\" href=\"https://t.me/shu_ru_pin\">Telegram</a><br>" +
                "<a class=\"intext\" href=\"mailto:shurupin@gmail.com\">shurupin@gmail.com</a>", List.of(
                new Way("11", "OK", "0"),
                new Way("130", "more /<t>еще</t>", "1"))));

        rezult.put(130, new Page(".•´ ¯ `•.¸¸.•´ ¯ `•.¸¸.><((((o><br>" +
                "¯ `•.¸¸.><((((o> ¯ `•.¸¸.><((((o><br>" +
                "<br>" +
                "¯ `•.¸¸.><((((o> ¯ `•.¸¸.><((((o><br>" +
                ".•´ ¯ `•.¸¸.•´ ¯ `•.¸¸.><((((o>", List.of(
                new Way("11", "OK", "0"),
                new Way("130", "more /<t>еще</t>", "1"))));

        /*  something interesting  block    */
        rezult.put(14, new Page("UNDER CONSTRUCTION <br>" +
                "──▒▒▒▒▒▒───▄████▄<br>" +
                "─▒─▄▒─▄▒──███▄█▀<br>" +
                "─▒▒▒▒▒▒▒─▐████──█─█<br>" +
                "─▒▒▒▒▒▒▒──█████▄<br>" +
                "─▒─▒─▒─▒───▀████▀<br>/В РАЗРАБОТКЕ/", List.of(
                new Way("11", "OK", "0"),
                new Way("14", "more /<t>еще</t>", "1"))));

        rezult.put(15, new Page("<a class=\"intext\" href=\"https://www.anekdot.ru/\">www.anekdot.ru</a><br>", List.of(
                new Way("11", "OK", "0"),
                new Way("15", "more /<t>еще</t>", "1"),
                new Way("https://www.anekdot.ru", "source /<t>источник</t>", "2"))));
        return rezult;
    }
}
