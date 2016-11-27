package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Info;
import DAO.InfoDAO;
import DAO.UserDAO;
import Service.ServiceImp;

public class testSimpList {
	public static void main(String args[]){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServiceImp simp = (ServiceImp) cfx.getBean("ServiceImp");
		for (Info info: simp.findAllList()){
			System.out.println(info.getIclass());
		}
	}
}
