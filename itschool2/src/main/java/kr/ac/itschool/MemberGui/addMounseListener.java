package kr.ac.itschool.MemberGui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import kr.ac.itschool.Daoservice.Daoservice;
import kr.ac.itschool.Member.Member;

public class addMounseListener implements MouseListener {
	Daoservice service = new Daoservice();
	JTable table;
	DefaultTableModel model;
	JTextField code;
	JTextField codename;
	JTextField bn1;
	JTextField bn2;
	JTextField bn3;
	JTextField represent;
	JTextField post;
	JTextField addr1;
	JTextField addr2;
	JTextField bc;
	JTextField category;
	JTextField duty;
	JTextField phone1;
	JTextField phone2;
	JTextField phone3;
	JTextField find;
	JComboBox box;
	addMounseListener(JTable table,DefaultTableModel model,JTextField code,JTextField codename,
			JTextField bn1,JTextField bn2,JTextField bn3,JTextField represent,JTextField post,
			JTextField addr1,JTextField addr2,JTextField bc,JTextField category,JTextField duty,
			JTextField phone1,JTextField phone2,JTextField phone3,JTextField find,JComboBox box){
	this.table =table;
	this.model = model;
	this.code = code;
	this.codename = codename;
	this.bn1 =bn1;
	this.bn2 = bn2;
	this.bn3 = bn3;
	this.represent = represent;
	this.post = post;
	this.addr1 = addr1;
	this.addr2 = addr2;
	this.bc = bc;
	this.category = category;
	this.duty = duty;
	this.phone1 = phone1;
	this.phone2 = phone2;
	this.phone3 = phone3;
	this.find =find;
	this.box = box;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	  System.out.println(box);
	String selectrow = model.getValueAt(table.getSelectedRow(), 0).toString();	
	Member data = service.Selectone(selectrow);
	int row = table.getSelectedRow();
	code.setText(data.getCode());
	codename.setText(data.getCodename());
	bn1.setText(data.getBN1());
	bn2.setText(data.getBN2());
	bn3.setText(data.getBN3());
	represent.setText(data.getRepresent());
	post.setText(data.getPost());
	addr1.setText(data.getAddr1());
	addr2.setText(data.getAddr2());
	bc.setText(data.getBc());
	category.setText(data.getCategory());
	duty.setText(data.getduty());
	phone1.setText(data.getphone1());
	phone2.setText(data.getPhone2());
	phone3.setText(data.getPhone3());
	
	if(e.getButton()==3){
		boolean chk = service.deleterow(code.getText());
		if(chk){
		model.removeRow(row);
		JOptionPane.showMessageDialog(code, "삭제되었다.");
		}else
			JOptionPane.showMessageDialog(code, "삭제 실패 ㅎㅎ");
	}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
