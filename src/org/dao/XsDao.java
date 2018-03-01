package org.dao;

import java.util.List;

import org.model.Xsb;

/**
 * 
 * @ClassName: XsDao
 * @Description: ѧ����Ϣ������Dao
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface XsDao {
	/**
	 * 
	 * @Title: findAll
	 * @Description: ѧ����Ϣ��ѯ
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List findAll(int pageNow, int pageSize);

	/**
	 * 
	 * @Title: findXsSize
	 * @Description: ��ѯѧ����¼����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int findXsSize();

	/**
	 * 
	 * @Title: find
	 * @Description: �鿴ѧ������ϸ��Ϣ
	 * @param @param xh
	 * @param @return ����
	 * @return Xsb ��������
	 * @throws
	 */
	public Xsb find(String xh);

	/**
	 * 
	 * @Title: delete
	 * @Description: ɾ��ѧ����Ϣ
	 * @param @param xh ����
	 * @return void ��������
	 * @throws
	 */
	public void delete(String xh);

	/**
	 * 
	 * @Title: update
	 * @Description: �޸�ѧ����Ϣ
	 * @param @param xs ����
	 * @return void ��������
	 * @throws
	 */
	public void update(Xsb xs);

	/**
	 * 
	 * @Title: save
	 * @Description: ����ѧ����Ϣ
	 * @param @param xs ����
	 * @return void ��������
	 * @throws
	 */
	public void save(Xsb xs);

	/**
	 * 
	 * @Title: updateXf
	 * @Description: ������ѧ��
	 * @param @param xf
	 * @param @param list ����
	 * @return void ��������
	 * @throws
	 */
	public void updateXf(int xf, List list);
}
