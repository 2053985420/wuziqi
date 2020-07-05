package test;

import javax.swing.JButton;

import org.junit.jupiter.api.Test;

import wuziqi.ButtonListener;
import wuziqi.GoBangframe;

public class ButtonListenerTest {
	private GoBangframe gftest = new GoBangframe();

	@Test
	public void testactionPerformed() {
		int flag = 0;
		String[] butname = { "��ʼ����Ϸ", "����", "����" };
		//
		JButton[] button = new JButton[3];
		for (int i = 0; i < butname.length; i++) {
			button[i] = new JButton(butname[i]);
		}

		ButtonListener butListen = new ButtonListener(gftest);
		// ��ÿһ����ť�����״̬�¼��ļ����������
		for (int i = 0; i < butname.length; i++) {
			button[i].addActionListener(butListen);
		}

		button[0].doClick();
		{
			for (int i = 0; i < gftest.isAvail.length; i++)
				for (int j = 0; j < gftest.isAvail[i].length; j++)
					if (gftest.isAvail[i][j] == 0 && gftest.turn == 1)
						flag = 1;
					else
						flag = 0;
			if (flag == 1)
				System.out.println("��ʼ����Ϸ��ť���Գɹ�");
		}
		button[1].doClick();
		{
			System.out.println(gftest.turn);
			System.out.println("���尴ť���Գɹ�");
		}
		button[2].doClick();
		{
			System.out.println("���䰴ť���Գɹ�");
		}
	}

}
