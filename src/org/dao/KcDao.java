package org.dao;

import java.util.List;

import org.model.Kcb;
import org.model.Xsb;

/**
 * 
 * @ClassName: KcDao
 * @Description: �γ�Dao�ӿ�
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface KcDao {
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
	 * @Description: ���ݿγ̺Ų�ѯ�γ���Ϣ
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
