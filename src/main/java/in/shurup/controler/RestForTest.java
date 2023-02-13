package in.shurup.controler;

import in.shurup.model.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t")
public class RestForTest {

    String temp = "<!DOCTYPE html>\n" +
            "<html lang=\"ru\">\n" +
            "  <head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Заголовок страницы</title>\n" +
            "    <link rel=\"stylesheet\" href=\"./styles/style.css\">\n" +
            "  \n" +
            "    <meta property=\"og:title\" content=\"Заголовок страницы в OG\">\n" +
            "    <meta property=\"og:description\" content=\"Описание страницы в OG\">\n" +
            "    <meta property=\"og:image\" content=\"https://example.com/image.jpg\">\n" +
            "    <meta property=\"og:url\" content=\"https://example.com/\">\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <header>\n" +
            "      <h1>Это мой сайт</h1>\n" +
            "      <p>Он хороший</p>\n" +
            "      <nav>\n" +
            "        <ul>\n" +
            "          <li><a href=\"index.html\">Эта страница</a></li>\n" +
            "          <li><a href=\"catalog.html\">Другая страница</a></li>\n" +
            "        </ul>\n" +
            "      </nav>\n" +
            "    </header>\n" +
            "    <main>\n" +
            "      <article>\n" +
            "        <section>\n" +
            "          <h2>Первая секция</h2>\n" +
            "          <p>Она обо мне</p>\n" +
            "          <img src=\"../pics/funny.gif\" alt=\"Человек и пароход\">\n" +
            "          <p>Но может быть и о семантике, я пока не решил.</p>\n" +
            "        </section>\n" +
            "        <section>\n" +
            "          <h2>Вторая секция</h2>\n" +
            "          <p>Она тоже обо мне</p>\n" +
            "        </section>\n" +
            "        <section>\n" +
            "          <h2>И третья</h2>\n" +
            "          <p>Вы уже должны были начать догадываться.</p>\n" +
            "        </section>\n" +
            "      </article>\n" +
            "    </main>\n" +
            "    <footer>\n" +
            "      <p>Сюда бы я вписал информацию об авторе и ссылки на другие сайты</p>\n" +
            "    </footer>\n" +
            "    <!-- сюда можно подключить jquery <script src=\"scripts/app.js\" defer></script> -->\n" +
            "  </body>\n" +
            "</html>";

    @GetMapping
    public ResponseEntity answer() {
        return ResponseEntity.ok(new Page("jkjk","kjkjk","<img src=\"../pics/funny.gif\" alt=\"Человек и пароход\">" +
                "<p>normal</p>" +
                "   <p id=\"text\">text</p>\n" +
                "    <p id=\"ways\">ways</p>").toHtmlPage());
    }

    @GetMapping("1")
    public ResponseEntity answer1() {
        return ResponseEntity.ok(temp);
    }
}


