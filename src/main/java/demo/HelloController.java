package demo;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
    public void index() {
        renderText("Hello JFinal World.");
    }

    public void test() {
        render("myjsp.jsp");
    }
}
