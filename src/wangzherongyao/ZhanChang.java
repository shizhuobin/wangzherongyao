package wangzherongyao;
/**
 * <p>��Ҫ������ZhanChang<br/>
 * <p>�������԰�����ͼmap����ͼ�߳�bianChang����ɫ������player1��player2����ǰ���dangQianWanJia�͵�ǰ��ɫdangQianJueSe;<br/>
 * ���������ж���ս��set()���������ָ��chuLiZhiLing()�������ϰ�qingLiZhangAi()��ս��չʾshow()��
 * @author bin
 *
 */
import java.util.Scanner;


public class ZhanChang {
	char[][] map;
	int bianChang;
	JueSe[] player1=new JueSe[5];
	JueSe[] player2=new JueSe[5];
	int dangQianplayer;
	int dangQianJueSe;
	Scanner sc=new Scanner(System.in);
	int tag;
	public ZhanChang()
	{
		bianChang=10;
		map=new char[10][10];
		for(int a=0;a<10;a++)
			for(int b=0;b<10;b++)
				map[a][b]='*';
		dangQianplayer=1;
		dangQianJueSe=0;
	}
	ZhanChang(int n)
	{
		bianChang=n;
		map=new char[n][n];
	}
	public void set()
	{
		System.out.println("���������1��5����ɫ��S��ʾ���֣�Z��ʾսʿ��F��ʾ��ʦ����");
		String s1=sc.next();
		for(int a=0;a<5;a++)
		{
			if(s1.charAt(a)=='S')
			{
				player1[a]=new SheShou();
			}
			else if(s1.charAt(a)=='Z')
			{
				player1[a]=new ZhanShi();
			}
			else if(s1.charAt(a)=='F')
			{
				player1[a]=new FaShi();
			}
			tag=1;
		}
		System.out.println("���������2��5����ɫ��S��ʾ���֣�Z��ʾսʿ��F��ʾ��ʦ����");
		String s2=sc.next();
		for(int a=0;a<5;a++)
		{
			if(s2.charAt(a)=='S')
			{
				player2[a]=new SheShou();
			}
			else if(s2.charAt(a)=='Z')
			{
				player2[a]=new ZhanShi();
			}
			else if(s2.charAt(a)=='F')
			{
				player2[a]=new FaShi();
			}
		}
		for(int a=0,b=0;a<10;a+=2,b++)
		{
			map[a][0]=player1[b].getMoYang();
			player1[b].setX(0);
			player1[b].setY(a);
			map[a][9]=player2[b].getMoYang();
			player2[b].setX(9);
			player2[b].setY(a);
		}
	}
	public void chuLiZhiLing()
	{
		if(tag==3)
		{
			qingLiZhangAi();
			tag=1;
		}
		if(dangQianplayer==1&&player1[dangQianJueSe].getHp()<=0) {}
		else if(dangQianplayer==2&&player2[dangQianJueSe-5].getHp()<=0) {}
		else
		{
		show();
		System.out.println("���"+dangQianplayer+"������Խ�ɫ"+(dangQianJueSe+1)+"����ָ�yΪ�ƶ���ǰ��ɫ��fΪ��ǰ��ɫ����,jΪ��������,sΪ������Ϸ����");
		String zhiLing=sc.next();

		if(zhiLing.equals("y"))	{if(dangQianplayer==1) {player1[dangQianJueSe].yiDong(map, bianChang);} else{player2[dangQianJueSe-5].yiDong(map, bianChang);}}
		else if(zhiLing.equals("f")){}
		else if(zhiLing.equals("s")){ System.out.println("лл����\n"); return;}
		else if(zhiLing.equals("j")){ if(dangQianplayer==1) player1[dangQianJueSe].jiNeng(map, bianChang,player2); else player2[dangQianJueSe-5].jiNeng(map, bianChang,player1);}
		else {System.out.println("�������"); chuLiZhiLing();}
		show();
		System.out.print("\n");
		}
		dangQianJueSe++;
		if(dangQianJueSe==5)
		{
			dangQianplayer=2;
			chuLiZhiLing();
		}
		else if(dangQianJueSe==10)
		{
			tag++;
			dangQianplayer=1;
			dangQianJueSe=0;
			chuLiZhiLing();			
		}
		else
		{
			chuLiZhiLing();	
		}
	}
	public void qingLiZhangAi()
	{
		for(int a=0;a<bianChang;a++)
		{
			for(int b=0;b<bianChang;b++)
			{
				if(map[a][b]=='_'||map[a][b]=='!'||map[a][b]=='#')
						map[a][b]='*';
			}
		}
	}
	public void show()
	{
		for(int a=0;a<bianChang;a++)
		{
			for(int b=0;b<bianChang;b++)
				System.out.print(map[a][b]);
			System.out.print("\n");
		}
		System.out.println("��ɫѪ����");
		for(int a=0;a<5;a++)
		{
			System.out.print("��ɫ");
			System.out.print(a+1);
			System.out.print(" ");
			System.out.print(player1[a].getHp());
			System.out.print(" ");
		}
		System.out.print("\n");
		for(int a=0;a<5;a++)
		{
			System.out.print("��ɫ");
			System.out.print(a+6);
			System.out.print(" ");
			System.out.print(player2[a].getHp());
			System.out.print(" ");
		}
		System.out.print("\n");
	}
}