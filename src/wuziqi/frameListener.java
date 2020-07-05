package wuziqi;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;
import java.awt.Color;

//实现对GoBangframe下棋界面的监听接口处理
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
		// 计算棋子要落在期盼的哪个交叉点上
		int countx = (x / 40) * 40 + 20;
		int county = (y / 40) * 40 + 20;
		Graphics g = gf.getGraphics();
		int colu = (countx - 20) / 40;
		int ro = (county - 20) / 40;
		
		if (gf.turn != 0)
			if (gf.isAvail[colu][ro] != 0) {
				gf.PopUp("此处已经有棋子了，请下在其他地方！");
				System.out.println("此处已经有棋子了，请下在其他地方！");
			} else {
				// 先计算棋盘上棋子在数组中相应的位置
				if (gf.turn == 1) {
					// 先设置颜色
					g.setColor(Color.black);
					// 落子
					g.fillOval(countx - size / 2, county - size / 2, size, size);
					// 设置当前位置已经有棋子了，棋子为黑子
					gf.isAvail[colu][ro] = 1;
					gf.turn++;
					// 把当前所下棋子位置保存在动态数组中
					gf.ChessPositionList.add(new ChessPosition(colu, ro));

					// 判断是否已经出现五颗棋子了
					// 行判断
					int imin = colu - 4, imax = colu + 4;
					if (imin < 0)
						imin = 0;
					if (imax > 14)
						imax = 14;
					int count1 = 0;// 判断相连的棋子数
					for (int i = imin; i <= imax; i++) {
						if (gf.isAvail[i][ro] == 1)
							count1++;
						// 如果出现其他棋子或者没有棋子，就重新开始计数
						else
							count1 = 0;
						if (count1 == 5) {
							System.out.println("黑方赢");
							gf.PopUp("黑方赢");
							gf.turn = 0;
							return;
						}
					}

					// 列判断
					int jmin = ro - 4, jmax = ro + 4;
					if (jmin < 0)
						jmin = 0;
					if (jmax > 14)
						jmax = 14;
					int count2 = 0;// 判断相连的棋子数
					for (int j = jmin; j <= jmax; j++) {
						if (gf.isAvail[colu][j] == 1)
							count2++;
						else
							count2 = 0;
						if (count2 == 5) {
							System.out.println("黑方赢");
							gf.PopUp("黑方赢");
							gf.turn = 0;
							return;
						}
					}

					// 135度判断
					int count3 = 0;
					for (int i = -4; i <= 4; i++) {
						if ((colu + i >= 0) && (ro + i >= 0) && (colu + i <= 14) && (ro + i <= 14)) {
							if (gf.isAvail[colu + i][ro + i] == 1)
								count3++;
							else
								count3 = 0;
							if (count3 == 5) {
								System.out.println("黑方赢");
								gf.PopUp("黑方赢");
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
								System.out.println("黑方赢");
								gf.PopUp("黑方赢");
								gf.turn = 0;
								return;
							}
						}
					}
				} else if (gf.turn == 2) {
					g.setColor(Color.white);
					g.fillOval(countx - size / 2, county - size / 2, size, size);
					// 设置当前位置已经有棋子了，棋子为白子
					gf.ChessPositionList.add(new ChessPosition(colu, ro));
					gf.isAvail[colu][ro] = 2;
					gf.turn--;

					// 判断是否已经出现五颗棋子了
					// 行判断
					int imin = colu - 4, imax = colu + 4;
					if (imin < 0)
						imin = 0;
					if (imax > 14)
						imax = 14;
					int count1 = 0;// 判断相连的棋子数
					for (int i = imin; i <= imax; i++) {
						if (gf.isAvail[i][ro] == 2)
							count1++;
						// 如果出现其他棋子或者没有棋子，就重新开始计数
						else
							count1 = 0;
						if (count1 == 5) {
							System.out.println("白方赢");
							gf.PopUp("白方赢");
							gf.turn = 0;
							return;
						}
					}

					// 列判断
					int jmin = ro - 4, jmax = ro + 4;
					if (jmin < 0)
						jmin = 0;
					if (jmax > 14)
						jmax = 14;
					int count2 = 0;// 判断相连的棋子数
					for (int j = jmin; j <= jmax; j++) {
						if (gf.isAvail[colu][j] == 2)
							count2++;
						else
							count2 = 0;
						if (count2 == 5) {
							System.out.println("白方赢");
							gf.PopUp("白方赢");
							gf.turn = 0;
							return;
						}
					}

					// 135度判断
					int count3 = 0;
					for (int i = -4; i <= 4; i++) {
						if ((colu + i >= 0) && (ro + i >= 0) && (colu + i <= 14) && (ro + i <= 14)) {
							if (gf.isAvail[colu + i][ro + i] == 2)
								count3++;
							else
								count3 = 0;
							if (count3 == 5) {
								System.out.println("白方赢");
								gf.PopUp("白方赢");
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
								System.out.println("白方赢");
								gf.PopUp("白方赢");
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
