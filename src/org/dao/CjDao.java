package org.dao;

import java.util.List;

import org.model.Cjb;

/**
 * 
 * @ClassName: CjDao
 * @Description: ѧ���ɼ�������Dao
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface CjDao {
	/**
	 * 
	 * @Title: getXsCj
	 * @Description: �ɼ���Ϣ¼��
	 * @param @param xh
	 * @param @param kch
	 * @param @return ����
	 * @return Cjb ��������
	 * @throws
	 */
	public Cjb getXsCj(String xh, String kch);// ����ѧ�źͿγ̺Ų�ѯѧ���ɼ�

	/**
	 * 
	 * @Title: saveorupdateCj
	 * @Description: ¼��ѧ���ɼ�
	 * @param @param cj ����
	 * @return void ��������
	 * @throws
	 */
	public void saveorupdateCj(Cjb cj);// ¼��ѧ���ɼ�

	/**
	 * 
	 * @Title: findAllCj
	 * @Description: ѧ���ɼ���ѯ
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List findAllCj(int pageNow, int pageSize);// ��ҳ��ʾ����ѧ���ɼ�

	/**
	 * 
	 * @Title: findCjSize
	 * @Description: �ɼ���¼����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int findCjSize();// ��ѯһ���������ɼ���¼

	/**
	 * 
	 * @Title: getXsCjList
	 * @Description: �鿴ĳ��ѧ���ĳɼ���
	 * @param @param xh
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List getXsCjList(String xh);// ��ȡĳѧ���ĳɼ��б�

	/**
	 * 
	 * @Title: deleteCj
	 * @Description: ɾ��ѧ���ɼ�
	 * @param @param xh
	 * @param @param kch ����
	 * @return void ��������
	 * @throws
	 */
	public void deleteCj(String xh, String kch);// ����ѧ�úͿγ̺�ɾ��ѧ���ɼ�

	/**
	 * 
	 * @Title: deleteOneXsCj
	 * @Description: ɾ��ѧ���ɼ�
	 * @param @param xh ����
	 * @return void ��������
	 * @throws
	 */
	public void deleteOneXsCj(String xh);// ɾ��ĳѧ���ĳɼ�
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
