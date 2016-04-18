package demo;

import com.jfinal.core.Controller;

/**
 * 基础首页
 * Created by barryhippo on 16/4/18.
 */
public class IndexController extends Controller {
    public void index() {
        setAttr("Title", "test");
        setAttr("END", "body");
        render("index.jsp");
    }
}
