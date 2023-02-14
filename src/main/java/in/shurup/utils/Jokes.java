package in.shurup.utils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.TimerTask;

public class Jokes {
    static Document doc;
    static NodeList nodeList;

    static int cnt;

    {
        init();
    }

    private static void init() {
        cnt = 2;
        try {
            String URL_NEWS = "https://www.anekdot.ru/rss/export_top.xml";
            InputStream in = new URL(URL_NEWS).openStream();
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = documentBuilder.parse(in);
            nodeList = doc.getElementsByTagName("description");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String make() {
        String value = "Воздушный шар сбился с курса, и воздухоплаватель срочно опустился с ним вниз. Увидев внизу человека, он спросил:\n" +
                "- Извините, где я нахожусь?\n" +
                "- Вы находитесь на воздушном шаре, в 15м над землей. Ваши координаты - 5°28'17\" N и 100°40'19\" E.\n" +
                "- Похоже, вы математик, - вздохнул воздухоплаватель.\n" +
                "- Да, я математик, - согласился прохожий. - Как вы догадались?\n" +
                "- Ваш ответ, по-видимому, точный и полный, но для меня совершенно бесполезный. Я по-прежнему не знаю, где я нахожусь, и что мне делать. Вы мне нисколько не помогли, только напрасно отняли время.\n" +
                "- А вы, похоже, из управленцев, - заметил математик.\n" +
                "- Я действительно топ-менеджер серьезной компании, - воспрял воздухоплаватель. - Но как вы догадались? Вы видели меня по телевизору?\n" +
                "- Зачем? - удивился математик. - Судите сами: вы не понимаете ни где вы находитесь, ни что вам следует делать, в этом вы полагаетесь на нижестоящих. Спрашивая совета у эксперта, вы ни на секунду не задумываетесь, способны ли вы понять его ответ, и когда оказывается, что это - не так, вы возмущаетесь вместо того, чтобы переспросить. Вы находитесь ровно в том же положении, что и до моего ответа, но теперь почему-то обвиняете в этом меня. Наконец, вы находитесь выше других только благодаря дутому пузырю, и если с ним что-то случится - падение станет для вас фатальным!";
        if (nodeList == null || cnt >= nodeList.getLength()) init();
        try {
            value = nodeList.item(cnt++).getTextContent();
        } catch (Exception e) {
            System.out.println(" ERROR");
            e.printStackTrace();
        }

        // Translate
        String codeValue;
        try {
            codeValue = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://translated-mymemory---translation-memory.p.rapidapi.com/get?langpair=ru%7Cen&q=" +
                        codeValue + "&mt=1&onlyprivate=0&de=a%40b.c"))
                .header("X-RapidAPI-Key", "139e79af4amsh4c3888cd1b95faap1cf52bjsne86e4c1ed65d")
                .header("X-RapidAPI-Host", "translated-mymemory---translation-memory.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body() + "<br><hr><br>" + value;
    }

    public static void start() {
        init();
        System.out.println("timer");
        java.util.Timer timer = new java.util.Timer("TimeR");
        try {
            TimerTask time = new TimerTask() {
                public void run() {
                    make();
                }
            };
            timer.schedule(time, 2000, 1 * 30 * 1000l);
        } catch (Exception e) {
            System.out.println("TIMER ERROR");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 10; j++) {
            System.out.println(make());
        }
    }
}

