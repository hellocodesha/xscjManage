package org.action;

import java.util.List;
import java.util.Map;

import org.model.Dlb;
import org.model.Xsb;
import org.service.DlService;
import org.service.XsService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: DlAction
 * @Description: ��½action��
 * @author litengbin
 * @date 2017��6��13��
 * 
 */
public class DlAction extends ActionSupport {
	private Dlb dl;
	private DlService dlService;
	private XsService xsService;
	private int pageNow = 1;
	private int pageSize = 8;

	// �����û������execute����
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		boolean validated = false;// ��֤�ɹ���ʶ
		Map session = ActionContext.getContext().getSession();// ��ûỰ����,�������浱ǰ
		Dlb dl1 = null;
		// �Ȼ��Dlb��������ǵ�һ�η��ʸ�ҳ���û�����϶�Ϊ�գ�������ǵڶ��������ǵ����Σ���ֱ�ӵ�½��ҳ�������ٴ��ظ���֤���û���Ϣ
		dl1 = (Dlb) session.get("dl");
		// ����û��ǵ�һ�ν��룬�Ự����δ�洢dl1�־û����󣬹�Ϊnull
		if (dl1 == null || dl1.getXsb().getXh() != dl.getXsb().getXh()) {
			dl1 = dlService.find(dl.getXsb().getXh(), dl.getKl());
			if (dl1 != null) {
				session.put("dl", dl1);// ��dl1����洢�ڻỰ��
				validated = true;// ��ʶΪtrue��ʾ��֤�ɹ�ͨ��
			}
		} else {
			validated = true;// ���û���֮ǰ�ѵ�¼�����ɹ���֤���ʱ�ʶΪtrue��ʾ����������
		}
		if (validated) {
			// ��֤�ɹ������ַ���"success"
			return SUCCESS;
		} else {
			// ��֤ʧ�ܷ����ַ���"error"
			return ERROR;
		}
	}

	public XsService getXsService() {
		return xsService;
	}

	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}

	/**
	 * 
	 * @Title: getDl
	 * @Description: dl��getter����
	 * @param @return ����
	 * @return Dlb ��������
	 * @throws
	 */
	public Dlb getDl() {
		return dl;
	}

	/**
	 * 
	 * @Title: setDl
	 * @Description: dl��setter����
	 * @param @param dl ����
	 * @return void ��������
	 * @throws
	 */
	public void setDl(Dlb dl) {
		this.dl = dl;
	}

	/**
	 * 
	 * @Title: getDlService
	 * @Description: dlService��getter����
	 * @param @return ����
	 * @return DlService ��������
	 * @throws
	 */
	public DlService getDlService() {
		return dlService;
	}

	/**
	 * 
	 * @Title: setDlService
	 * @Description: dlService��setter����
	 * @param @param dlService ����
	 * @return void ��������
	 * @throws
	 */
	public void setDlService(DlService dlService) {
		this.dlService = dlService;
	}

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

	public String look() throws Exception {// ��ʾ���е�¼��Ϣ
		// TODO Auto-generated method stub
		List list = dlService.findAll(pageNow, pageSize);
		Map request = (Map) ActionContext.getContext().get("request");
		Pager page = new Pager(getPageNow(), dlService.findDlSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findDl
	 * @Description: ���ڴ����ݿ��в���ĳ����½����ϸ��Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String findDl() throws Exception {
		String xh = dl.getXsb().getXh();
		Dlb dl = dlService.find1(xh);// ֱ��ʹ��dlServiceҵ���߼��ӿ��е�find1����
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("dl", dl);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: deleteDl
	 * @Description: ɾ����½��Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String deleteDl() throws Exception {
		String xh = dl.getXsb().getXh();
		dlService.delete(xh);// ֱ��ʹ��dlServiceҵ���߼��ӿ��е�delete����
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateDlView
	 * @Description: ��ʾ��½�޸�ҳ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateDlView() throws Exception {
		String xh = dl.getXsb().getXh();
		Dlb dlInfo = dlService.find1(xh);// ֱ��ʹ��dlServiceҵ���߼��ӿ��е�find1()����
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("dlInfo", dlInfo);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateDl
	 * @Description: ִ���޸Ĳ���
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateDl() throws Exception {
		Dlb dl1 = dlService.find1(dl.getXsb().getXh());// ֱ��ʹ��dlServiceҵ���߼��ӿڵ�find1()����
		dl1.setKl(dl.getKl());
		Map request = (Map) ActionContext.getContext().get("request");
		dlService.update(dl1);// ֱ��ʹ��dlServiceҵ���߼��ӿ��е�update()����
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addDlView
	 * @Description: ��ʾ¼��ҳ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addDlView() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addDl
	 * @Description: ִ��¼�����
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addDl() throws Exception {
		Dlb d = new Dlb();
		String xh1 = dl.getXsb().getXh();
		// ѧ���Ѵ��ڣ������ظ�¼��
		if (dlService.find1(xh1) != null)// ʹ��dlServiceҵ���߼��ӿ��е�find1�����ж�
		{
			return ERROR;
		}
		int size = dlService.findDlSize() + 1;
		d.setId(size);
		Xsb xs = xsService.find(xh1);
		d.setXsb(xs);
		d.setKl(dl.getKl());
		dlService.save(d);
		return SUCCESS;
	}
}
