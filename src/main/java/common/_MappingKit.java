package common;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import model.Blog;

public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("blog", "id", Blog.class);
	}
}