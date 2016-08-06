package ManagerAction;

import ManagerService.ManagerDAO;
import ManagerService.impl.ManagerDAOimpl;

import com.manager.ManagerOperater;
import com.manager.ManagerOperaterDAO;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Repository;

import javassist.bytecode.stackmap.TypeData.ClassName;

import javax.annotation.Resource;
import org.apache.log4j.Logger;



public class ManagerAction extends SuperAction implements ModelDriven<ManagerOperater> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String LoginUserName;
	private static String Password;
	
	Logger logger = Logger.getLogger(ClassName.class);
	
	
	 ManagerOperater managerOperater = new ManagerOperater();
//	ManagerDAO udao = new ManagerDAOimpl();
	
	public String login()
	{	
		System.out.println(session.getAttribute("managerId"));
		ManagerDAO udao = new ManagerDAOimpl();
		if(udao.ManagerOperaterLogin(managerOperater).equals("管理员"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"管理员");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("管理员登录"+managerOperater.getManagerName());
			return "ManagerLogin_success";
		}
		if(udao.ManagerOperaterLogin(managerOperater).equals("行长"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"行长");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("行长登录"+managerOperater.getManagerName());
			return "hangzhangLogin_success";
		}
		if(udao.ManagerOperaterLogin(managerOperater).equals("经理"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"大堂经理");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("大堂经理登录"+managerOperater.getManagerName());
			return "jingliLogin_success";
		}
		if(udao.ManagerOperaterLogin(managerOperater).equals("操作员"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"大堂经理");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("大堂经理登录"+managerOperater.getManagerName());
			return "OperaterLogin_success";
		}
		else
		{
			logger.error("登录失败");
			return "ManagerLogin_failure";
		}
	}
	
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			logger.info("退出成功");
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//super.validate();
		
		if("".equals(managerOperater.getManagerName().trim()))
		{
			logger.error("用户名不能空");
			this.addFieldError("managernameError","用户名不能为空");
		}
		if(managerOperater.getManagerPassW().length()<6)
		{
			logger.error("密码少于6位");
			this.addFieldError("PasswordERROR","密码不能少于6位");
		}
	}

    @SkipValidation
	public ManagerOperater getModel(){
		
		return this.managerOperater;
		
	}
    
    @SkipValidation
    public String ChangePassWord()
    {
    
//    	managerOperater.setManagerId(Integer.parseInt(session.getAttribute("managerId").toString()));
    	String oldpassword=request.getParameter("managerPassW");
    	String newpassword = request.getParameter("managerQNPassW");
    	String newpassword1=request.getParameter("managerNPassW");
    
    	ManagerDAOimpl udao = new ManagerDAOimpl();
    	if(!oldpassword.equals(Password))
    	{
    		logger.error("更改密码失败changePW_failure1");
    		return "changePW_failure1";
    		
    	}
    	if(!newpassword.equals(newpassword1))
    	{
    		logger.error("更改密码失败changePW_failure2");
    		return "changePW_failure2";
    	}
    	if(udao.ChangePassWord(newpassword,LoginUserName))
    	{
    		logger.error("更改密码成功");
    		return "changePW_success";
    	}
    	else{
    		return "changePW_failure";
    	}
    	
    }

}
