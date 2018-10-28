package wangzherongyao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


//import junit.framework.Assert;

class JueSeTest {

	@Test
	void testSetX() {
		JueSe test=new JueSe();
		test.setX(7);
		Assert.assertEquals(7, test.getX());
	}

	@Test
	void testSetY() {
		JueSe test=new JueSe();
		test.setY(7);
		Assert.assertEquals(7, test.getY());
	}

	@Test
	void testGetX() {
		JueSe test=new JueSe();
		test.setX(7);
		Assert.assertEquals(7, test.getX());
	}

	@Test
	void testGetY() {
		JueSe test=new JueSe();
		test.setY(7);
		Assert.assertEquals(7, test.getY());
	}

	@Test
	void testGetExpJueSe() {
		JueSe test=new JueSe();
		JueSe test1=new JueSe();
		test.getExp(test1);
		Assert.assertEquals(10, test.getExp());
	}

	@Test
	void testGetMoYang() {
		JueSe test=new SheShou();
		Assert.assertEquals('S', test.getMoYang());
	}

	@Test
	void testSetMoYang() {
		JueSe test=new JueSe();
		test.setMoYang('$');
		Assert.assertEquals('$', test.getMoYang());
	}

	@Test
	void testGetExp() {
		JueSe test=new JueSe();
		Assert.assertEquals(5, test.getExp());
	}

	@Test
	void testKouXue() {
		JueSe test=new SheShou();
		test.kouXue(10);
		Assert.assertEquals(20, test.getHp());
	}

	@Test
	void testGetHp() {
		JueSe test=new SheShou();
		Assert.assertEquals(30, test.getHp());
	}

	@Test
	void testYiDong() {
		char[][] map=new char[5][5];
		for(int a=0;a<5;a++)
			for(int b=0;b<5;b++)
				map[a][b]='*';
		JueSe test=new SheShou();
		test.setX(0);
		test.setY(0);
		test.yiDong(map, 5);
		Assert.assertEquals('S', map[test.getY()][test.getX()]);
	}

}
