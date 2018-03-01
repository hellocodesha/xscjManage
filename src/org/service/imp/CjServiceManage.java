package org.service.imp;

import java.util.List;

import org.dao.CjDao;
import org.model.Cjb;
import org.service.CjService;

/**
 * 
 * @ClassName: CjServiceManage
 * @Description: CjService��ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class CjServiceManage implements CjService {
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

	@Override
	public Cjb getXsCj(String xh, String kch) {// ����ѧ�úͿγ̺Ų�ѯѧ���ɼ�
		// TODO Auto-generated method stub
		return cjDao.getXsCj(xh, kch);
	}

	@Override
	public void saveorupdateCj(Cjb cj) {// ¼��ѧ���ɼ�
		// TODO Auto-generated method stub
		cjDao.saveorupdateCj(cj);
	}

	@Override
	public List findAll(int pageNow, int pageSize) {// ��ҳ��ʾ����ѧ���ɼ�
		// TODO Auto-generated method stub
		return cjDao.findAllCj(pageNow, pageSize);
	}

	@Override
	public int findCjSize() {// ��ѯһ���������ɼ���¼
		// TODO Auto-generated method stub
		return cjDao.findCjSize();
	}

	@Override
	public List getXsCjList(String xh) {// ��ȡĳѧ���ĳɼ��б�
		// TODO Auto-generated method stub
		return cjDao.getXsCjList(xh);
	}

	@Override
	public void deleteCj(String xh, String kch) {// ����ѧ�úͿγ̺�ɾ��ѧ���ɼ�
		// TODO Auto-generated method stub
		cjDao.deleteCj(xh, kch);
	}

	@Override
	public void deleteOneXsCj(String xh) {// ɾ��ĳѧ���ĳɼ�
		// TODO Auto-generated method stub
		cjDao.deleteOneXsCj(xh);
	}

	@Override
	public void updateKcList(String kch, int xf) {
		// TODO Auto-generated method stub
		cjDao.updateKcList(kch, xf);
	}

	@Override
	public List getXsCjList1(String kch) {
		// TODO Auto-generated method stub
		return cjDao.getXsCjList1(kch);
	}

	@Override
	public void deleteKcList(String kch) {
		// TODO Auto-generated method stub
		cjDao.deleteKcList(kch);
	}
}
