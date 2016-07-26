package kr.ac.itschool.Dao;
import java.util.ArrayList;

import kr.ac.itschool.Member.*;


public interface MemberDao {
	boolean inserMeth(Member member);
	ArrayList<Member> search();
	ArrayList<Member> searchfind(String id);
	boolean overlap(String code);
	public String updateMeth(Member member);
	public boolean deleterow(String code); // X
	public Member Selectone(String code);  // X
	
}
