package se.denize.examensarbete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

        @GetMapping("/index")
        public String displayHomepage(){
            return "index";
        }
}
