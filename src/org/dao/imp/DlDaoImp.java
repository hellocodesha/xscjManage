package org.dao.imp;

import java.util.Iterator;
import java.util.List;

import org.dao.BaseDAO;
import org.dao.DlDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Dlb;
import org.model.Xsb;

/**
 * 
 * @ClassName: DlDaoImp
 * @Description: ϵͳ��¼Dao��ʵ����
 * @author litengbin
 * @date 2017��6��11��
 * 
 */
public class DlDaoImp extends BaseDAO implements DlDao {
	// ʵ�֣�����ѧ�źͿ������
	@Override
	public Dlb find(String xh, String kl) {
		// TODO Auto-generated method stub
		// ��ѯDLB���еļ�¼
		Session session = null;
		Transaction ts = null;
		Dlb user = null;
		try {
			String hql = "from Dlb u where u.xsb.xh= ? and u.kl = ?";
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, xh);
			query.setParameter(1, kl);
			List users = query.list();
			Iterator it = users.iterator();
			while (it.hasNext()) {
				if (users.size() != 0) {
					user = (Dlb) it.next();// �����־û���JavaBean����user
				}
			}
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
		return user;
	}

	@Override
	public List findAll(int pageNow, int pageSize) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		List list = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Dlb order by xh");
			int firstResult = (pageNow - 1) * pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			list = query.list();
			ts.commit();
		} catch (Exception e) {
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
	public int findDlSize() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		int xsSize = 0;
		try {
			session = getSession();
			ts = session.beginTransaction();
			xsSize = session.createQuery("from Dlb").list().size();
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
		return xsSize;
	}

	@Override
	public void delete(String xh) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Dlb dl = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			dl = find1(xh);
			session.delete(dl);
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
	public void update(Dlb dl) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.update(dl);
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
	public void save(Dlb dl) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.save(dl);
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
	public Dlb find1(String xh) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Dlb dl = null;
		try {
			session = getSession();
			ts = session.beginTransaction();
			Query query = session.createQuery("from Dlb where xh = ?");
			query.setParameter(0, xh);
			query.setMaxResults(1);
			dl = (Dlb) query.uniqueResult();
			ts.commit();
			session.clear();
		} catch (Exception e) {
			// TODO: handle exception
			if (ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dl;
	}
}
