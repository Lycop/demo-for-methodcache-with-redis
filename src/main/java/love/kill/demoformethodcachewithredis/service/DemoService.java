package love.kill.demoformethodcachewithredis.service;

import love.kill.demoformethodcachewithredis.domain.DemoDTO;
import love.kill.methodcache.annotation.CacheData;

/**
 *
 *
 * @author Lycop
 */
public interface DemoService {

	String getDataWithoutMethodCache(String key, DemoDTO demoDTO);

	@CacheData(id = "getDataWithMethodCache", refresh = false, remark = "从缓存获取数据例子")
	String getDataWithMethodCache(String key, DemoDTO demoDTO);

}