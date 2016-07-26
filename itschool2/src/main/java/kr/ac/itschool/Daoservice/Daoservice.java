package kr.ac.itschool.Daoservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import kr.ac.itschool.DBpool.DBConnectionManager;
import kr.ac.itschool.DBpool.DBpoolConnectTestMain;
import kr.ac.itschool.Dao.MemberDao;

import kr.ac.itschool.Member.Member;

public class Daoservice implements MemberDao{

	DBConnectionManager db = new DBConnectionManager();
	Connection cn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public boolean inserMeth(Member member) {
		boolean intchk = false;
		StringBuilder sb =new StringBuilder();
		sb.append("insert into cm(code,codename,bn1,bn2,bn3,represent,post,addr1,addr2,bc,category,duty,phone1,phone2,phone3)");
		sb.append("values('"+member.getCode()+"','"+member.getCodename()+"','"+member.getBN1()+"','"+member.getBN2()+"','"+member.getBN3()+"',");
		sb.append("'"+member.getRepresent()+"','"+member.getPost()+"','"+member.getAddr1()+"','"+member.getAddr2()+"','"+member.getBc()+"',");
		sb.append("'"+member.getCategory()+"','"+member.getduty()+"','"+member.getphone1()+"','"+member.getPhone2()+"','"+member.getPhone3()+"')");	
		String sql=sb.toString();
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			intchk = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("입력에러:"+e.getMessage());
		}
		return intchk;
	}

	@Override
	public ArrayList<Member> search() {
		ArrayList<Member> list = new ArrayList<Member>();
		Member member =null;
		String sql = "select * from cm";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setCodename(rs.getString("codename"));
				member.setBN1(rs.getString("bn1"));
				member.setBN2(rs.getString("bn2"));
				member.setBN3(rs.getString("bn3"));
				member.setRepresent(rs.getString("represent"));
				member.setPost(rs.getString("post"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setBc(rs.getString("bc"));
				member.setCategory(rs.getString("category"));
				member.setduty(rs.getString("duty"));
				member.setphone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				list.add(member);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("찾기 에러:"+e.getMessage());
		}
		return list;
	}

	@Override
	public ArrayList<Member> searchfind(String find) {
		ArrayList<Member> list = new ArrayList<Member>();
		Member member = null;
		String sql = "Select code from cm where code= '"+find+"'";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				member = new Member();
				member.setCode(rs.getString("code"));
				member.setCodename(rs.getString("codename"));
				member.setBN1(rs.getString("bn1"));
				member.setBN2(rs.getString("bn2"));
				member.setBN3(rs.getString("bn3"));
				member.setRepresent(rs.getString("represent"));
				member.setPost(rs.getString("post"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setBc(rs.getString("bc"));
				member.setCategory(rs.getString("category"));
				member.setduty(rs.getString("duty"));
				member.setphone1(rs.getString("phone1"));
				member.setPhone2(rs.getString("phone2"));
				member.setPhone3(rs.getString("phone3"));
				list.add(member);
			}
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("찾기 에러:"+e.getMessage());
		}
		return list;
	}
	@Override
	public boolean overlap(String code) {
		boolean overlap = false;
		String sql = "select * from cm where code = '"+code+"'";
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				overlap = true;
			cn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("중복문자 에러:"+e.getMessage());
		}
		return overlap;
	}

	@Override
	public String updateMeth(Member member) {
		String result="";
		StringBuilder sb = new StringBuilder();
		sb.append("update cm set codename='"+member.getCodename()+"',bn1='"+member.getBN1()+"',bn2='"+member.getBN2()+"',bn3='"+member.getBN3()+"'");
		sb.append(",represent = '"+member.getRepresent()+"',post ='"+member.getPost()+"',addr1='"+member.getAddr1()+"',addr2='"+member.getAddr2()+"',bc='"+member.getBc()+"',");
		sb.append("category ='"+member.getCategory()+"',duty='"+member.getduty()+"',phone1='"+member.getphone1()+"',phone2='"+member.getPhone2()+"',phone3='"+member.getPhone3()+"'");
		sb.append(" where code ='"+member.getCode()+"'");
		String sql = sb.toString();
		System.out.println(sql);
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			result="";
			cn.close();
			ps.close();
		} catch (Exception e) {
		result = e.getMessage();
		}
		
		return result;
	}
	@Override
	public boolean deleterow(String code) {
		boolean success = false;
		String sql = "delete from cm  where code='"+code+"'";  
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			ps.execute();
			success = true;
			cn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("삭제 에러 :"+e.getMessage());
		}
		return success;
	}

	@Override
	public Member Selectone(String code) {
		Member member = new Member();
		String sql = "select * from cm where code='"+code+"'";
		System.out.println(sql);
		try {
			cn = db.getConnection();
			ps = cn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
			member.setCode(rs.getString("code"));
			member.setCodename(rs.getString("codename"));
			member.setBN1(rs.getString("bn1"));
			member.setBN2(rs.getString("bn2"));
			member.setBN3(rs.getString("bn3"));
			member.setRepresent(rs.getString("represent"));
			member.setPost(rs.getString("post"));
			member.setAddr1(rs.getString("addr1"));
			member.setAddr2(rs.getString("addr2"));
			member.setBc(rs.getString("bc"));
			member.setCategory(rs.getString("category"));
			member.setDuty(rs.getString("duty"));
			member.setphone1(rs.getString("phone1"));
			member.setPhone2(rs.getString("phone2"));
			member.setPhone3(rs.getString("phone3"));
			}
			cn.close();
			ps.close();
			rs.close();
			} catch (Exception e) {
				System.out.println("selectone error:"+e.getMessage());
			}
		return member;
	}
}
