package ManagerServiceimpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.util.Assert;

import ManagerService.ManagerDAO;
import ManagerService.impl.ManagerDAOimpl;

public class ManagerServiceimpltest {

	@Test
	public  ManagerOperationLogin()
	{
		ManagerOperater m=new ManagerOperater(1,"123456","уехЩ");
		ManagerDAO udao = new ManagerDAOimpl();
		Assert.assertEquals(true,udao.ManagerOperaterLogin(m));
		
	}

}
