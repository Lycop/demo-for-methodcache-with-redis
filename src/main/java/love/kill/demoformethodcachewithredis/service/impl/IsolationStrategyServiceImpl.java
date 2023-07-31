package love.kill.demoformethodcachewithredis.service.impl;


import love.kill.demoformethodcachewithredis.domain.DemoDTO;
import love.kill.demoformethodcachewithredis.service.DemoService;
import love.kill.demoformethodcachewithredis.service.IsolationStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author Lycop
 */
@Service
public class IsolationStrategyServiceImpl implements IsolationStrategyService {

	@Autowired
	private DemoService demoService;

	@Override
	public DemoDTO loopWithoutCache(DemoDTO demoDTO) {
		// 5次请求
		demoService.getWithoutCache(new DemoDTO());
		demoService.getWithoutCache(new DemoDTO());
		demoService.getWithoutCache(new DemoDTO());
		demoService.getWithoutCache(new DemoDTO());
		return demoService.getWithoutCache(new DemoDTO());
	}

	@Override
	public DemoDTO loopWithCache(DemoDTO demoDTO) {
		// 5次请求
		demoService.getWithCache1(new DemoDTO());
		demoService.getWithCache1(new DemoDTO());
		demoService.getWithCache1(new DemoDTO());
		demoService.getWithCache1(new DemoDTO());
		return demoService.getWithCache1(new DemoDTO());
	}
}
