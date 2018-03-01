package org.service;

import java.util.List;

import org.model.Kcb;

/**
 * 
 * @ClassName: KcService
 * @Description: KcService�ӿ�
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface KcService {
	/**
	 * 
	 * @Title: findAll
	 * @Description: ��ѯ���пγ���Ϣ
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List findAll(int pageNow, int pageSize);

	/**
	 * 
	 * @Title: findKcSize
	 * @Description: ��ѯһ���������γ̼�¼
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int findKcSize();

	/**
	 * 
	 * @Title: find
	 * @Description: ���ݿγ̺Ų��ҿγ���Ϣ
	 * @param @param kch
	 * @param @return ����
	 * @return Kcb ��������
	 * @throws
	 */
	public Kcb find(String kch);

	/**
	 * 
	 * @Title: delete
	 * @Description: ɾ���γ���Ϣ
	 * @param @param kch ����
	 * @return void ��������
	 * @throws
	 */
	public void delete(String kch);

	/**
	 * 
	 * @Title: update
	 * @Description: �޸Ŀγ���Ϣ
	 * @param @param kc ����
	 * @return void ��������
	 * @throws
	 */
	public void update(Kcb kc);
	
	/**
	 * 
	 * @Title: save
	 * @Description: ���ӿγ���Ϣ
	 * @param @param kc ����
	 * @return void ��������
	 * @throws
	 */
	public void save(Kcb kc);
}
