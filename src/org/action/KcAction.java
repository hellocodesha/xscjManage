package org.action;

import java.util.List;
import java.util.Map;

import org.model.Kcb;
import org.service.CjService;
import org.service.KcService;
import org.service.XsService;
import org.tool.Pager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class KcAction extends ActionSupport {
	private int pageNow = 1;
	private int pageSize = 8;
	private Kcb kc;
	private KcService kcService;
	private XsService xsService;
	private CjService cjService;

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
	 * @Title: getKc
	 * @Description: kc��getter����
	 * @param @return ����
	 * @return Kcb ��������
	 * @throws
	 */
	public Kcb getKc() {
		return kc;
	}

	/**
	 * 
	 * @Title: setKc
	 * @Description: kc��setter����
	 * @param @param kc ����
	 * @return void ��������
	 * @throws
	 */
	public void setKc(Kcb kc) {
		this.kc = kc;
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
	 * @Title: getKcService
	 * @Description: kcService��getter����
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
	 * @Description: kcService��setter����
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

	@Override
	public String execute() throws Exception {// ��ʾ����ѧ����Ϣ
		// TODO Auto-generated method stub
		List list = kcService.findAll(pageNow, pageSize);
		Map request = (Map) ActionContext.getContext().get("request");
		Pager page = new Pager(getPageNow(), kcService.findKcSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: findKc
	 * @Description: ���ڴ����ݿ��в���ĳ��ѧ������ϸ��Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String findKc() throws Exception {
		String kch = kc.getKch();
		Kcb k = kcService.find(kch);// ֱ��ʹ��KchServiceҵ���߼��ӿ��е�find����
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("kc", k);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: deleteKc
	 * @Description: ɾ���γ���Ϣ
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String deleteKc() throws Exception {
		String kch = kc.getKch();
		this.setKc(kcService.find(kch));
		int xf = kc.getXf();
		List list = cjService.getXsCjList1(kch);
		kcService.delete(kch);// ֱ��ʹ��kcServiceҵ���߼��ӿ��е�delete����
		//�޸�ѧ������ѧ��
		cjService.deleteKcList(kc.getKch());
		xsService.updateXf(0 - xf, list);
		
		
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateKcView
	 * @Description: ��ʾ�γ��޸�ҳ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateKcView() throws Exception {
		String kch = kc.getKch();
		Kcb kcInfo = kcService.find(kch);// ֱ��ʹ��kcbServiceҵ���߼��ӿ��е�find()����
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("kcInfo", kcInfo);
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: updateKc
	 * @Description: ִ���޸Ĳ���
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String updateKc() throws Exception {
		Kcb kc1 = kcService.find(kc.getKch());// ֱ��ʹ��kcServiceҵ���߼��ӿڵ�find()����
		kc1.setKcm(kc.getKcm());
		kc1.setKxxq(kc.getKxxq());
		kc1.setXs(kc.getXs());
		int xf = kc1.getXf();
		kc1.setXf(kc.getXf());
		Map request = (Map) ActionContext.getContext().get("request");
		kcService.update(kc1);// ֱ��ʹ��kcServiceҵ���߼��ӿ��е�update()����
		if (xf != kc.getXf()) {
			cjService.updateKcList(kc.getKch(), kc.getXf());
			List list = cjService.getXsCjList1(kc.getKch());
			xsService.updateXf(kc.getXf() - xf, list);
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addKcView
	 * @Description: ��ʾ¼��ҳ��
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addKcView() throws Exception {
		return SUCCESS;
	}

	/**
	 * 
	 * @Title: addKc
	 * @Description: ִ��¼�����
	 * @param @return
	 * @param @throws Exception ����
	 * @return String ��������
	 * @throws
	 */
	public String addKc() throws Exception {
		Kcb k = new Kcb();
		String kch1 = kc.getKch();
		// �γ̺��Ѵ��ڣ������ظ�¼��
		if (kcService.find(kch1) != null)// ʹ��kcServiceҵ���߼��ӿ��е�find�����ж�
		{
			return ERROR;
		}
		k.setKch(kch1);
		k.setKcm(kc.getKcm());
		k.setKxxq(kc.getKxxq());
		k.setXs(kc.getXs());
		k.setXf(kc.getXf());
		kcService.save(k);
		return SUCCESS;
	}
}
