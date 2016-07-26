package kr.ac.itschool.MemberGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MemberGuiMain {
	static JButton button;
	public static void main(String[] args) {
		JFrame frame = new JFrame("거래처관리");
		frame.setLocation(200,150);
		frame.setPreferredSize(new Dimension(1000,800));
		Container contentpane = frame.getContentPane();
		Font font = new Font("바탕체",Font.TYPE1_FONT,20);
		 
		String arr1[] = {"code","상호","사업자No","전화번호"};
		String arr2[] = {"입력","수정","삭제","검색","캔슬"};
		DefaultTableModel model = new DefaultTableModel(arr1,0);
		JTable table = new JTable(model);
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(100,30));
		header.setBackground(Color.lightGray);
		table.setRowHeight(30);
		
		contentpane.add(new JScrollPane(table), BorderLayout.EAST);
		contentpane.add(new JScrollPane(table),BorderLayout.CENTER);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();

		panel1.setLayout(new GridLayout(11, 2));
		JPanel panel5 = new JPanel();
 		JLabel codelb = new JLabel("code");
		JTextField code = new JTextField(10);
		codelb.setHorizontalAlignment(JLabel.CENTER);
		button = new JButton("중복검사");
		panel5.add(code);
		panel5.add(button);

		JLabel codenamelb = new JLabel("상호");
		JTextField codename = new JTextField(8);
		codenamelb.setHorizontalAlignment(JLabel.CENTER);
		JPanel panel3 = new JPanel();
		JLabel bnlb = new JLabel("사업자No");
		bnlb.setHorizontalAlignment(JLabel.CENTER);
		JTextField bn1 = new JTextField(3);
		JLabel bnlb1 = new JLabel("-");
		JTextField bn2 = new JTextField(3);
		JLabel bnlb2 = new JLabel("-");
		JTextField bn3 = new JTextField(3);
		panel3.add(bn1);
		panel3.add(bnlb1);
		panel3.add(bn2);
		panel3.add(bnlb2);
		panel3.add(bn3);
		
		JLabel representlb = new JLabel("대표자");
		JTextField represent = new JTextField(8);
		representlb.setHorizontalAlignment(JLabel.CENTER);
		JLabel postlb = new JLabel("우편번호");
		JTextField post = new JTextField(8);
		postlb.setHorizontalAlignment(JLabel.CENTER);
		JLabel addr1lb = new JLabel("주소");
		JTextField addr1 = new JTextField(8);
		addr1lb.setHorizontalAlignment(JLabel.CENTER);
		JLabel addr2lb = new JLabel("상세주소");
		JTextField addr2 = new JTextField(8);
		addr2lb.setHorizontalAlignment(JLabel.CENTER);
		JLabel bclb = new JLabel("업태");
		JTextField bc = new JTextField(8);
		bclb.setHorizontalAlignment(JLabel.CENTER);
		JLabel categorylb = new JLabel("종목");
		JTextField category = new JTextField(8);
		categorylb.setHorizontalAlignment(JLabel.CENTER);
		JLabel dutylb = new JLabel("담당자");
		JTextField duty = new JTextField(8);
		dutylb.setHorizontalAlignment(JLabel.CENTER);
		JLabel phonelb = new JLabel("전화번호");
		
		String phonenum[] = {"010","011","017","019"};
		JComboBox box = new JComboBox(phonenum);
		 Container ct = frame.getContentPane();
		 ct.setLayout(new FlowLayout());
		 ct.add(box);
		 
		JPanel panel4 = new JPanel();
		JTextField phone1 = new JTextField(3);
		JLabel phone1lb = new JLabel("-");
		JTextField phone2 = new JTextField(3);
		JLabel phone2lb = new JLabel("-");
		JTextField phone3 = new JTextField(3);
		phonelb.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField find = new JTextField(5);
		panel4.add(phone1);
		panel4.add(phone1lb);
		panel4.add(phone2);
		panel4.add(phone2lb);
		panel4.add(phone3);
		
		panel1.add(codelb);
		panel1.add(panel5);
		panel1.add(codenamelb);
		panel1.add(codename);
		panel1.add(bnlb);
		panel1.add(panel3);
		panel1.add(representlb);
		panel1.add(represent);
		panel1.add(postlb);
		panel1.add(post);
		panel1.add(addr1lb);
		panel1.add(addr1);
		panel1.add(addr2lb);
		panel1.add(addr2);
		panel1.add(bclb);
		panel1.add(bc);
		panel1.add(categorylb);
		panel1.add(category);
		panel1.add(dutylb);
		panel1.add(duty);
		panel1.add(phonelb);
		panel1.add(panel4);
		ActionListener listener = new MemberGuiaddAction(table,model,code,codename,bn1,bn2,bn3,represent,post,addr1,addr2,bc,category,duty,phone1,phone2,phone3,find,box);
		button.addActionListener(listener);
		for(int i=0;i<arr2.length;i++){
			button = new JButton(arr2[i]);
			button.addActionListener(listener);
			if(i==2){
				find = new JTextField(8);
				panel2.add(find);
			}
			panel2.add(button);
		}
		MouseListener mouse = new addMounseListener(table,model,code,codename,bn1,bn2,bn3,represent,post,addr1,addr2,bc,category,duty,phone1,phone2,phone3,find,box);
		table.addMouseListener(mouse);
		contentpane.add(panel1,BorderLayout.WEST);
		contentpane.add(panel2,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
