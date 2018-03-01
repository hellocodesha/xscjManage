package org.service;

import java.util.List;

import org.model.Xsb;

/**
 * 
 * @ClassName: XsService
 * @Description: ѧ����Ϣ������Service
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface XsService {
	/**
	 * 
	 * @Title: findAll
	 * @Description: ��ʾ����ѧ����Ϣ
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
	 * @Description: ��ѯһ��������ѧ����¼
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int findXsSize();

	/**
	 * 
	 * @Title: find
	 * @Description: �鿴ĳ��ѧ������ϸ��Ϣ
	 * @param @param xh
	 * @param @return ����
	 * @return Xsb ��������
	 * @throws
	 */
	public Xsb find(String xh);

	/**
	 * 
	 * @Title: delete
	 * @Description: ɾ��ĳѧ����Ϣ
	 * @param @param xh ����
	 * @return void ��������
	 * @throws
	 */
	public void delete(String xh);

	/**
	 * 
	 * @Title: update
	 * @Description: �޸�ĳѧ����Ϣ
	 * @param @param xs ����
	 * @return void ��������
	 * @throws
	 */
	public void update(Xsb xs);

	/**
	 * 
	 * @Title: save
	 * @Description: ѧ����Ϣ¼��
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
