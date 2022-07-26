package love.kill.demoformethodcachewithredis.domain;

/**
 * DemoDTO
 *
 * @author Lycop
 */
public class DemoDTO {
	String key;
	String val;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "DemoDTO{" +
				"key='" + key + '\'' +
				", val='" + val + '\'' +
				'}';
	}
}
