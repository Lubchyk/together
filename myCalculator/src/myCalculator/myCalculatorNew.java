package myCalculator;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myCalculatorNew {

	public static void main(String[] args) {
		// ������ ggg
		JPanel windowContent = new JPanel();
		
		//�������� ��� �����
		FlowLayout f1 = new FlowLayout();
		windowContent.setLayout(f1);
		
		// ��������� ���������� � ���'��
		JLabel label1 = new JLabel("����� 1");
		JTextField field1 = new JTextField(10);
		
		JLabel label2 = new JLabel("����� 2");
		JTextField field2 = new JTextField(10);
		
		JLabel label3 = new JLabel("����");
		JTextField rezult = new JTextField(10);
		
		JButton battom = new JButton("������");
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(rezult);
		windowContent.add(battom);
		
		//������ ����� � ��������� ��� �� ������
		
		JFrame frame = new JFrame("�����������");
		frame.setContentPane(windowContent);
		
		// ������ ������ � ������ ���� �������
		frame.setSize(400, 200);
		frame.setVisible(true);
		JLabel label = new JLabel();
	}

}
