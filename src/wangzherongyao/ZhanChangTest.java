package wangzherongyao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ZhanChangTest {

	@Test
	void testSet() {
		ZhanChang map=new ZhanChang();
		//map.set();
		
	}

	@Test
	void testChuLiZhiLing() {
		ZhanChang map=new ZhanChang();
	}

	@Test
	void testQingLiZhangAi() {
		ZhanChang map=new ZhanChang();
		map.map[3][3]='#';
		map.qingLiZhangAi();
		Assert.assertEquals('*', map.map[3][3]);
	}

	@Test
	void testShow() {
		ZhanChang map=new ZhanChang();
	}

}
