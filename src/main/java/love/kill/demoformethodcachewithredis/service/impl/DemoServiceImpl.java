package love.kill.demoformethodcachewithredis.service.impl;

import love.kill.demoformethodcachewithredis.domain.DemoDTO;
import love.kill.demoformethodcachewithredis.service.DemoService;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author Lycop
 */
@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public String getDataWithoutMethodCache(String key, DemoDTO demoDTO) {
		return doGetData(key,demoDTO);
	}

	@Override
	public String getDataWithMethodCache(String key, DemoDTO demoDTO) {
		return doGetData(key,demoDTO);
	}

	private String doGetData(String key, DemoDTO demoDTO){
		try {
			// 模拟耗时的业务处理
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello world!key=" + key + ";demo=" + demoDTO;
	}
}
