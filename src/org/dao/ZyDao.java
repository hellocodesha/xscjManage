package org.dao;

import java.util.List;

import org.model.Zyb;

/**
 * 
 * @ClassName: ZyDao
 * @Description: רҵDao�ӿ�
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface ZyDao {
	/**
	 * 
	 * @Title: getOneZy
	 * @Description: ѧ����Ϣ��ѯ
	 * @param @param zyId
	 * @param @return ����
	 * @return Zyb ��������
	 * @throws
	 */
	public Zyb getOneZy(Integer zyId);// ����רҵID����רҵ��Ϣ

	/**
	 * 
	 * @Title: getAll
	 * @Description: �޸�ĳѧ����Ϣ
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List getAll();// ��������רҵ��Ϣ

}
