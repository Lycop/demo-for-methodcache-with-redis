package love.kill.demoformethodcachewithredis.controller;

import love.kill.demoformethodcachewithredis.domain.DemoDTO;
import love.kill.demoformethodcachewithredis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

/**
 *
 *
 * @author Lycop
 */
@RestController
@RequestMapping("/demo")
public class Demo4MethodCache {

	@Autowired
	private DemoService demoService;

	@Value("${server.port}")
	private String port;


	@GetMapping("/withoutmethodcache")
	public String withoutMethodCache(@RequestParam(value = "key",required = false) String key, @RequestParam(value = "val",required = false) String val){
		long start = new Date().getTime();
		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getDataWithoutMethodCache("", demoDTO) + "。（处理耗时：" + (new Date().getTime() -  start + "毫秒）");
	}


	@GetMapping("/withmethodcache")
	public String withMethodCache(@RequestParam(value = "key",required = false) String key, @RequestParam(value = "val",required = false) String val){
		long start = new Date().getTime();
		DemoDTO demoDTO = new DemoDTO();
		demoDTO.setKey(key);
		demoDTO.setVal(val);
		return demoService.getDataWithMethodCache("", demoDTO) + "。（耗时：" + (new Date().getTime() -  start + "毫秒）");
	}

	@GetMapping("/dosomethingandclear")
	public void clear(){

		// do something...

		// 清空指定缓存
		String url = "http://localhost:" + port + "/methodcache/cache";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("id", "getDataWithMethodCache");

		new RestTemplate().delete(builder.build(true).toUri());
	}
}
