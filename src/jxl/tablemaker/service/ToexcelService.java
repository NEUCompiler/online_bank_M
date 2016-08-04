package jxl.tablemaker.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Operater.db.Operater;
import Operater.db.OperaterDAO;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.tablemaker.db.Appointment;
import jxl.tablemaker.db.AppointmentDAO;
import jxl.tablemaker.db.AppointmentId;
import jxl.tablemaker.db.Dealinform;
import jxl.tablemaker.db.DealinformDAO;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ToexcelService {

	DealinformDAO DealDao = new DealinformDAO();
	AppointmentDAO Appdao = new AppointmentDAO();
	OperaterDAO Operdao   = new OperaterDAO();


	public void writeDealExcel() {
		String[] title = { "���", "Դ�˻�", "����ʱ��", "��������", "��֧", "Ŀ���˻�", "����״̬",
				"���" };
		try {
			// ��ÿ�ʼʱ��
			long start = System.currentTimeMillis();
			// �����excel��·��
			String filePath = "d:\\DealinformationToexce.xls";
			// ����Excel������
			WritableWorkbook wwb;
			// �½���һ��jxl�ļ�,����d��������testJXL.xls
			OutputStream os = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(os);
			// ��ӵ�һ�����������õ�һ��Sheet������
			WritableSheet sheet = wwb.createSheet("��Ʒ�嵥", 0);
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) ����Ԫ��ĵ�x+1�У���y+1��, ����z
				// ��Label������Ӷ�����ָ����Ԫ���λ�ú�����
				label = new Label(i, 0, title[i]);
				// label = new Label(i, 0, title[i], getHeader());
				// ������õĵ�Ԫ����ӵ���������
				sheet.addCell(label);
			}
			// �������������
			/*
			 * �������ֵ���Ԫ����Ҫʹ��jxl.write.Number ����ʹ��������·�����������ִ���
			 */

			List list = (List) DealDao.findAll();
			
			int i=1;

			for(Iterator I = list.iterator();I.hasNext();){
				
				

				Dealinform m = (Dealinform) I.next();

				label = new Label(0, i, m.getDealid());

				sheet.addCell(label);
				label = new Label(1, i, m.getAccountid());

				sheet.addCell(label);
				label = new Label(2, i, m.getDealtime().toString());

				sheet.addCell(label);
				label = new Label(3, i, m.getDealinform());

				sheet.addCell(label);
				label = new Label(4, i, m.getDealtype().toString());

				sheet.addCell(label);
				
				label = new Label(5, i, m.getDealDesti());

				sheet.addCell(label);

				label = new Label(6, i, m.getDealstate().toString());

				sheet.addCell(label);
				label = new Label(7, i, m.getDeaamountl().toString());

				sheet.addCell(label);
				
				i++;
			}

			wwb.write();
			// �ر��ļ�
			wwb.close();
			long end = System.currentTimeMillis();
			System.out.println("----��ɸò������õ�ʱ����:" + (end - start) / 1000);
		} catch (Exception e) {
			System.out.println("---�����쳣---");
			e.printStackTrace();
		}
	}

	private static CellFormat getHeader() {

		return null;
	}

	public void writeAppointExcel() {
		String[] title = { "���", "�ͻ���", "���׽��", "����", "�����"};
try {
	// ��ÿ�ʼʱ��
	long start = System.currentTimeMillis();
	// �����excel��·��
	String filePath = "d:\\AppointmentToexce.xls";
	// ����Excel������
	WritableWorkbook wwb;
	// �½���һ��jxl�ļ�,����d��������testJXL.xls
	OutputStream os = new FileOutputStream(filePath);
	wwb = Workbook.createWorkbook(os);
	// ��ӵ�һ�����������õ�һ��Sheet������
	WritableSheet sheet = wwb.createSheet("���ԤԼ", 0);
	Label label;
	for (int i = 0; i < title.length; i++) {
		// Label(x,y,z) ����Ԫ��ĵ�x+1�У���y+1��, ����z
		// ��Label������Ӷ�����ָ����Ԫ���λ�ú�����
		label = new Label(i, 0, title[i]);
		// label = new Label(i, 0, title[i], getHeader());
		// ������õĵ�Ԫ����ӵ���������
		sheet.addCell(label);
	}
	List list = (List) Appdao.findAll();
	
	int i=1;

	for(Iterator I = list.iterator();I.hasNext();){
		
		

		Appointment m = (Appointment) I.next();
		

		label = new Label(0, i, m.getId().getAppointid());
		System.out .println(m.getAppointid());

		sheet.addCell(label);
		label = new Label(1, i, m.getId().getClientid());

		sheet.addCell(label);
		label = new Label(2, i, m.getId().getAmount());

		sheet.addCell(label);
		label = new Label(3, i, m.getId().getDate().toString());

		sheet.addCell(label);
		label = new Label(4, i, m.getId().getWebsiteid());

		sheet.addCell(label);
		i++;
	}
	wwb.write();
	wwb.close();
		
	}catch (Exception e) {
		System.out.println("---�����쳣---");
		e.printStackTrace();}

}

	public void writeOperaterExcel() {
		String[] title = { "����Ա��", "����", "����", "����", "�Ա�","����"};
		try {
			// ��ÿ�ʼʱ��
			long start = System.currentTimeMillis();
			// �����excel��·��
			String filePath = "d:\\OperaterToexce.xls";
			// ����Excel������
			WritableWorkbook wwb;
			// �½���һ��jxl�ļ�,����d��������testJXL.xls
			OutputStream os = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(os);
			// ��ӵ�һ�����������õ�һ��Sheet������
			WritableSheet sheet = wwb.createSheet("����Ա��", 0);
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) ����Ԫ��ĵ�x+1�У���y+1��, ����z
				// ��Label������Ӷ�����ָ����Ԫ���λ�ú�����
				label = new Label(i, 0, title[i]);
				// label = new Label(i, 0, title[i], getHeader());
				// ������õĵ�Ԫ����ӵ���������
				sheet.addCell(label);
			}
			List list = (List) Operdao.findAll();
			
			int i=1;

			for(Iterator I = list.iterator();I.hasNext();){
				
				

				Operater m = (Operater) I.next();
				

				label = new Label(0, i, m.getOperaterId().toString());

				sheet.addCell(label);
				label = new Label(1, i, m.getOperaterName());

				sheet.addCell(label);
				label = new Label(2, i, m.getOperaterPassW());

				sheet.addCell(label);
				label = new Label(3, i, m.getOperaterType());

				sheet.addCell(label);
				label = new Label(4, i, m.getOperaterSex());

				sheet.addCell(label);
				label = new Label(5, i, m.getOperaterBirthday().toString());

				sheet.addCell(label);
				i++;
			}
			wwb.write();
			wwb.close();
				
			}catch (Exception e) {
				System.out.println("---�����쳣---");
				e.printStackTrace();}

}
}

