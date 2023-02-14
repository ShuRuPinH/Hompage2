package in.shurup.controler;


import in.shurup.service.ResponseService;
import in.shurup.utils.HtmlPageGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static in.shurup.utils.HtmlPageGenerator.getHtmlPage;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping
public class Controller {

    private ResponseService responseService;

    @GetMapping({"","/{var}"})
    ResponseEntity hello(Model model, @PathVariable(required = false)String var){
        log.info("var : " + var);
        var page = responseService.process(var);
        return ResponseEntity.ok(getHtmlPage(page));
    };
}
