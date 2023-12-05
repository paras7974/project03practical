package com.rays.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDto;
import com.rays.util.HibDataSource;

public class UserModelHibImp implements UserModelInt {

	public long add(UserDto dto) throws Exception {

		System.out.println("step3");

		Session session = HibDataSource.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			System.out.println("trac");
			session.save(dto);
			System.out.println("trac1");
			dto.getId();
			System.out.println("trac3");
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			// throw new ApplicationException("Exception in User Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();

	}

	public UserDto authenticate(String login, String password) {

		UserDto dto = null;
		Session session = HibDataSource.getSession();

		Query q = session.createQuery("from UserDto where login =  ? and password = ?");

		q.setString(0, login);
		q.setString(1, password);

		List list = q.list();

		if (list.size() > 0) {
			dto = (UserDto) list.get(0);
			return dto;
		} else {
			return null;
		}

	}

	public List search(UserDto dto, int pageNo, int pageSize) throws Exception {

		Session session = null;

		ArrayList<UserDto> list = null;

		session = HibDataSource.getSession();

		Criteria criteria = session.createCriteria(UserDto.class);

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {

				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));

			}
			   if (dto.getFirstName() != null && dto.getLastName().length() > 0) {

				    criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			   }
		}
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list = (ArrayList<UserDto>) criteria.list();

		session.close();

		return list;

	}

	public void delete(UserDto dto) throws Exception {

		Session session = null;
		Transaction tx = null;

		session = HibDataSource.getSession();
		tx = session.beginTransaction();
		session.delete(dto);
		tx.commit();
		if (tx != null) {
			tx.rollback();

			session.close();
		}
	}

	public UserDto findByPk(int pk) throws Exception {

		Session session = null;
		UserDto dto = null;

		try {

			session = HibDataSource.getSession();
			dto = (UserDto) session.get(UserDto.class, pk);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}

	public void update(UserDto dto) {

		Session session = null;
		Transaction tx = null;

		session = HibDataSource.getSession();

		try {
			tx = session.beginTransaction();
			session.update(dto);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			System.out.println("Rollback in usermodel");
		}
		session.close();

	}

}
