package org.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @ClassName: BaseDAO
 * @Description: ����
 * @author litengbin
 * @date 2017��6��11��
 * 
 */
public class BaseDAO {
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @Title: getSessionFactory
	 * @Description: sessionFactory��getter����
	 * @param @return ����
	 * @return SessionFactory ��������
	 * @throws
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 
	 * @Title: setSessionFactory
	 * @Description: sessionFactory��setter����
	 * @param @param sessionFactory ����
	 * @return void ��������
	 * @throws
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @Title: getSession
	 * @Description: ���session�Ự����
	 * @param @return ����
	 * @return Session ��������
	 * @throws
	 */
	public Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}
}
