package wangzherongyao;
/**
 * <p>这是个回合制的简易版王者荣耀
 * @author bin
 *
 */
//import java.util.Scanner;

public class WangZheRongYao {
	public static void main(String[] args) {
		ZhanChang map=new ZhanChang();
		//map.caozuo();
		//Scanner sc=new Scanner(System.in);
		map.set();
		map.chuLiZhiLing();
		//sc.close();		
	}
}
