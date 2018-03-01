package org.dao.imp;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.KcDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Kcb;

/**
 * 
 * @ClassName: KcDaoImp
 * @Description: �γ�dao��ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class KcDaoImp extends BaseDAO implements KcDao {

	@Override
	public List findAll(int pageNow, int pageSize) {// ��ѯ���пγ���Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from  Kcb");
			int firstResult = (pageNow - 1) * pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			list = query.list();
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int findKcSize() {// ��ѯһ���������γ̼�¼
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		int kcSize = 0;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Kcb");
			List list = query.list();
			kcSize = list.size();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kcSize;
	}

	@Override
	public Kcb find(String kch) {// ���ݿγ̺Ų��ҿγ���Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Kcb kc = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Kcb where kch = ?");
			query.setParameter(0, kch);
			query.setMaxResults(1);
			kc = (Kcb) query.uniqueResult();
			ts.commit();
			session.clear();// �������
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kc;
	}

	@Override
	public void delete(String kch) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Kcb kc = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			kc = find(kch);
			session.delete(kc);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Kcb kc) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(kc);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void save(Kcb kc) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(kc);
			ts.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
