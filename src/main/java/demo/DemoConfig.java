package demo;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import common._MappingKit;

public class DemoConfig extends JFinalConfig {
    public void configConstant(Constants me) {
        PropKit.use("config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
        me.setViewType(ViewType.JSP);
    }

    public void configRoute(Routes me) {
        me.add("/", IndexController.class);
        me.add("/hello", HelloController.class, "/hello");
    }

    private static C3p0Plugin createC3p0Plugin() {
        return new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    public void configPlugin(Plugins me) {
        // 配置C3p0数据库连接池插件
        C3p0Plugin C3p0Plugin = createC3p0Plugin();
        me.add(C3p0Plugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(C3p0Plugin);
        me.add(arp);

        // 所有配置在 MappingKit 中搞定
        _MappingKit.mapping(arp);
    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }
}
