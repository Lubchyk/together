package myCalculator;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myCalculatorNew {

	public static void main(String[] args) {
		// панель ggg
		JPanel windowContent = new JPanel();
		
		//менеджер дл€ панел≥
		FlowLayout f1 = new FlowLayout();
		windowContent.setLayout(f1);
		
		// створюЇмо компоненти в пам'€т≥
		JLabel label1 = new JLabel("÷ифра 1");
		JTextField field1 = new JTextField(10);
		
		JLabel label2 = new JLabel("÷ифра 2");
		JTextField field2 = new JTextField(10);
		
		JLabel label3 = new JLabel("—ума");
		JTextField rezult = new JTextField(10);
		
		JButton battom = new JButton(" нопка");
		
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(rezult);
		windowContent.add(battom);
		
		//задаЇмо фрейм ≥ створюЇмо дл€ нењ панель
		
		JFrame frame = new JFrame(" јЋ№ ”Ћя“ќ–");
		frame.setContentPane(windowContent);
		
		// задаЇмо розм≥ри ≥ робимо його видимим
		frame.setSize(400, 200);
		frame.setVisible(true);
		JLabel label = new JLabel();
	}

}
