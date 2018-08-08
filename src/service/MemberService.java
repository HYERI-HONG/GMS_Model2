package service;
import domain.*;
import java.util.List;
import java.util.Map;

public interface MemberService {
	public void create(MemberBean member);
	public List<MemberBean> search(Map<?,?> param);
	public MemberBean retrieve(String id);
	public int count();
	public void modify(Map<?,?> param);
	public void remove(MemberBean member);
	public boolean login(MemberBean member);
}
