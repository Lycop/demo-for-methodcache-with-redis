package love.kill.demoformethodcachewithredis.service;


import love.kill.demoformethodcachewithredis.domain.DemoDTO;

/**
 *
 *
 * @author Lycop
 */
public interface IsolationStrategyService {

	/**
	 * 无缓存的循环请求
	 * */
	DemoDTO loopWithoutCache(DemoDTO demoDTO);

	/**
	 * 带缓存的循环请求
	 * */
	DemoDTO loopWithCache(DemoDTO demoDTO);
}