package org.service;

import java.util.List;

import org.model.Cjb;

/**
 * 
 * @ClassName: CjService
 * @Description: ѧ���ɼ�������Service
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface CjService {
	/**
	 * 
	 * @Title: getXsCj
	 * @Description: ����ѧ�źͿγ̺Ų�ѯѧ���ɼ�
	 * @param @param xh
	 * @param @param kch
	 * @param @return ����
	 * @return Cjb ��������
	 * @throws
	 */
	public Cjb getXsCj(String xh, String kch);

	/**
	 * 
	 * @Title: saveorupdateCj
	 * @Description: ¼��ѧ���ɼ�
	 * @param @param cj ����
	 * @return void ��������
	 * @throws
	 */
	public void saveorupdateCj(Cjb cj);

	/**
	 * 
	 * @Title: findAll
	 * @Description: ��ҳ��ʾ����ѧ���ɼ�
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List findAll(int pageNow, int pageSize);

	/**
	 * 
	 * @Title: findCjSize
	 * @Description: ��ѯһ���������ɼ���¼
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int findCjSize();

	/**
	 * 
	 * @Title: getXsCjList
	 * @Description: ��ȡĳѧ���ĳɼ��б�
	 * @param @param xh
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List getXsCjList(String xh);

	/**
	 * 
	 * @Title: deleteCj
	 * @Description: ����ѧ�źͿγ̺�ɾ��ѧ���ɼ�
	 * @param @param xh
	 * @param @param kch ����
	 * @return void ��������
	 * @throws
	 */
	public void deleteCj(String xh, String kch);

	/**
	 * 
	 * @Title: deleteOneXsCj
	 * @Description: ɾ��ĳѧ���ĳɼ�
	 * @param @param xh ����
	 * @return void ��������
	 * @throws
	 */
	public void deleteOneXsCj(String xh);
	
	/**
	 * 
	    * @Title: updateKcList  
	    * @Description: ���¸ÿγ̺ŵ�ѧ�����ѧ��
	    * @param @param kch
	    * @param @param xf    ����  
	    * @return void    ��������  
	    * @throws
	 */
	public void updateKcList(String kch, int xf);// ���¸ÿγ̺ŵ�ѧ�����ѧ��
	/**
	 * 
	    * @Title: getXsCjList1  
	    * @Description: ���ݿγ̺Ż�ȡѧ���б�
	    * @param @param kch
	    * @param @return    ����  
	    * @return List    ��������  
	    * @throws
	 */
	public List getXsCjList1(String kch);
	
	/**
	 * 
	    * @Title: deleteKcList  
	    * @Description: ���¸ÿγ̺ŵ�ѧ�����ѧ��
	    * @param @param kch  ����  
	    * @return void    ��������  
	    * @throws
	 */
	public void deleteKcList(String kch);// ɾ���ÿγ̺ŵ�ѧ���б��ѧ��
}
