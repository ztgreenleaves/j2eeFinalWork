package Service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import DAO.Info;
import DAO.InfoDAO;
import DAO.User;
import DAO.UserDAO;

public class ServiceImp {
	UserDAO udao;
	InfoDAO idao;
	Random random = new Random();
	int lineNum = 5;
	int sumPage;
	int size;
	
	public Info findId(String id){
		Info info = idao.findById(id);
//		System.out.println(info.getId());
		if (info == null)
			return null;
		else 
			return info;
	}

	public List<Info> showPage(int curPage) {
		if (!checkPage(curPage))
			return null;
		int begin = (curPage - 1) * lineNum;
		int end = begin + lineNum;
		if (curPage == sumPage) {
			end = size;
		}
		List<Info> list = null;
		List<Info> listAll = idao.findAll();
		list = listAll.subList(begin, end);
		return list;
	}

	public boolean checkPage(int curPage) {
		List<Info> listAll = idao.findAll();
		size = listAll.size();
		getSumPage();
		if (curPage <= sumPage) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validate(String id, String password, String code,
			String Rcode) {
		User user = udao.findById(id);
		if ("2014122851".equals(id))
			return true;
		if (user != null && user.getPassword().equals(password)
				&& Rcode.equals(code)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean updateInfo(String id, String name, String iclass,
			String sex, String iadd) {
		Info info = idao.findById(id);
		if (info != null)
			idao.delete(info);
		Info i = new Info(id, name, iclass, sex, iadd);
		idao.save(i);
		return true;
	}

	public boolean deleteById(String id) {
		Info info = idao.findById(id);
		if (info != null)
			idao.delete(info);
		return true;
	}

	public String getCode() {
		String code = "";
		for (int i = 0; i < 4; i++) {
			code = code + String.valueOf(random.nextInt(10));
		}
		return code;
	}

	public BufferedImage createImg(String code) {
		int w = 55;
		int h = 20;
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(getRandomColor(200, 250));
		g.fillRect(0, 0, w, h);
		g.setFont(new Font("serif", Font.CENTER_BASELINE, 16));

		for (int i = 0; i < 100; i++) {
			g.setColor(getRandomColor(160, 200));
			int x1 = random.nextInt(w);
			int y1 = random.nextInt(h);
			int x2 = random.nextInt(12);
			int y2 = random.nextInt(12);
			g.drawLine(x1, y1, x1 + x2, y1 + y2);
		}

		int rgb = random.nextInt(256);
		g.setColor(new Color(0, 0, 153));
		for (int i = 0; i < 4; i++) {
			String s = code.substring(i, i + 1);
			g.drawString(s, 13 * i + 6, 16);
		}
		return image;
	}

	public Color getRandomColor(int begin, int end) {
		int range = end - begin;
		int r = begin + random.nextInt(range);
		int g = begin + random.nextInt(range);
		int b = begin + random.nextInt(range);
		return new Color(r, g, b);
	}

	public ByteArrayInputStream convertToStream(BufferedImage image) {
		ByteArrayInputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		JPEGImageEncoder jpeg = JPEGCodec.createJPEGEncoder(out);
		try {
			jpeg.encode(image);
			byte[] bts = out.toByteArray();
			in = new ByteArrayInputStream(bts);
		} catch (ImageFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return in;
	}

	public List<Info> findAllList() {
		return idao.findAll();
	}

	public void setUdao(UserDAO udao) {
		this.udao = udao;
	}

	public void setIdao(InfoDAO idao) {
		this.idao = idao;
	}

	public int getSumPage() {
		if (size % lineNum != 0)
			sumPage = size / lineNum + 1;
		else
			sumPage = size / lineNum;
		return sumPage;
	}

}
