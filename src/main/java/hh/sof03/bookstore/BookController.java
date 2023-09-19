package hh.sof03.bookstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/index")
    public String index() {
        return "index"; // index.html
    }

}
