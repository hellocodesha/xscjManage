package org.dao.imp;

import java.util.List;

import org.dao.BaseDAO;
import org.dao.ZyDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Zyb;

/**
 * 
 * @ClassName: ZyDaoImp
 * @Description: רҵDao��ʵ����
 * @author litengbin
 * @date 2017��6��12��
 * 
 */
public class ZyDaoImp extends BaseDAO implements ZyDao {

	@Override
	public Zyb getOneZy(Integer zyId) {// ����רҵID����רҵ��Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Zyb zy = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Zyb where id = ?");
			query.setParameter(0, zyId);
			query.setMaxResults(1);
			zy = (Zyb) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return zy;
	}

	@Override
	public List getAll() {// ��������רҵ��Ϣ
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Zyb");
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

}
