package wuziqi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Color;

//ʵ�ֶ�GoBangframe�������ļ����ӿڴ���
public class frameListener implements GoBangconfig, MouseListener {
	public GoBangframe gf;
	GoBangconfig go;

	public void setGraphics(GoBangframe gf) {
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		//int x1=e.getXOnScreen();
		//int y2=e.getYOnScreen();
		//System.out.println(x1+" "+y2);
		// ��������Ҫ�������ε��ĸ��������
		int countx = (x / 40) * 40 + 20;
		int county = (y / 40) * 40 + 20;
		Graphics g = gf.getGraphics();
		int colu = (countx - 20) / 40;
		int ro = (county - 20) / 40;
		
		if (gf.turn != 0)
			if (gf.isAvail[colu][ro] != 0) {
				gf.PopUp("�˴��Ѿ��������ˣ������������ط���");
				System.out.println("�˴��Ѿ��������ˣ������������ط���");
			} else {
				// �ȼ�����������������������Ӧ��λ��
				if (gf.turn == 1) {
					// ��������ɫ
					g.setColor(Color.black);
					// ����
					g.fillOval(countx - size / 2, county - size / 2, size, size);
					// ���õ�ǰλ���Ѿ��������ˣ�����Ϊ����
					gf.isAvail[colu][ro] = 1;
					gf.turn++;
					// �ѵ�ǰ��������λ�ñ����ڶ�̬������
					gf.ChessPositionList.add(new ChessPosition(colu, ro));

					// �ж��Ƿ��Ѿ��������������
					// ���ж�
					int imin = colu - 4, imax = colu + 4;
					if (imin < 0)
						imin = 0;
					if (imax > 14)
						imax = 14;
					int count1 = 0;// �ж�������������
					for (int i = imin; i <= imax; i++) {
						if (gf.isAvail[i][ro] == 1)
							count1++;
						// ��������������ӻ���û�����ӣ������¿�ʼ����
						else
							count1 = 0;
						if (count1 == 5) {
							System.out.println("�ڷ�Ӯ");
							gf.PopUp("�ڷ�Ӯ");
							gf.turn = 0;
							return;
						}
					}

					// ���ж�
					int jmin = ro - 4, jmax = ro + 4;
					if (jmin < 0)
						jmin = 0;
					if (jmax > 14)
						jmax = 14;
					int count2 = 0;// �ж�������������
					for (int j = jmin; j <= jmax; j++) {
						if (gf.isAvail[colu][j] == 1)
							count2++;
						else
							count2 = 0;
						if (count2 == 5) {
							System.out.println("�ڷ�Ӯ");
							gf.PopUp("�ڷ�Ӯ");
							gf.turn = 0;
							return;
						}
					}

					// 135���ж�
					int count3 = 0;
					for (int i = -4; i <= 4; i++) {
						if ((colu + i >= 0) && (ro + i >= 0) && (colu + i <= 14) && (ro + i <= 14)) {
							if (gf.isAvail[colu + i][ro + i] == 1)
								count3++;
							else
								count3 = 0;
							if (count3 == 5) {
								System.out.println("�ڷ�Ӯ");
								gf.PopUp("�ڷ�Ӯ");
								gf.turn = 0;
								return;
							}
						}
					}

					int count4 = 0;
					for (int i = -4; i <= 4; i++) {
						if ((colu + i >= 0) && (ro - i >= 0) && (colu + i <= 14) && (ro - i <= 14)) {
							if (gf.isAvail[colu + i][ro - i] == 1)
								count4++;
							else
								count4 = 0;
							if (count4 == 5) {
								System.out.println("�ڷ�Ӯ");
								gf.PopUp("�ڷ�Ӯ");
								gf.turn = 0;
								return;
							}
						}
					}
				} else if (gf.turn == 2) {
					g.setColor(Color.white);
					g.fillOval(countx - size / 2, county - size / 2, size, size);
					// ���õ�ǰλ���Ѿ��������ˣ�����Ϊ����
					gf.ChessPositionList.add(new ChessPosition(colu, ro));
					gf.isAvail[colu][ro] = 2;
					gf.turn--;

					// �ж��Ƿ��Ѿ��������������
					// ���ж�
					int imin = colu - 4, imax = colu + 4;
					if (imin < 0)
						imin = 0;
					if (imax > 14)
						imax = 14;
					int count1 = 0;// �ж�������������
					for (int i = imin; i <= imax; i++) {
						if (gf.isAvail[i][ro] == 2)
							count1++;
						// ��������������ӻ���û�����ӣ������¿�ʼ����
						else
							count1 = 0;
						if (count1 == 5) {
							System.out.println("�׷�Ӯ");
							gf.PopUp("�׷�Ӯ");
							gf.turn = 0;
							return;
						}
					}

					// ���ж�
					int jmin = ro - 4, jmax = ro + 4;
					if (jmin < 0)
						jmin = 0;
					if (jmax > 14)
						jmax = 14;
					int count2 = 0;// �ж�������������
					for (int j = jmin; j <= jmax; j++) {
						if (gf.isAvail[colu][j] == 2)
							count2++;
						else
							count2 = 0;
						if (count2 == 5) {
							System.out.println("�׷�Ӯ");
							gf.PopUp("�׷�Ӯ");
							gf.turn = 0;
							return;
						}
					}

					// 135���ж�
					int count3 = 0;
					for (int i = -4; i <= 4; i++) {
						if ((colu + i >= 0) && (ro + i >= 0) && (colu + i <= 14) && (ro + i <= 14)) {
							if (gf.isAvail[colu + i][ro + i] == 2)
								count3++;
							else
								count3 = 0;
							if (count3 == 5) {
								System.out.println("�׷�Ӯ");
								gf.PopUp("�׷�Ӯ");
								gf.turn = 0;
								return;
							}
						}
					}

					int count4 = 0;
					for (int i = -4; i <= 4; i++) {
						if ((colu + i >= 0) && (ro - i >= 0) && (colu + i <= 14) && (ro - i <= 14)) {
							if (gf.isAvail[colu + i][ro - i] == 2)
								count4++;
							else
								count4 = 0;
							if (count4 == 5) {
								System.out.println("�׷�Ӯ");
								gf.PopUp("�׷�Ӯ");
								gf.turn = 0;
								return;
							}
						}
					}
				}
			}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
}
