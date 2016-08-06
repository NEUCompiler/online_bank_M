package ManagerService;

import com.manager.ManagerOperater;

public interface ManagerDAO {
	public String ManagerOperaterLogin(ManagerOperater m);
	public boolean ChangePassWord(String NewPassWord,int Mid);

}
