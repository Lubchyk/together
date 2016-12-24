package main;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
public class UI {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Organizer_for_the_purposes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension labelSize = new Dimension(80, 30);
		Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
		JPanel windowContent= new JPanel();
		
		FlowLayout f1 = new FlowLayout();
		GridLayout f2 = new GridLayout();
		BoxLayout f3 = new BoxLayout(windowContent, 1);
		BorderLayout f4 = new BorderLayout();
		CardLayout f5 = new CardLayout();
		GridBagLayout f6 = new GridBagLayout();
			
		windowContent.setLayout(f3);
		//windowContent.setLayout(new BorderLayout());
		//windowContent.setLayout(null);
		
		//JButton myButton = new JButton();
		//JFrame myFrame = new JFrame();
		// Создаём компоненты в памяти
		JLabel label0 = new JLabel("productivity");
		label0.setPreferredSize(labelSize);
		label0.setVerticalAlignment(JLabel.TOP);
		label0.setHorizontalAlignment(JLabel.CENTER);
		JLabel label1 = new JLabel("health");
		label1.setBounds(100,200,40,20);
		JTextField field1 = new JTextField(3);
		JLabel label2 = new JLabel("energy");
		JTextField field2 = new JTextField(0);
		JLabel label3 = new JLabel("satiety");
		JTextField field3 = new JTextField(3);
		JLabel label4 = new JLabel("motivation");
		JTextField field4 = new JTextField(3);
		JLabel label5 = new JLabel("perseverance");
		JTextField field5 = new JTextField(3);
		JLabel label6 = new JLabel("emotion");
		JTextField field6 = new JTextField(3);
		
				
		// Добавляем компоненты на панель
		windowContent.add(label0);
		windowContent.add(label1);
		windowContent.add(field1);
		windowContent.add(label2);
		windowContent.add(field2);
		windowContent.add(label3);
		windowContent.add(field3);
		windowContent.add(label4);
		windowContent.add(field4);
		windowContent.add(label5);
		windowContent.add(field5);
		windowContent.add(label6);
		windowContent.add(field6);
		// Создаём фрейм и задаём для него панель
		//JFrame frame = new JFrame("Organizer_for_the_purposes");
		frame.setContentPane(windowContent);
		
		// задаём и размер и делаем фрейм видимым
		frame.setSize(400,300);
		frame.setVisible(true);
		
	}

}
