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
	public DemoDTO getWithoutCache(DemoDTO demoDTO) {
		return doGetData(demoDTO, 1000);
	}

	@Override
	public DemoDTO getWithCache1(DemoDTO demoDTO) {
		return doGetData(demoDTO, 1000);
	}

	@Override
	public DemoDTO getWithCache2(DemoDTO demoDTO) {
		return doGetData(demoDTO, 500);
	}

	@Override
	public int getWithCache3(DemoDTO demoDTO) {
		DemoDTO resultDTO = doGetData(demoDTO, 500);
		return resultDTO.getKey().hashCode() + resultDTO.getVal().hashCode();
	}

	private DemoDTO doGetData(DemoDTO demoDTO, int sleep){
		try {
			// 模拟耗时的业务处理
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		demoDTO.setResponse("hello world! key=" + demoDTO.getKey() + ", val=" + demoDTO.getVal());
		return demoDTO;
	}

}
