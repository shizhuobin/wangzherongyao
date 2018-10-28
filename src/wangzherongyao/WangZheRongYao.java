package wangzherongyao;
/**
 * <p>这是个回合制的简易版王者荣耀
 * @author bin
 *
 */

public class WangZheRongYao {
	public static void main(String[] args) {
		ZhanChang map=new ZhanChang();
		map.set();//自定义战场和游戏双方
		map.chuLiZhiLing();	//处理游戏指令
	}
}
