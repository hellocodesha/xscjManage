package org.service.imp;

import java.util.List;

import org.dao.CjDao;
import org.dao.XsDao;
import org.model.Xsb;
import org.service.XsService;

/**
 * 
 * @ClassName: XsServiceManage
 * @Description: XsService��ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class XsServiceManage implements XsService {
	private XsDao xsDao;
	private CjDao cjDao;

	/**
	 * 
	 * @Title: getCjDao
	 * @Description: cjDao��getter����
	 * @param @return ����
	 * @return CjDao ��������
	 * @throws
	 */
	public CjDao getCjDao() {
		return cjDao;
	}

	/**
	 * 
	 * @Title: setCjDao
	 * @Description: cjDao��setter����
	 * @param @param cjDao ����
	 * @return void ��������
	 * @throws
	 */
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}

	/**
	 * 
	 * @Title: getXsDao
	 * @Description: xsDao��getter����
	 * @param @return ����
	 * @return XsDao ��������
	 * @throws
	 */
	public XsDao getXsDao() {
		return xsDao;
	}

	/**
	 * 
	 * @Title: setXsDao
	 * @Description: xsDao��setter����
	 * @param @param xsDao ����
	 * @return void ��������
	 * @throws
	 */
	public void setXsDao(XsDao xsDao) {
		this.xsDao = xsDao;
	}

	@Override
	public List findAll(int pageNow, int pageSize) {// ��ʾ����ѧ����Ϣ
		// TODO Auto-generated method stub
		return xsDao.findAll(pageNow, pageSize);
	}

	@Override
	public int findXsSize() {// ��ѯһ��������ѧ����¼
		// TODO Auto-generated method stub
		return xsDao.findXsSize();
	}

	@Override
	public Xsb find(String xh) {// ����ѧ�Ų�ѯĳѧ����Ϣ
		// TODO Auto-generated method stub
		return xsDao.find(xh);
	}

	@Override
	public void delete(String xh) {// ����ѧ��ɾ��ѧ��
		// TODO Auto-generated method stub
		xsDao.delete(xh);
		// cjDao.deleteOneXsCj(xh);
	}

	@Override
	public void update(Xsb xs) {// �޸�ѧ����Ϣ
		// TODO Auto-generated method stub
		xsDao.update(xs);
	}

	@Override
	public void save(Xsb xs) {// ����ѧ����Ϣ
		// TODO Auto-generated method stub
		xsDao.save(xs);
	}

	@Override
	public void updateXf(int xf, List list) {
		// TODO Auto-generated method stub
		xsDao.updateXf(xf, list);
	}

}
