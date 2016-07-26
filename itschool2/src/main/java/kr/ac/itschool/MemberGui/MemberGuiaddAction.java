package kr.ac.itschool.MemberGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import kr.ac.itschool.Dao.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import kr.ac.itschool.Daoservice.*;
import kr.ac.itschool.Daoservice.Daoservice;
import kr.ac.itschool.Member.Member;

public class MemberGuiaddAction implements ActionListener {
	Member data = new Member();
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
	boolean chk = false;
	MemberGuiaddAction(JTable table,DefaultTableModel model,JTextField code,JTextField codename,
			JTextField bn1,JTextField bn2,JTextField bn3,JTextField represent,JTextField post,
			JTextField addr1,JTextField addr2,JTextField bc,JTextField category,JTextField duty,JTextField phone1,
			JTextField phone2,JTextField phone3,JTextField find,JComboBox box){
		this.table = table;
		this.model = model;
		this.code = code;
		this.codename = codename;
		this.bn1 =bn1;
		this.bn2 =bn2;
		this.bn3 =bn3;
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
		this.chk = chk;
		this.find = find;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	Daoservice service = new Daoservice();
	String getValue=e.getActionCommand();
	data.setCode(code.getText());
	data.setCodename(codename.getText());
	data.setBN1(bn1.getText());
	data.setBN2(bn2.getText());
	data.setBN3(bn3.getText());
	data.setRepresent(represent.getText());
	data.setPost(post.getText());
	data.setAddr1(addr1.getText());
	data.setAddr2(addr1.getText());
	data.setBc(bc.getText());
	data.setCategory(category.getText());
	data.setduty(duty.getText());
	data.setphone1(phone1.getText());
	data.setPhone2(phone2.getText());
	data.setPhone3(phone3.getText());

	
	String messege= "";
		if(getValue.equals("중복검사")){
			boolean overlapchk = service.overlap(code.getText());
			if(!overlapchk){
				if(!code.getText().equals("")){
				JOptionPane.showMessageDialog(code,"사용가능합니다.");
				chk = true;
				}
			}else {
				JOptionPane.showMessageDialog(code, "중복입니다.");
					return ;
				}
			}
		if(getValue.equals("수정")){
			String result=service.updateMeth(data);
			table.getSelectionModel();
			String cn = (String) table.getValueAt(table.getSelectedRow(), 0);
			if(!cn.equals(data.getCode())){
				JOptionPane.showMessageDialog(code, "수정되지 않았습니다.");
			}else{
			int row = table.getSelectedRow();
			if(result.equals("")){
				data.setCode(data.getCode());
				model.setValueAt(data.getCodename(), row, 1);
				String temp1 = data.getBN1()+"-"+data.getBN2()+"-"+data.getBN3();
				model.setValueAt(temp1, row,2);
				String temp2 = data.getphone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
				model.setValueAt(temp2, row, 3);
				JOptionPane.showMessageDialog(code, "수정되었습니다");	
			}
		}
		}		
		if(getValue.equals("입력")){	
			if(code.getText().equals("")){
				messege+= "code를 입력해 용빈아\n";}
				if(codename.getText().equals("")){
					messege+="상호를 입력해 용빈아\n";}
					if(!messege.equals("")){
						JOptionPane.showMessageDialog(code, messege);
					return ;}
				if(!chk){
					JOptionPane.showMessageDialog(code, "중복검사해라");
					return ;
				}
		Boolean insertchk = service.inserMeth(data);
		Object row[] = {"","","",""};
		row[0]= data.getCode();
		row[1]= data.getCodename();
		String temp1 =data.getBN1()+"-"+data.getBN2()+"-"+data.getBN3();
		row[2]=temp1;
		String temp2 =data.getphone1()+"-"+data.getPhone2()+"-"+data.getPhone3();
		row[3]=temp2;
		model.addRow(row);
	}
	if(getValue.equals("삭제")){

	}
		
	if(getValue.equals("캔슬")){
		screeneditor();
		model.setRowCount(0);
	}
	System.out.println(find.getText());
	
	if(getValue.equals("검색")){
		model.setRowCount(0);
		ArrayList<Member> list = new ArrayList<Member>();
		if(find.getText().equals(""))
		list =service.search();
		else
			list = service.searchfind(find.getText());
		
		for(Member list1:list){
			Object row[] = {"","","",""};
			row[0] = list1.getCode();
			row[1] = list1.getCodename();
			String temp1 = list1.getBN1()+"-"+list1.getBN2()+"-"+list1.getBN3();
			row[2] = temp1;
			String temp2 = list1.getphone1()+"-"+list1.getPhone2()+"-"+list1.getPhone3();
			row[3] = temp2;
			model.addRow(row);
		}
	}
}
	 void screeneditor(){
		code.setText("");
		codename.setText("");
		bn1.setText("");
		bn2.setText("");
		bn3.setText("");
		represent.setText("");
		post.setText("");
		addr1.setText("");
		addr2.setText("");
		bc.setText("");
		category.setText("");
		duty.setText("");
		phone1.setText("");
		phone2.setText("");
		phone3.setText("");
	}
}
