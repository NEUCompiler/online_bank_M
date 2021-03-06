package SystemParrateAction;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import systemPar.service.SystemParService;

public class sysParrateAction extends SyParSuperAction{
	
	SystemParService sps = new SystemParService();
	private static String loanid;
	
	private static Integer bigdealid;
	private static Integer roleid;
	private static String bigdealamount;
	private static String bigdealaheadtime;
	private static Integer depositid;
	private static Integer orgnizationid;
	
	public String loanshow()
	{
		List list= sps.loanshow();
		session.setAttribute("loanlist", list);
		return "loanshow_success";
	}
	
	
	public String depositshow()
	{
		List list= sps.depositshow();
		session.setAttribute("depositlist", list);
		return "depositshow_success";
	}
	
	public String bigdealshow()
	{
		List list= sps.bigdealshow();
		session.setAttribute("bigdeallist", list);
		return "bigdeallist_success";
	}
	
	public String roleshow()
	{
		List list1= sps.roleshow();
		session.setAttribute("rolelist", list1);
		List list= sps.authshow();
		session.setAttribute("authlist", list);
		return "rolelist_success";
	}
	
	public String orgnizationshow()
	{
		List list= sps.orgnizationshow();
		session.setAttribute("orgnizationlist", list);
		return "orgnizationlist_success";
	}
	
//	public String authshow()
//	{
//		List list= sps.authshow();
//		session.setAttribute("authlist", list);
//		return "rolelist_success";
//	}
	
	public String loanupdateRQ()
	{
	    loanid = request.getParameter("stu.loankey");
		
			return "loanupdaterequest_success";

	}
	public String loanupdateRP()
	{
//		String loantime1=request.getParameter("stu.time");
//		Integer loantime=Integer.parseInt(loantime1);
		String loanrate1=request.getParameter("rate");
		float loanrate=Float.parseFloat(loanrate1);
//		String loantype=request.getParameter("stu.type");
		if(loanrate1==null)
			return "loanshow_success";
		if(sps.update(loanid,loanrate))
		{
			List list= sps.loanshow();
			session.setAttribute("loanlist", list);
			return "loanupdateresponse_success";
		}
		return  "";
	}
	
	public String bigdealupdateRQ()
	{
		String bigdealid1 = request.getParameter("stu.bigdealId");
		 bigdealid= new Integer(bigdealid1);
		bigdealamount = request.getParameter("stu.amount");
		bigdealaheadtime=request.getParameter("stu.aheadtime");
		
		return "bigdealdaterequest_success";
		  
	}
	
	public String bigdealupdateRP()
	{
		String amount1 = request.getParameter("amount");
		String time1   = request.getParameter("aheadtime");
        Integer amount = new Integer(amount1);
        Integer time   = new Integer(time1);
        if(amount1==null&&time1==null)
        	 return "bigdeallist_success";
		if(sps.bigdealupdate(bigdealid,amount,time))
		{
			List list =sps.bigdealshow();
			session.setAttribute("bigdeallist", list);
			return "bigdeallist_success";
		}
		return "";
	}
	
	public String depositupdateRQ()
	{
		String depositid1 = request.getParameter("stu.depositkey");
		depositid = new Integer(depositid1);
		
		return "depositupdaterequest_success";
	}
	
	public String depositupdateRP()
	{
		String  rate1=request.getParameter("rate");
		float rate=Float.parseFloat(rate1);
		String  interest1=request.getParameter("interest");
		float interest=Float.parseFloat(interest1);
		String time1=request.getParameter("time");
		Integer time = new Integer(time1);	
		if(rate1==null&&interest1==null&&time1==null)
			return "depositshow_success";
		if(sps.depositupdate(depositid,rate,interest,time))
		{
			List list =sps.depositshow();
			session.setAttribute("depositlist", list);
			return "depositshow_success";
		}
		return null;
	}
	
	public String roleupdateRQ()
	{
		String roleid1= request.getParameter("stu.roleId");
		roleid = new Integer(roleid1);
		return "roleupdaterequest_success";
	}
	
	public String roleupdateRP()
	{
		String  auid=request.getParameter("auId");
		if(auid==null)
			return "rolelist_success";
		if(sps.roleupdate(roleid,auid))
		{
			List list1= sps.roleshow();
			session.setAttribute("rolelist", list1);
			List list= sps.authshow();
			session.setAttribute("authlist", list);
			return "rolelist_success";
		}
		return null;
	}
	
	public String orgnizationupdateRQ()
	{
		String orgnizationid1=request.getParameter("stu.orgnizationid");
		orgnizationid = new Integer(orgnizationid1);
		return "orgnizationrequest_success";
		
	}
	
	public String orgnizationupdateRP()
	{
		String newtotal1 = request.getParameter("orgnizationtotalp");
		Integer newtotal = new Integer(newtotal1);
		String newcharge = request.getParameter("orgnizationcharge");
		if(newtotal1==null&&newcharge==null)
			return "orgnizationlist_success";
		if(sps.orgnizationupdate(orgnizationid,newtotal,newcharge))
		{
			List list= sps.orgnizationshow();
			session.setAttribute("orgnizationlist", list);
			return "orgnizationlist_success";
		}
		return null;
	}

}
