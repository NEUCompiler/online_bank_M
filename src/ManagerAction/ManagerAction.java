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
		if(udao.ManagerOperaterLogin(managerOperater).equals("����Ա"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"����Ա");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("����Ա��¼"+managerOperater.getManagerName());
			return "ManagerLogin_success";
		}
		if(udao.ManagerOperaterLogin(managerOperater).equals("�г�"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"�г�");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("�г���¼"+managerOperater.getManagerName());
			return "hangzhangLogin_success";
		}
		if(udao.ManagerOperaterLogin(managerOperater).equals("����"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"���þ���");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("���þ����¼"+managerOperater.getManagerName());
			return "jingliLogin_success";
		}
		if(udao.ManagerOperaterLogin(managerOperater).equals("����Ա"))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName()+"���þ���");
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			logger.info("���þ����¼"+managerOperater.getManagerName());
			return "OperaterLogin_success";
		}
		else
		{
			logger.error("��¼ʧ��");
			return "ManagerLogin_failure";
		}
	}
	
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			logger.info("�˳��ɹ�");
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
			logger.error("�û������ܿ�");
			this.addFieldError("managernameError","�û�������Ϊ��");
		}
		if(managerOperater.getManagerPassW().length()<6)
		{
			logger.error("��������6λ");
			this.addFieldError("PasswordERROR","���벻������6λ");
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
    		logger.error("��������ʧ��changePW_failure1");
    		return "changePW_failure1";
    		
    	}
    	if(!newpassword.equals(newpassword1))
    	{
    		logger.error("��������ʧ��changePW_failure2");
    		return "changePW_failure2";
    	}
    	if(udao.ChangePassWord(newpassword,LoginUserName))
    	{
    		logger.error("��������ɹ�");
    		return "changePW_success";
    	}
    	else{
    		return "changePW_failure";
    	}
    	
    }

}
