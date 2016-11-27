package Test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.Info;
import Service.ServiceImp;

public class testPage {
	public static void main(String args[]){
		ApplicationContext cfx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ServiceImp simp = (ServiceImp) cfx.getBean("ServiceImp");
		
		
		for (int i = 1; i < 6; i++){
			List<Info> list = simp.showPage(i);
			System.out.println("总页数:"+ simp.getSumPage());
			for (Info info:list){
				System.out.println(info.getId());
			}
			System.out.println("--------当前页数:" + i+"-----------");
		}
	}
}
