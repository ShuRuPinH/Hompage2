package in.shurup.utils;

import in.shurup.model.Page;
import in.shurup.model.Way;

import java.util.List;

public class HtmlPageGenerator {

    public static String getHtmlPage(Page page) {

        var ways = generate(page.getWays());
        var text = page.getText();

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
                "    setTextAndTarget(" +
                // text
                "`"+text+"`, " +
                // ways
                "'" + ways[0] + "');\n" +
                "    go();\n" +
                // scripts for ways
                ways[1] + "\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
    }

    private static String[] generate(List<Way> ways) {
        StringBuilder tags = new StringBuilder();
        StringBuilder scrypt = new StringBuilder()
                .append("\nfunction logKey(e) {")
                .append("\nlet key = e.code;")
                .append("\nconsole.log(key);");

        for (Way way : ways) {
            tags.append(String.format("<a href =\"%s\">%s (%s)</a>     <br>", way.getPos(), way.getName(), way.getHint()));
            scrypt.append(String.format("\nif (%s) document.location.href =\"%s\";", parseHint(way.getHint()), way.getPos()));
        }
        scrypt.append("\n}  addEventListener(\"keydown\", logKey);");

        return new String[]{tags.toString(), scrypt.toString()};
    }

    private static String parseHint(String hint) {
        switch (hint.charAt(0)) {
            case '0':
                return hint.endsWith("n") ? "key === 'Numpad0' || key === 'Digit0' || key === 'KeyN' " : "key === 'Numpad0' || key === 'Digit0'";
            case '1':
                return hint.endsWith("y") ? "key == \"Numpad1\" || key == \"Digit1\" || key == \"KeyY\" " : "key == \"Numpad1\" || key == \"Digit1\"";
            case '2':
                return "key == 'Numpad2' || key == 'Digit2'";
            case '3':
                return "key == 'Numpad3' || key == 'Digit3'";
            case '4':
                return "key == 'Numpad4' || key == 'Digit4'";
            case '5':
                return "key == 'Numpad5' || key == 'Digit5'";
            case '6':
                return "key == 'Numpad6' || key == 'Digit6'";
            case '7':
                return "key == 'Numpad7' || key == 'Digit7'";
        }
        return "false";
    }
}
