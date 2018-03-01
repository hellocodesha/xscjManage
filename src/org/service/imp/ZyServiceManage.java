package org.service.imp;

import java.util.List;

import org.dao.ZyDao;
import org.model.Zyb;
import org.service.ZyService;

/**
 * 
 * @ClassName: ZyServiceManage
 * @Description: ZyService��ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class ZyServiceManage implements ZyService {
	private ZyDao zyDao;

	/**
	 * 
	 * @Title: getZyDao
	 * @Description: zyDao��getter����
	 * @param @return ����
	 * @return ZyDao ��������
	 * @throws
	 */
	public ZyDao getZyDao() {
		return zyDao;
	}

	/**
	 * 
	 * @Title: setZyDao
	 * @Description: zyDao��setter����
	 * @param @param zyDao ����
	 * @return void ��������
	 * @throws
	 */
	public void setZyDao(ZyDao zyDao) {
		this.zyDao = zyDao;
	}

	@Override
	public Zyb getOneZy(Integer zyId) {// ����רҵID����רҵ��Ϣ
		// TODO Auto-generated method stub
		return zyDao.getOneZy(zyId);
	}

	@Override
	public List getAll() {// ��������רҵ��Ϣ
		// TODO Auto-generated method stub
		return zyDao.getAll();
	}

}
