package wuziqi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GoBangframe extends JPanel implements GoBangconfig {

	public Graphics g;// 定义一支画笔
	public int[][] isAvail = new int[15][15];// 定义一个二维数组来存储期盼骡子情况
	public ArrayList<ChessPosition> ChessPositionList = new ArrayList<ChessPosition>();// 保存每一步的落子情况
	public int turn = 0;

	// 主函数
	public static void main(String args[]) {
		GoBangframe gf = new GoBangframe();// 初始化一个五子棋界面对象
		gf.initUI();// 调用方法进行界面的初始化
	}

	public void initUI() {
		// 初始化一个界面
		JFrame jf = new JFrame();
		jf.setTitle("五子棋");
		jf.setSize(800, 650);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);

		jf.setLayout(new BorderLayout());// 设置顶级容器JFrame为框架布局

		Dimension dim1 = new Dimension(150, 0);// 设置右半部分大小
		Dimension dim2 = new Dimension(140, 40);// 设置右边按钮组件的大小
		Dimension dim3 = new Dimension(550, 0);// 设置左半部分的大小

		// 实现左边的界面，吧GoBangframe的对象添加到框架布局的中间部分
		this.setPreferredSize(dim3);// 设置下棋界面的大小
		this.setBackground(Color.LIGHT_GRAY);// 设置下棋界面的颜色

		jf.add(this, BorderLayout.CENTER);// 添加到框架布局的中间部分

		// 实现右边的JPanel容器界面
		JPanel jp = new JPanel();
		jp.setPreferredSize(dim1);// 设置JPanel的大小
		jp.setBackground(Color.white);
		jf.add(jp, BorderLayout.EAST);// 添加到框架布局的东边部分
		jp.setLayout(new FlowLayout());// 设置JPanel为流式布局、
		// 设置按钮数组
		String[] butname = { "开始新游戏", "悔棋", "认输" };
		JButton[] button = new JButton[3];

		// 把三个按钮组件加上去
		for (int i = 0; i < butname.length; i++) {
			button[i] = new JButton(butname[i]);
			button[i].setPreferredSize((dim2));
			jp.add(button[i]);
		}

		// 按钮监控类
		ButtonListener butListen = new ButtonListener(this);
		// 对每一个按钮都添加状态事件的监听处理机制
		for (int i = 0; i < butname.length; i++) {
			button[i].addActionListener(butListen);// 添加发生操作的监听方法
		}

		frameListener fl = new frameListener();
		fl.setGraphics(this);// 获取画笔对象
		this.addMouseListener(fl);

		jf.setVisible(true);
	}

	public void PopUp(String result) {
		JOptionPane jo = new JOptionPane();
		jo.showMessageDialog(null, result, "提示", JOptionPane.PLAIN_MESSAGE);
	}

	// 重写重绘方法
	public void paint(Graphics g) {
		super.paint(g);

		// 重绘出棋盘
		g.setColor(Color.black);
		for (int i = 0; i < row; i++) {
			g.drawLine(x, y + size * i, x + size * (column - 1), y + size * i);
		}
		for (int j = 0; j < column; j++) {
			g.drawLine(x + size * j, y, x + size * j, y + size * (row - 1));
		}

		// 重绘出棋子
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (isAvail[i][j] == 1) {
					int countx = size * i + 20;
					int county = size * j + 20;
					g.setColor(Color.black);
					g.fillOval(countx - size / 2, county - size / 2, size, size);
				} else if (isAvail[i][j] == 2) {
					int countx = size * i + 20;
					int county = size * j + 20;
					g.setColor(Color.white);
					g.fillOval(countx - size / 2, county - size / 2, size, size);
				}
			}
		}
	}
}
