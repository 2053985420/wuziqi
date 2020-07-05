package wuziqi;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ButtonListener implements GoBangconfig, ActionListener {
	public GoBangframe gf;

	public ButtonListener(GoBangframe gf) {
		this.gf = gf;// 获取左半部分的画板
	}

	// 当界面发生操作时处理
	public void actionPerformed(ActionEvent e) {
		// 获取当前被点击的按钮内容，判断是不是“开始新游戏”这个按钮
		if (e.getActionCommand().equals("开始新游戏")) {
			// 若果是开始新游戏按钮，再为左半部分社会监听方法
			for (int i = 0; i < gf.isAvail.length; i++)
				for (int j = 0; j < gf.isAvail[i].length; j++)
					gf.isAvail[i][j] = 0;
			gf.repaint();
			// 如果是开始新游戏的按钮，再为左半部分设置监听方法
			gf.turn = 1;
		}
		// 判断当前点击的按钮是不是悔棋
		else if (e.getActionCommand().equals("悔棋")) {
			if (gf.ChessPositionList.size() > 1) {
				// 把旗子数组相应的位置置为0；
				ChessPosition l = new ChessPosition();
				// 获取最后一个棋子的对象信息
				l = gf.ChessPositionList.remove(gf.ChessPositionList.size() - 1);
				// 把相应的数组位置置为0
				gf.isAvail[l.Listi][l.Listj] = 0;
				// 把玩家还原为上一玩家
				if (gf.turn == 1)
					gf.turn++;
				else
					gf.turn--;

				gf.repaint();
			} else {
				gf.PopUp("不能悔棋");
				System.out.println("不能悔棋");
			}
		} else if (e.getActionCommand().equals("认输")) {
			if (gf.turn == 1)
				gf.PopUp("白方赢");
			else
				gf.PopUp("黑方赢");
		}
	}

}
