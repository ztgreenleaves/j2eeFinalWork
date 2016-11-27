package Action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import DAO.Info;
import Service.SecurityCode;
import Service.SecurityImage;
import Service.ServiceImp;

public class LoginAction {
	ServiceImp simp;
	String id;
	String password;
	String name;
	String sex;
	String iclass;
	String iadd;
	String code;
	String msg;
	int findIdFlag;
	int isFindOutFlag;
	static int begin_end_pageFlag = 2;
	// int curPage;
	static int curPage = 1;
	static int flagUp = 0;
	static int flagBack = 1;
	static String Rcode;
	private ByteArrayInputStream imageStream;
	static String sID;
	static String sPW;
	List<Info> list;

	public String dologin() {
		boolean loginFlag = simp.validate(id, password, code, Rcode);
		if (loginFlag) {
			// setList(simp.findAllList());
			list = simp.showPage(1);
			setsID(id);
			setsPW(password);
			setCurPage(1);
			setFindIdFlag(0);
			return "success";
		} else {
			return "failure";
		}
	}

	public String toUpdatePage() {
		return "update";
	}

	public String toSuccessPage() {
		list = simp.showPage(1);
		setCurPage(1);
		flagUp = 0;
		flagBack = 1;
		return "success";
	}

	public String updateInfo() {
		System.out.println("id:" + id + " 哈哈:" + name + " class:" + iclass
				+ " sex:" + sex + " add:" + iadd);
		simp.updateInfo(id, name, iclass, sex, iadd);
		list = simp.showPage(1);
		setCurPage(1);
		flagUp = 0;
		flagBack = 1;
		return "success";
	}

	public String deleteInfo() {
		simp.deleteById(id);
		list = simp.showPage(1);
		setCurPage(1);
		flagUp = 0;
		flagBack = 1;
		setId(null);
		setName(null);
		setIclass(null);
		setSex(null);
		setIadd(null);
		System.out.println("null");
		setIsFindOutFlag(0);
		return "success";
	}

	public String imgCode() {
		setRcode(simp.getCode());
		System.out.println(Rcode);
		try {
			BufferedImage image = simp.createImg(Rcode);
			imageStream = simp.convertToStream(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "image";

	}

	public String divPage() {
		System.out.println("current page:" + curPage);
		int endPage = simp.getSumPage();

		if (begin_end_pageFlag == 1) {// first page
			curPage = 1;
		} else if (begin_end_pageFlag == 0) {// end page
			curPage = endPage;
		}
		begin_end_pageFlag = 2;// 清除
		if (curPage == 1) {
			flagUp = 0;// don't
		} else {
			flagUp = 1;// show 前一页 label
		}
		if (curPage == endPage) {
			flagBack = 0;// don't
		} else {
			flagBack = 1;// show 后一页 label
		}
		System.out.println("current page:" + curPage);
		list = simp.showPage(curPage);
		setList(list);
		return "success";
	}

	public String findById() {
		setFindIdFlag(1);
		Info info = simp.findId(id);
		setFindIdFlag(1);
		if (info != null) {
			setIsFindOutFlag(1);
			setId(info.getId());
			setName(info.getName());
			setIclass(info.getIclass());
			setSex(info.getSex());
			setIadd(info.getIadd());
			return "success";
		} 
		else {
			setId(null);
			setName(null);
			setIclass(null);
			setSex(null);
			setIadd(null);
			System.out.println("null");
			setIsFindOutFlag(0);
			msg = "查无此人!";
			return "success";
		}
	}

	/**
	 * get set methods
	 **/

	public void setSimp(ServiceImp simp) {
		this.simp = simp;
	}

	public int getFlagUp() {
		return flagUp;
	}

	public void setFlagUp(int flagUp) {
		this.flagUp = flagUp;
	}

	public int getFlagBack() {
		return flagBack;
	}

	public void setFlagBack(int flagBack) {
		this.flagBack = flagBack;
	}

	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Info> getList() {
		return list;
	}

	public void setList(List<Info> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public static String getsID() {
		return sID;
	}

	public static void setsID(String sID) {
		LoginAction.sID = sID;
	}

	public static String getsPW() {
		return sPW;
	}

	public static void setsPW(String sPW) {
		LoginAction.sPW = sPW;
	}

	public String getIclass() {
		return iclass;
	}

	public void setIclass(String iclass) {
		this.iclass = iclass;
	}

	public String getIadd() {
		return iadd;
	}

	public void setIadd(String iadd) {
		this.iadd = iadd;
	}

	public static String getRcode() {
		return Rcode;
	}

	public static void setRcode(String rcode) {
		Rcode = rcode;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getBegin_end_pageFlag() {
		return begin_end_pageFlag;
	}

	public void setBegin_end_pageFlag(int begin_end_pageFlag) {
		this.begin_end_pageFlag = begin_end_pageFlag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getFindIdFlag() {
		return findIdFlag;
	}

	public void setFindIdFlag(int findIdFlag) {
		this.findIdFlag = findIdFlag;
	}

	public int getIsFindOutFlag() {
		return isFindOutFlag;
	}

	public void setIsFindOutFlag(int isFindOutFlag) {
		this.isFindOutFlag = isFindOutFlag;
	}

}
