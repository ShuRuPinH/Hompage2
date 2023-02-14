package in.shurup.service;


import in.shurup.model.Page;
import in.shurup.model.Way;
import in.shurup.utils.Jokes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class ResponseService {

    Map<Integer, Page> pages;
    private static Logger log = Logger.getLogger("ResponseService");

    @Autowired
    public ResponseService(Map<Integer, Page> pages) {
        this.pages = pages;
    }

    public Page process(String var) {
        int pos;
        try {
            pos = Integer.parseInt(var);
            var page = pages.get(pos);
            // extra data
            switch (pos) {
                case 15:
                    page.setText(Jokes.make());
                default:
                    ;
            }

            if (page != null) return page;
        } catch (NumberFormatException ignored) {
            log.info("NumberFormatException");
        }


        return var == null ? new Page("Your target is \"shurup.in\" site?<br><t>Вы направляетесь на сайт \"shurup.in\" ?</t>", List.of(
                new Way("0", "yes", "1/y"),
                new Way("https://www.google.com/", "no", "0/n"))) :
                new Page("Do you know what you want?<br><t>Вы знаете, что вы хотите?</t>", List.of(new Way()));
    }

    public Page processErr(String var) {
        throw new RuntimeException("For test forever!");
    }
}
