package org.action;

import java.util.List;
import java.util.Map;

import org.model.Cjb;
import org.model.CjbId;
import org.model.Kcb;
import org.model.Xsb;
import org.service.CjService;
import org.service.KcService;
import org.service.XsService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName: CjAction
 * @Description: �ɼ�Action��
 * @author litengbin
 * @date 2017��6��13��
 * 
 */
public class CjAction extends ActionSupport {
	private Cjb cj;
	private XsService xsService;
	private KcService kcService;
	private CjService cjService;
	private int pageNow = 1;
	private int pageSize = 8;

	@Override
	public String execute() throws Exception {// ��ȡ���е�����ѧ���Ϳγ����б�
		// TODO Auto-generated method stub
		List list1 = xsService.findAll(1, xsService.findXsSize());// ͨ��XsService�ӿڻ�ȡ����ѧ����
		List list2 = kcService.findAll(1, kcService.findKcSize());// ͨ��KcService�ӿڻ�ȡ���пγ���
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list1", list1);// ������ѧ�����б���������з���
		request.put("list2", list2);// �����пγ����б���������з���
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addorupdateXscj
	 * @Description: �ɼ�¼��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addorupdateXscj() throws Exception {// ִ�гɼ�¼�����
		Cjb cj1 = null;
		CjbId cjId1 = new CjbId();
		String xh = cj.getId().getXsb().getXh();
		String kch = cj.getId().getKcb().getKch();
		// ͨ��CjServiceҵ���߼��ӿ��е�getXsCj()�����жϳɼ���¼�Ƿ��Ѵ���
		if (cjService.getXsCj(xh, kch) == null) {
			cj1 = new Cjb();
			Xsb xsb = xsService.find(xh);
			Kcb kcb = kcService.find(kch);
			cjId1.setKcb(kcb);
			cjId1.setXsb(xsb);
			cj1.setId(cjId1);
		} else// �ɼ���¼�Ѿ�����
		{
			cj1 = cjService.getXsCj(xh, kch);
		}
		Kcb kc1 = kcService.find(kch);// ͨ��KcService�ӿڻ�ȡ��Ӧ�Ŀγ̵�ѧ��ֵ
		cj1.setCj(cj.getCj());
		if (cj.getCj() > 60 || cj.getCj() == 60) {// �жϳɼ����񣬲Ÿ���ѧ��
			cj1.setXf(kc1.getXf());
		} else {
			cj1.setXf(0);// �������û��ѧ��
		}
		cjService.saveorupdateCj(cj1);// ͨ��CjServiceҵ���߼��ӿڱ������³ɼ�
		// ����xsb�����ѧ��
		List list = cjService.getXsCjList(xh);
		Xsb xs = xsService.find(xh);
		int zxf = 0;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			zxf += Integer.valueOf(obj[4].toString().trim());
		}
		xs.setZxf(zxf);
		xsService.update(xs);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: xscjInfo
	 * @Description: ��ʾ����ѧ���ɼ�
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String xscjInfo() throws Exception {
		// ֱ��ʹ��CjServiceҵ���߼��ӿ��е�findAllCj()����
		List list = cjService.findAll(this.getPageNow(), this.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		Pager page = new Pager(this.getPageNow(), cjService.findCjSize());
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findXscj
	 * @Description: ��ȡѧ���ɼ��б�
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String findXscj() throws Exception {
		// ʹ��CjServiceҵ���߼��ӿ��е�getXsCjList()������ȡĳѧ���ĳɼ��б�
		List list = cjService.getXsCjList(cj.getId().getXsb().getXh());
		if (list.size() > 0) {
			Map request = (Map) ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 
	 * @Title: deleteOneXscj
	 * @Description: ɾ��ѧ���ɼ�
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String deleteOneXscj() throws Exception {
		String xh = cj.getId().getXsb().getXh();
		String kch = cj.getId().getKcb().getKch();
		cjService.deleteCj(xh, kch);// ͨ��CjServiceҵ���߼��ӿ��е�deleteCj()����ִ��ɾ��
		// ����xsb�����ѧ��
		List list = cjService.getXsCjList(xh);
		Xsb xs = xsService.find(xh);
		int zxf = 0;
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			zxf += Integer.valueOf(obj[4].toString().trim());
		}
		xs.setZxf(zxf);
		xsService.update(xs);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: getCj
	 * @Description: cj��getter����
	 * @param @return ����
	 * @return Cjb ��������
	 * @throws
	 */
	public Cjb getCj() {
		return cj;
	}

	/**
	 * 
	 * @Title: setCj
	 * @Description: cj��setter����
	 * @param @param cj ����
	 * @return void ��������
	 * @throws
	 */
	public void setCj(Cjb cj) {
		this.cj = cj;
	}

	/**
	 * 
	 * @Title: getXsService
	 * @Description: XsService��getter����
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
	 * @Title: getKcService
	 * @Description: KcService��getter����
	 * @param @return ����
	 * @return KcService ��������
	 * @throws
	 */
	public KcService getKcService() {
		return kcService;
	}

	/**
	 * 
	 * @Title: setKcService
	 * @Description: KcService��setter����
	 * @param @param kcService ����
	 * @return void ��������
	 * @throws
	 */
	public void setKcService(KcService kcService) {
		this.kcService = kcService;
	}

	/**
	 * 
	 * @Title: getCjService
	 * @Description: cjService��getter����
	 * @param @return ����
	 * @return CjService ��������
	 * @throws
	 */
	public CjService getCjService() {
		return cjService;
	}

	/**
	 * 
	 * @Title: setCjService
	 * @Description: cjService��setter����
	 * @param @param cjService ����
	 * @return void ��������
	 * @throws
	 */
	public void setCjService(CjService cjService) {
		this.cjService = cjService;
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
}
