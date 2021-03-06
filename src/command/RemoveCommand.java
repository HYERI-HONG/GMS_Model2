package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command {
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("-----------delete command--------------");
			MemberBean member = new MemberBean();
			member.setUserId(((MemberBean) request.getSession().getAttribute("user")).getUserId());
			member.setPassword(request.getParameter("password"));
			MemberServiceImpl.getInstance().remove(member);
			request.getSession().invalidate();
			break;
		default:
			break;
		}
		super.execute();
	}
}
