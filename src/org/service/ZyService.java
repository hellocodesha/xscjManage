package org.service;

import java.util.List;

import org.model.Zyb;

/**
 * 
 * @ClassName: ZyService
 * @Description: ҵ���߼�ZyService�ӿ�
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public interface ZyService {
	/**
	 * 
	 * @Title: getOneZy
	 * @Description: ����רҵId����רҵ��Ϣ
	 * @param @param zyId
	 * @param @return ����
	 * @return Zyb ��������
	 * @throws
	 */
	public Zyb getOneZy(Integer zyId);

	/**
	 * 
	 * @Title: getAll
	 * @Description: ��������רҵ��Ϣ
	 * @param @return ����
	 * @return List ��������
	 * @throws
	 */
	public List getAll();
}
