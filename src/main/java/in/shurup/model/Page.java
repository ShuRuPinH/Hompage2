package in.shurup.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static in.shurup.utils.TagAndScriptGenerator.generate;


@Data
@AllArgsConstructor
public class Page {
    String title;
    String header;
    String body;

    public String toHtmlPage() {

        List<Way> wayArrayList = new ArrayList<>();

        wayArrayList.add(new Way("1", "yes", "1/y"));
        wayArrayList.add(new Way("11", "no", "0/n"));

       var ways = generate(wayArrayList);

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>shurup.in</title>\n" +
                "    <link rel=\"shortcut icon\" href=\"favicons/icon.ico\"/>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/style.css\">\n" +
                "</head>\n" +
                "<body>" +
                "<div class=\"blocktext\">\n" +
                "    <p id=\"text\"></p>\n" +
                "    <p id=\"ways\"></p>\n" +
                "</div>\n" +
                "\n" +
                "<script src=\"../js/main.js\" type=\"text/javascript\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "    setTextAndTarget('123', '"+ ways[0] +"');\n" +
                "    go();\n" +
                ways[1]+"\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
    }
}
