package ex4;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ShowWebPageController {
    @GetMapping("/home")
    public String home() {
        System.out.println("/home");
        return "index.jsp";
    }

    @GetMapping("/add")
    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession s) {
        System.out.println("/add");
        int num3 = num1 + num2;
        s.setAttribute("num3", num3);

        return "result.jsp";
    }
}
