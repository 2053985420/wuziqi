package wuziqi;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonListener implements GoBangconfig, ActionListener {
	public GoBangframe gf;

	public ButtonListener(GoBangframe gf) {
		this.gf = gf;// ��ȡ��벿�ֵĻ���
	}

	// �����淢������ʱ����
	public void actionPerformed(ActionEvent e) {
		// ��ȡ��ǰ������İ�ť���ݣ��ж��ǲ��ǡ���ʼ����Ϸ�������ť
		if (e.getActionCommand().equals("��ʼ����Ϸ")) {
			// �����ǿ�ʼ����Ϸ��ť����Ϊ��벿������������
			for (int i = 0; i < gf.isAvail.length; i++)
				for (int j = 0; j < gf.isAvail[i].length; j++)
					gf.isAvail[i][j] = 0;
			gf.repaint();
			// ����ǿ�ʼ����Ϸ�İ�ť����Ϊ��벿�����ü�������
			gf.turn = 1;
		}
		// �жϵ�ǰ����İ�ť�ǲ��ǻ���
		else if (e.getActionCommand().equals("����")) {
			if (gf.ChessPositionList.size() > 1) {
				// ������������Ӧ��λ����Ϊ0��
				ChessPosition l = new ChessPosition();
				// ��ȡ���һ�����ӵĶ�����Ϣ
				l = gf.ChessPositionList.remove(gf.ChessPositionList.size() - 1);
				// ����Ӧ������λ����Ϊ0
				gf.isAvail[l.Listi][l.Listj] = 0;
				// ����һ�ԭΪ��һ���
				if (gf.turn == 1)
					gf.turn++;
				else
					gf.turn--;

				gf.repaint();
			} else {
				gf.PopUp("���ܻ���");
				System.out.println("���ܻ���");
			}
		} else if (e.getActionCommand().equals("����")) {
			if (gf.turn == 1)
				gf.PopUp("�׷�Ӯ");
			else
				gf.PopUp("�ڷ�Ӯ");
		}
	}

}
