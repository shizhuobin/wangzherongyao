package wangzherongyao;

/**
 * <p>主要的类有JueSe和他的子类SheShou，ZhanShi和FaShi，还有个JiNeng接口。<br/>
 * <p>基本属性包括生命值HP、魔法值MP、经验值Exp、等级lv、样子moYang、坐标x和y；<br/>
 * 基本方法有发呆、移动、释放技能、得到经验值、扣血。
 * @author bin
 *
 */

import java.util.Scanner;

public class JueSe implements JiNeng{
	int hp;
	int mp;
	int exp;
	int gongJiLi;
	int lv;
	char moYang;
	int x;
	int y;
	int sheCheng;
	Scanner sc=new Scanner(System.in);
	public JueSe()
	{
		exp=5;
		moYang='A';
		lv=1;
	}
	public void setX(int a)
	{
		x=a;
	}
	public void setY(int a)
	{
		y=a;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void getExp(JueSe a)
	{
		exp+=a.getExp();
	}
	public char getMoYang()
	{
		return moYang;
	}
	public void setMoYang(char a)
	{
		moYang=a;
	}
	public int getExp()
	{
		return exp;
	}
	public void faDai()
	{

	}
	public void puTongGongJi(JueSe a)
	{
		a.kouXue(gongJiLi);
	}
	public void kouXue(int a)
	{
		hp-=a;
	}
	public void jiNeng(char[][] map,int bianChang,JueSe[] player)
	{
		
	}
	/**
	 * 得到角色血量
	 * @return 血量
	 */
	public int getHp()
	{
		return hp;
	}
	/**
	 * 展示角色模样和血量。
	 */
	public void show()
	{
		System.out.print(moYang);
		System.out.print(" ");
		System.out.print(hp);
		System.out.print(" ");
	}
	/**
	 * <p>在提供的地图里移动并修改角色的坐标。
	 * @param map 战场地图
	 * @param bianChang 战场边长
	 */
	public void yiDong(char[][] map,int bianChang)
	{
		System.out.println("请输入方向和移动距离（u为上，d为下，l为左，r为右）:");
		String fangXiang=sc.next();
		int juLi=sc.nextInt();
		if(fangXiang.equals("r"))
		{
			if(x+juLi>=bianChang)
			{
				System.out.println("超出边界,请重来");
				yiDong(map,bianChang);
			}
			if(map[y][x+juLi]=='#')
			{
				System.out.println("遇到障碍，移动失败。");
				return;
			}
			else if(map[y][x+juLi]=='!')
			{
				kouXue(5);
			}
			else if(map[y][x+juLi]=='_')
			{
				kouXue(8);
			}
				map[y][x+juLi]=moYang;
				map[y][x]='*';
				x=x+juLi;
		}
		else if(fangXiang.equals("l"))
		{
			if(x-juLi<0)
			{
				System.out.println("超出边界,请重来");
				yiDong(map,bianChang);
			}
			if(map[y][x-juLi]=='#')
			{
				System.out.println("遇到障碍，移动失败。");
				return;
			}
			else if(map[y][x-juLi]=='!')
			{
				kouXue(5);
			}
			else if(map[y][x-juLi]=='_')
			{
				kouXue(8);
			}
				map[y][x-juLi]=getMoYang();
				map[y][x]='*';
				x=x-juLi;
		}
		else if(fangXiang.equals("u"))
		{
			if(y-juLi<0)
			{
				System.out.println("超出边界,请重来");
				yiDong(map,bianChang);
			}
			if(map[y-juLi][x]=='#')
			{
				System.out.println("遇到障碍，移动失败。");
				return;
			}
			else if(map[y-juLi][x]=='!')
			{
				kouXue(5);
			}
			else if(map[y-juLi][x]=='_')
			{
				kouXue(8);
			}
				map[y-juLi][x]=getMoYang();
				map[y][x]='*';
				y=y-juLi;
		}
		else if(fangXiang.equals("d"))
		{
			if(y+juLi>=bianChang)
			{
				System.out.println("超出边界,请重来");
				yiDong(map,bianChang);
			}
			if(map[y+juLi][x]=='#')
			{
				System.out.println("遇到障碍，移动失败。");
				return;
			}
			else if(map[y+juLi][x]=='!')
			{
				kouXue(5);
			}
			else if(map[y+juLi][x]=='_')
			{
				kouXue(8);
			}
				map[y+juLi][x]=getMoYang();
				map[y][x]='*';
				y=y+juLi;
		}		
	}
}
/**
 * @inheritDoc
 * <p>死了的角色就变为尸体，血量为0，不会扣血。
 *
 */
class ShiTi extends JueSe implements JiNeng{
	public ShiTi()
	{
		super();
		moYang='*';
		hp=0;
		exp=0;
	}
	public void jiNeng(char[][] map,int bianChang)
	{
		System.out.println("当前角色已阵亡。");
	}
	public void kouXue(int a)
	{
		
	}
}

class SheShou extends JueSe implements JiNeng{
	Scanner sc=new Scanner(System.in);
	public SheShou(){
		super();
		moYang='S';
		gongJiLi=10;
		hp=30;
	}
	public void jiNeng(char[][] map,int bianChang,JueSe[] player)
	{
		System.out.println("请输入箭雨的方向（l为左，r为右）:");
		String s=sc.next();
		if(s.equals("r"))
		{
		for(int b=-1;b<=1;b++)
		{
			for(int a=1;a<=3;a++)
			{
				if(x+a<bianChang&&y+b<bianChang&&y+b>=0)
				{
					if(map[y+b][x+a+2]=='*'||map[y+b][x+a+2]=='#'||map[y+b][x+a+2]=='_')
						map[y+b][x+a+2]='!';
					else
					{
						for(int c=0;c<5;c++)
						{
							if(player[c].getX()==x+a+2&&player[c].getY()==y+b)
							{	
								player[c].kouXue(5);
								if(player[c].getHp()<=0)
								{
									getExp(player[c]);
									player[c]=new ShiTi();
									map[y+b][x+a+2]='*';
								}
							}
						}
					}
				}		
			}
		}
		}
		else if(s.equals("l"))
		{
		for(int b=-1;b<=1;b++)
		{
			for(int a=1;a<=3;a++)
			{
				if(x-a>=0&&y+b<bianChang&&y+b>=0)
				{
					if(map[y+b][x-a-2]=='*'||map[y+b][x-a-2]=='#'||map[y+b][x-a-2]=='_')
						map[y+b][x-a-2]='!';
					else
					{
						for(int c=0;c<5;c++)
						{
							if(player[c].getX()==x-a-2&&player[c].getY()==y+b)
							{
								player[c].kouXue(5);
								if(player[c].getHp()<=0)
								{
									getExp(player[c]);
									player[c]=new ShiTi();
									map[y+b][x-a-2]='*';
								}
							}
						}
					}
				}		
			}
		}
		}
		else
		{
			System.out.println("输入错误。");
			jiNeng(map,bianChang,player);
		}
	}
}

class ZhanShi extends JueSe implements JiNeng{
	public ZhanShi(){
		super();
		moYang='Z';
		gongJiLi=15;
		hp=50;
	}
	public void jiNeng(char[][] map,int bianChang,JueSe[] player)
	{
		System.out.println("请输入裂地斩的方向（u为上，d为下，l为左，r为右）:");
		String s=sc.next();
		if(s.equals("r"))
		{
			for(int a=1;a<=4;a++)
			{
				if(x+a<bianChang)
				{
					if(map[y][x+a]=='*'||map[y][x+a]=='#'||map[y][x+a]=='!')
						map[y][x+a]='_';
					else
					{
						for(int c=0;c<5;c++)
						{
							if(player[c].getX()==x+a&&player[c].getY()==y)
							{	player[c].kouXue(8);
							if(player[c].getHp()<=0)
							{
								getExp(player[c]);
								player[c]=new ShiTi();
								map[y][x+a]='*';
							}
							}
						}
					}
				}		
			}
		}
		else if(s.equals("l"))
		{
			for(int a=1;a<=4;a++)
			{
				if(x-a>=0)
				{
					if(map[y][x-a]=='*'||map[y][x-a]=='#'||map[y][x-a]=='!')
						map[y][x-a]='_';
					else
					{
						for(int c=0;c<5;c++)
						{
							if(player[c].getX()==x-a&&player[c].getY()==y)
							{	player[c].kouXue(8);
							if(player[c].getHp()<=0)
							{
								getExp(player[c]);
								player[c]=new ShiTi();
								map[y][x-a]='*';
							}
							}
						}
					}
				}
			}
		}
		else if(s.equals("u"))
		{
			for(int a=1;a<=4;a++)
			{
				if(y-a>=0)
				{
					if(map[y-a][x]=='*'||map[y-a][x]=='#'||map[y-a][x]=='!')
						map[y-a][x]='_';
					else
					{
						for(int c=0;c<5;c++)
						{
							if(player[c].getX()==x&&player[c].getY()==y-a)
							{	player[c].kouXue(8);
							if(player[c].getHp()<=0)
							{
								getExp(player[c]);
								player[c]=new ShiTi();
								map[y-a][x]='*';
							}
							}
						}
					}
				}		
			}
		}
		else if(s.equals("d"))
		{
			for(int a=1;a<=4;a++)
			{
				if(y+a<bianChang)
				{
					if(map[y+a][x]=='*'||map[y+a][x]=='#'||map[y+a][x]=='!')
						map[y+a][x]='_';
				}
				else
				{
					for(int c=0;c<5;c++)
					{
						if(player[c].getX()==x&&player[c].getY()==y+a)
						{	player[c].kouXue(8);
						if(player[c].getHp()<=0)
						{
							getExp(player[c]);
							player[c]=new ShiTi();
							map[y+a][x]='*';
						}
						}
					}
				}
			}
		}
		else
		{
			System.out.println("输入错误。");
			jiNeng(map,bianChang,player);
		}		
	}
}

class FaShi extends JueSe implements JiNeng{
	public FaShi(){
		super();
		moYang='F';
		gongJiLi=5;
		hp=25;
	}
	public void jiNeng(char[][] map,int bianChang,JueSe[] player)
	{
		System.out.println("法师已冻结周围。");
		for(int a=-1;a<=1;a++)
		{
			for(int b=-1;b<=1;b++)
			{
				if(a==0&&b==0)
					continue;
				if(x+a<bianChang&&x+a>=0&&y+b<bianChang&&y+b>=0)
				{
					if(map[y+b][x+a]=='*'||map[y+b][x+a]=='!'||map[y+b][x+a]=='_')
						map[y+b][x+a]='#';
					else
					{
						for(int c=0;c<5;c++)
						{
							if(player[c].getX()==x+a&&player[c].getY()==y+b)
							{	player[c].kouXue(12);
							if(player[c].getHp()<=0)
							{
								getExp(player[c]);
								player[c]=new ShiTi();
								map[y+b][x+a]='*';
							}
							}
						}
					}
				}
			}
		}
	}
}

interface JiNeng{
	void jiNeng(char[][] map,int bianChang,JueSe[] player);
}