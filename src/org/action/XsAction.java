package org.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.model.Xsb;
import org.model.Zyb;
import org.service.XsService;
import org.service.ZyService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: XsAction
 * @Description: ѧ��action��
 * @author litengbin
 * @date 2017��6��13��
 * 
 */
public class XsAction extends ActionSupport {
	private int pageNow = 1;
	private int pageSize = 8;
	private Xsb xs;
	private XsService xsService;
	private ZyService zyService;// ���ڲ�������רҵ��Ϣ�Լ���רҵ�����б�
	private File zpFile;// ���ڻ�ȡ��Ƭ�ļ�
	private List list;// ���רҵ����
	private Zyb zyb;

	/**
	 * 
	 * @Title: getPageNow
	 * @Description: pageNow��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getPageNow() {
		return pageNow;
	}

	/**
	 * 
	 * @Title: setPageNow
	 * @Description: pageNow��setter����
	 * @param @param pageNow ����
	 * @return void ��������
	 * @throws
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	/**
	 * 
	 * @Title: getPageSize
	 * @Description: pageSize��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @Title: setPageSize
	 * @Description: pageSize��setter����
	 * @param @param pageSize ����
	 * @return void ��������
	 * @throws
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @Title: getXs
	 * @Description: xs��getter����
	 * @param @return ����
	 * @return Xsb ��������
	 * @throws
	 */
	public Xsb getXs() {
		return xs;
	}

	/**
	 * 
	 * @Title: setXs
	 * @Description: xs��setter����
	 * @param @param xs ����
	 * @return void ��������
	 * @throws
	 */
	public void setXs(Xsb xs) {
		this.xs = xs;
	}

	/**
	 * 
	 * @Title: getXsService
	 * @Description: xsService��getter����
	 * @param @return ����
	 * @return XsService ��������
	 * @throws
	 */
	public XsService getXsService() {
		return xsService;
	}

	/**
	 * 
	 * @Title: setXsService
	 * @Description: xsService��setter����
	 * @param @param xsService ����
	 * @return void ��������
	 * @throws
	 */
	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}

	/**
	 * 
	 * @Title: getZyService
	 * @Description: zyService��getter����
	 * @param @return ����
	 * @return ZyService ��������
	 * @throws
	 */
	public ZyService getZyService() {
		return zyService;
	}

	/**
	 * 
	 * @Title: setZyService
	 * @Description: zyService��setter����
	 * @param @param zyService ����
	 * @return void ��������
	 * @throws
	 */
	public void setZyService(ZyService zyService) {
		this.zyService = zyService;
	}

	/**
	 * 
	 * @Title: getZpFile
	 * @Description: zpFile��getter����
	 * @param @return ����
	 * @return File ��������
	 * @throws
	 */
	public File getZpFile() {
		return zpFile;
	}

	/**
	 * 
	 * @Title: setZpFile
	 * @Description: zpFile��setter����
	 * @param @param zpFile ����
	 * @return void ��������
	 * @throws
	 */
	public void setZpFile(File zpFile) {
		this.zpFile = zpFile;
	}

	/**
	 * 
	 * @Title: getList
	 * @Description: list��getter����
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List getList() {
		return zyService.getAll();// ����רҵ�ļ���
	}

	/**
	 * 
	 * @Title: setList
	 * @Description: list��setter����
	 * @param @param list ����
	 * @return void ��������
	 * @throws
	 */
	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {// ��ʾ����ѧ����Ϣ
		// TODO Auto-generated method stub
		List list = xsService.findAll(pageNow, pageSize);
		Map request = (Map) ActionContext.getContext().get("request");
		Pager page = new Pager(getPageNow(), xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findXs
	 * @Description: ���ڴ����ݿ��в���ĳ��ѧ������ϸ��Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String findXs() throws Exception {
		String xh = xs.getXh();
		Xsb stu = xsService.find(xh);// ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find����
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("xs", stu);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getZyb
	 * @Description: zyb��getter����
	 * @param @return ����
	 * @return Zyb ��������
	 * @throws
	 */
	public Zyb getZyb() {
		return zyb;
	}

	/**
	 * 
	 * @Title: setZyb
	 * @Description: zyb��setter����
	 * @param @param zyb ����
	 * @return void ��������
	 * @throws
	 */
	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}

	/**
	 * 
	 * @Title: getImage
	 * @Description: ���ѧ����Ƭ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String getImage() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		String xh = xs.getXh();
		Xsb stu = xsService.find(xh);// ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find����
		byte[] img = stu.getZp();
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		if (img != null && img.length != 0) {
			for (int i = 0; i < img.length; i++) {
				os.write(img[i]);
			}
			os.flush();
		}
		return NONE;
	}

	/**
	 * 
	 * @Title: deleteXs
	 * @Description: ɾ��ѧ����Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String deleteXs() throws Exception {
		String xh = xs.getXh();
		xsService.delete(xh);// ֱ��ʹ��XsServiceҵ���߼��ӿ��е�delete����
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateXsView
	 * @Description: ��ʾѧ���޸�ҳ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateXsView() throws Exception {
		String xh = xs.getXh();
		Xsb xsInfo = xsService.find(xh);// ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find()����
		this.setZyb(xsInfo.getZyb());
		List zys = zyService.getAll();// ֱ��ʹ��ZyServiceҵ���߼��ӿ��е�getAll()����
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateXs
	 * @Description: ִ���޸Ĳ���
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateXs() throws Exception {
		Xsb xs1 = xsService.find(xs.getXh());// ֱ��ʹ��xsServiceҵ���߼��ӿڵ�find()����
		xs1.setXm(xs.getXm());
		xs1.setXb(xs.getXb());
		// ֱ��ʹ��ZyServiceҵ���߼��ӿڵ�getOneZy()����
		xs1.setZyb(zyService.getOneZy(zyb.getId()));
		xs1.setCssj(xs.getCssj());
		xs1.setBz(xs.getBz());
		if (this.getZpFile() != null) {
			FileInputStream fis = new FileInputStream(this.getZpFile());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			xs1.setZp(buffer);
		}
		Map request = (Map) ActionContext.getContext().get("request");
		xsService.update(xs1);// ֱ��ʹ��XsServiceҵ���߼��ӿ��е�update()����
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addXsView
	 * @Description: ��ʾ¼��ҳ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addXsView() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addXs
	 * @Description: ִ��¼�����
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addXs() throws Exception {
		Xsb stu = new Xsb();
		String xh1 = xs.getXh();
		// ѧ���Ѵ��ڣ������ظ�¼��
		if (xsService.find(xh1) != null)// ʹ��XsServiceҵ���߼��ӿ��е�find�����ж�
		{
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		// ֱ��ʹ��ZyServiceҵ���߼��ӿ��е�getOneZy()����
		stu.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		if (this.getZpFile() != null) {
			FileInputStream fis = new FileInputStream(this.getZpFile());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		xsService.save(stu);
		return SUCCESS;
	}
}
