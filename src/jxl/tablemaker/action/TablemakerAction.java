package jxl.tablemaker.action;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

import jxl.tablemaker.db.Dealinform;
import jxl.tablemaker.service.ToexcelService;

public class TablemakerAction extends tablemakerSuperAction{

	/**
	 * 
	 */
	
	ToexcelService toExel = new ToexcelService();
	
	private Dealinform dealinform;
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(ClassName.class);
	
	public String DealToExcel()
	{

		

//			Map session=(Map) ActionContext.getContext().getSession();
		//	Dealinform dealinform1 = new Dealinform();
//			Date date = new Date();
//			String dealid = UUID.randomUUID().toString();
			toExel.writeDealExcel();
			logger.info("���ױ�������");
			
			
			
//			dealinform1.setAccountid(dealinform.getAccountid());
//			dealinform1.setDeaamountl(dealinform.getDeaamountl());
//			dealinform1.setDealDesti(dealinform.getDealDesti());
//			dealinform1.setDealid(dealid);
//			dealinform1.setDealinform(dealinform.getDealinform());
//			dealinform1.setDealstate(1);
//			dealinform1.setDealtime(date);
//			dealinform1.setDealtype(1);
				return "dealmake_success";

	}
	
	public String AppointToExcel()
	{
		toExel.writeAppointExcel();
		logger.info("ԤԼ��������");
		return "dealmake_success";
	}
	
	public String OperaterToExcel()
	{
		toExel.writeOperaterExcel();
		logger.info("����Ա��������");
		return "dealmake_success";
	}
	

}
