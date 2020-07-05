package wuziqi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GoBangframe extends JPanel implements GoBangconfig {

	public Graphics g;// ����һ֧����
	public int[][] isAvail = new int[15][15];// ����һ����ά�������洢�����������
	public ArrayList<ChessPosition> ChessPositionList = new ArrayList<ChessPosition>();// ����ÿһ�����������
	public int turn = 0;

	// ������
	public static void main(String args[]) {
		GoBangframe gf = new GoBangframe();// ��ʼ��һ��������������
		gf.initUI();// ���÷������н���ĳ�ʼ��
	}

	public void initUI() {
		// ��ʼ��һ������
		JFrame jf = new JFrame();
		jf.setTitle("������");
		jf.setSize(800, 650);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(3);

		jf.setLayout(new BorderLayout());// ���ö�������JFrameΪ��ܲ���

		Dimension dim1 = new Dimension(150, 0);// �����Ұ벿�ִ�С
		Dimension dim2 = new Dimension(140, 40);// �����ұ߰�ť����Ĵ�С
		Dimension dim3 = new Dimension(550, 0);// ������벿�ֵĴ�С

		// ʵ����ߵĽ��棬��GoBangframe�Ķ�����ӵ���ܲ��ֵ��м䲿��
		this.setPreferredSize(dim3);// �����������Ĵ�С
		this.setBackground(Color.LIGHT_GRAY);// ��������������ɫ

		jf.add(this, BorderLayout.CENTER);// ��ӵ���ܲ��ֵ��м䲿��

		// ʵ���ұߵ�JPanel��������
		JPanel jp = new JPanel();
		jp.setPreferredSize(dim1);// ����JPanel�Ĵ�С
		jp.setBackground(Color.white);
		jf.add(jp, BorderLayout.EAST);// ��ӵ���ܲ��ֵĶ��߲���
		jp.setLayout(new FlowLayout());// ����JPanelΪ��ʽ���֡�
		// ���ð�ť����
		String[] butname = { "��ʼ����Ϸ", "����", "����" };
		JButton[] button = new JButton[3];

		// ��������ť�������ȥ
		for (int i = 0; i < butname.length; i++) {
			button[i] = new JButton(butname[i]);
			button[i].setPreferredSize((dim2));
			jp.add(button[i]);
		}

		// ��ť�����
		ButtonListener butListen = new ButtonListener(this);
		// ��ÿһ����ť�����״̬�¼��ļ����������
		for (int i = 0; i < butname.length; i++) {
			button[i].addActionListener(butListen);// ��ӷ��������ļ�������
		}

		frameListener fl = new frameListener();
		fl.setGraphics(this);// ��ȡ���ʶ���
		this.addMouseListener(fl);

		jf.setVisible(true);
	}

	public void PopUp(String result) {
		JOptionPane jo = new JOptionPane();
		jo.showMessageDialog(null, result, "��ʾ", JOptionPane.PLAIN_MESSAGE);
	}

	// ��д�ػ淽��
	public void paint(Graphics g) {
		super.paint(g);

		// �ػ������
		g.setColor(Color.black);
		for (int i = 0; i < row; i++) {
			g.drawLine(x, y + size * i, x + size * (column - 1), y + size * i);
		}
		for (int j = 0; j < column; j++) {
			g.drawLine(x + size * j, y, x + size * j, y + size * (row - 1));
		}

		// �ػ������
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
