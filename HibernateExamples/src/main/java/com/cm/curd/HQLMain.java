package com.cm.curd;

import java.util.Iterator;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HQLMain {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		String hql = "FROM UserDetail";
		/*Query<UserDetail> query = session.createQuery(hql);
		
		for(UserDetail user : query.list()) {
			System.out.println("UserNo:"+user.getUserNo() +"   FirstName: "+user.getFirstname());
		}*/
		
		//Pagination
		hql = "FROM UserDetail user WHERE user.userNo > 0";
		Query<UserDetail> query2 = session.createQuery(hql);
		Iterator itr = query2.iterate();
		while(itr.hasNext()) {
			UserDetail user = (UserDetail) itr.next();
			System.out.println("UserNo:"+user.getUserNo() +"   FirstName: "+user.getFirstname()+"    LastName: "+user.getLastName());
		}
		
		
		
		System.out.println("\n \n Typed Query.................");
		TypedQuery<UserDetail> typedQuery = session.createQuery(hql);
		typedQuery.setFirstResult(2);
		typedQuery.setMaxResults(2);
		for(UserDetail user : typedQuery.getResultList()) {
			System.out.println("UserNo:"+user.getUserNo() +"   FirstName: "+user.getFirstname()+"    LastName: "+user.getLastName());
		}
		
		
		
		System.out.println("\n \n Parameterise query..............");
		
		hql = "FROM UserDetail user where user.firstname= :name";
		TypedQuery<UserDetail> typedQuery2 = session.createQuery(hql);
		typedQuery2.setParameter("name", "chinmaya");
		for(UserDetail user : typedQuery2.getResultList()) {
			System.out.println("UserNo:"+user.getUserNo() +"   FirstName: "+user.getFirstname()+"    LastName: "+user.getLastName());
		}
		System.out.println("\n \n Named Query..............");
		
		System.out.println("\n \n Named Query......getAllUsers........");
		typedQuery2 = session.getNamedQuery("getAllUsers");
		for(UserDetail user : typedQuery2.getResultList()) {
			System.out.println("UserNo:"+user.getUserNo() +"   FirstName: "+user.getFirstname()+"    LastName: "+user.getLastName());
		}
		
		System.out.println("\n \n Named Query......getUserByUsername........");
		typedQuery2 = session.getNamedQuery("getUserByUsername");
		typedQuery2.setParameter("username", "chinmayak");
		for(UserDetail user : typedQuery2.getResultList()) {
			System.out.println("UserNo:"+user.getUserNo() +"   FirstName: "+user.getFirstname()+"    LastName: "+user.getLastName());
		}
		session.close();
		factory.close();
		
	}

}
