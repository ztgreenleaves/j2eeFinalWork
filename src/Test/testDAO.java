package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DAO.InfoDAO;
import DAO.User;
import DAO.UserDAO;


public class testDAO {
	public static void main(String args[]){
		ApplicationContext cfx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO dao = (UserDAO) cfx.getBean("UserDAO");
		InfoDAO dao1 = (InfoDAO) cfx.getBean("InfoDAO");
		User user = new User("22", "22");
		dao.save(user);
		int size = dao.findAll().size();
		int s = dao1.findAll().size();
		System.out.println(size + " " + s);
	}
}
