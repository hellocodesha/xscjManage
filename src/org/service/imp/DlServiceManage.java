package org.service.imp;

import java.util.List;

import org.dao.DlDao;
import org.model.Dlb;
import org.service.DlService;

/**
 * 
 * @ClassName: DlServiceImp
 * @Description: DlService�ӿڵ�ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class DlServiceManage implements DlService {
	private DlDao dlDao;

	/**
	 * 
	 * @Title: getDlDao
	 * @Description: dlDao��getter����
	 * @param @return ����
	 * @return DlDao ��������
	 * @throws
	 */
	public DlDao getDlDao() {
		return dlDao;
	}

	/**
	 * 
	 * @Title: setDlDao
	 * @Description: dlDao��setter����
	 * @param @param dlDao ����
	 * @return void ��������
	 * @throws
	 */
	public void setDlDao(DlDao dlDao) {
		this.dlDao = dlDao;
	}

	@Override
	public Dlb find(String xh, String kl) {// ����ѧ�źͿ������
		// TODO Auto-generated method stub
		return dlDao.find(xh, kl);
	}

	@Override
	public List findAll(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		return dlDao.findAll(pageNow, pageSize);
	}

	@Override
	public int findDlSize() {
		// TODO Auto-generated method stub
		return dlDao.findDlSize();
	}

	@Override
	public void delete(String xh) {
		// TODO Auto-generated method stub
		dlDao.delete(xh);
	}

	@Override
	public void update(Dlb dl) {
		// TODO Auto-generated method stub
		dlDao.update(dl);
	}

	@Override
	public void save(Dlb dl) {
		// TODO Auto-generated method stub
		dlDao.save(dl);
	}

	@Override
	public Dlb find1(String xh) {
		// TODO Auto-generated method stub
		return dlDao.find1(xh);
	}

}
