package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Info;
import DAO.InfoDAO;
import Service.ServiceImp;



public class testDelete {
	public static void main(String args[]) {
		ApplicationContext cfx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ServiceImp simp = (ServiceImp) cfx.getBean("ServiceImp");
		InfoDAO dao1 = (InfoDAO) cfx.getBean("InfoDAO");
		Info info = dao1.findById("2id");
//		dao1.delete(info);
//		Info info = new Info();
//		info.setId("2id");
//		info.setName("ssname");
//		info.setIclass("ssclass");
//		info.setSex("sex");
//		info.setIadd("add");
//		dao1.save(info);
		simp.updateInfo(info.getId(), info.getName(), "tt", info.getSex(), info.getIadd());
	}
}
