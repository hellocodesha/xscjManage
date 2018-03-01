package org.service.imp;

import java.util.List;

import org.dao.KcDao;
import org.model.Kcb;
import org.service.KcService;

/**
 * 
 * @ClassName: KcServiceManage
 * @Description: KcService��ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class KcServiceManage implements KcService {
	private KcDao kcDao;

	/**
	 * 
	 * @Title: getKcDao
	 * @Description: kcDao��getter����
	 * @param @return ����
	 * @return KcDao ��������
	 * @throws
	 */
	public KcDao getKcDao() {
		return kcDao;
	}

	/**
	 * 
	 * @Title: setKcDao
	 * @Description: kcDao��setter����
	 * @param @param kcDao ����
	 * @return void ��������
	 * @throws
	 */
	public void setKcDao(KcDao kcDao) {
		this.kcDao = kcDao;
	}

	@Override
	public List findAll(int pageNow, int pageSize) {// ��ѯ���пγ���Ϣ
		// TODO Auto-generated method stub
		return kcDao.findAll(pageNow, pageSize);
	}

	@Override
	public int findKcSize() {// ��ѯһ���������γ̼�¼
		// TODO Auto-generated method stub
		return kcDao.findKcSize();
	}

	@Override
	public Kcb find(String kch) {// ���ݿγ̺Ų��ҿγ���Ϣ
		// TODO Auto-generated method stub
		return kcDao.find(kch);
	}

	@Override
	public void delete(String kch) {
		// TODO Auto-generated method stub
		kcDao.delete(kch);
	}

	@Override
	public void update(Kcb kc) {
		// TODO Auto-generated method stub
		kcDao.update(kc);
	}

	@Override
	public void save(Kcb kc) {
		// TODO Auto-generated method stub
		kcDao.save(kc);
	}

}
