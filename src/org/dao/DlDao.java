package org.dao;

import java.util.List;

import org.model.Dlb;
import org.model.Xsb;

/**
 * 
 * @ClassName: DlDao
 * @Description: ϵͳ��¼����DAO
 * @author litengbin
 * @date 2017��6��11��
 * 
 */
public interface DlDao {
	/**
	 * 
	 * @Title: find
	 * @Description: ��¼��֤
	 * @param @param xh
	 * @param @param kl
	 * @param @return ����
	 * @return Dlb ��������
	 * @throws
	 */
	public Dlb find(String xh, String kl);

	/**
	 * 
	 * @Title: findAll
	 * @Description: ��½��Ϣ��ѯ
	 * @param @param pageNow
	 * @param @param pageSize
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List findAll(int pageNow, int pageSize);

	/**
	 * 
	 * @Title: findDlSize
	 * @Description: ��ѯ��½��Ϣ��¼����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int findDlSize();

	/**
	 * 
	 * @Title: delete
	 * @Description: ɾ����½��Ϣ
	 * @param @param xh ����
	 * @return void ��������
	 * @throws
	 */
	public void delete(String xh);

	/**
	 * 
	 * @Title: update
	 * @Description: �޸ĵ�½��Ϣ
	 * @param @param dl ����
	 * @return void ��������
	 * @throws
	 */
	public void update(Dlb dl);

	/**
	 * 
	 * @Title: save
	 * @Description: ���ӵ�¼��Ϣ
	 * @param @param dl ����
	 * @return void ��������
	 * @throws
	 */
	public void save(Dlb dl);
	
	/**
	 * 
	 * @Title: find1
	 * @Description: �鿴ѧ������ϸ��Ϣ
	 * @param @param xh
	 * @param @return ����
	 * @return Dlb ��������
	 * @throws
	 */
	public Dlb find1(String xh);
}