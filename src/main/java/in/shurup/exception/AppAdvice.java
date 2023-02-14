package in.shurup.exception;

import in.shurup.model.Page;
import in.shurup.model.Way;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import static in.shurup.utils.HtmlPageGenerator.getHtmlPage;

@ControllerAdvice
public class AppAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeError(RuntimeException e) {
        return ResponseEntity.badRequest().body(
                getHtmlPage(new Page(
                        "<err>" + e.toString() + "</err><br>" +
                                "The server doesn't know what to do with it...<br><t>Сервер не знает, что с этим делать...</t>",
                        List.of(new Way()))));
    }

}
