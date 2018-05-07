package com.cm.curd;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CurdMain {

	static SessionFactory sessionFactory = null;
	public static void main(String[] args) {
		sessionFactory = HibernateUtil.getSessionFactory();
		CurdMain main = new CurdMain();
		main.addUser(null);
		/*main.getUsers(null);
		main.getUserByIdUsingLoad(1,null);
		main.updateUser(2,null);
		main.getUserByIdUsingLoad(2,null);
		main.getUserByIdUsingGet(2,null);
		
		System.out.println("\n \n ---------Using Single session----------");
		Session session = sessionFactory.openSession();
		main.getUsers(session);
		main.getUserByIdUsingLoad(1,session);
		main.updateUser(2,session);
		main.getUserByIdUsingLoad(2,session);
		main.getUserByIdUsingGet(2,session);
		session.close();*/
		
		sessionFactory.close();
		
	}
	
	public void addUser(Session argsession) {
		Session session = argsession;
		if(session == null) {
			session = sessionFactory.openSession();
		}else
			session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetail userDetail = new UserDetail();
		Scanner scanner = new Scanner(System.in);
		System.out.print("First name: ");
		userDetail.setFirstname(scanner.nextLine());
		System.out.print("Last name: ");
		userDetail.setLastName(scanner.nextLine());
		System.out.print("Username: ");
		userDetail.setUsername(scanner.nextLine());
		System.out.print("Password: ");
		userDetail.setPassword(scanner.nextLine());
		
		session.save(userDetail);
		session.getTransaction().commit();
		if(argsession == null)
			session.close();
		
	}
	
	public void getUsers(Session argsession) {
		Session session = argsession;
		if(session == null) {
			session = sessionFactory.openSession();
		}else
			session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetail");
		List<UserDetail> userList = query.list();
		for(UserDetail user: userList) {
			System.out.println("UserNo:"+user.getUserNo() +"   UserName: "+user.getUsername());
		}
		
		if(argsession == null)
			session.close();
	}
	
	public void getUserByIdUsingLoad(int id,Session argsession) {
		Session session = argsession;
		if(session == null) {
			session = sessionFactory.openSession();
		}else
			session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetail user = (UserDetail) session.load(UserDetail.class, id);
		System.out.println("UserNo:"+user.getUserNo() +"   UserName: "+user.getUsername());
		if(argsession == null)
			session.close();
	}
	
	public void getUserByIdUsingGet(int id,Session argsession) {
		Session session = argsession;
		if(session == null) {
			session = sessionFactory.openSession();
		}else
			session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetail user = (UserDetail) session.get(UserDetail.class, id);
		System.out.println("UserNo:"+user.getUserNo() +"   UserName: "+user.getUsername());
		if(argsession == null)
			session.close();
	}
	
	public void updateUser(int id,Session argsession) {
		Session session = argsession;
		if(session == null) {
			session = sessionFactory.openSession();
		}else
			session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetail user = (UserDetail) session.load(UserDetail.class, id);
		System.out.println("-----------Update----------");
		System.out.println("UserNo:"+user.getUserNo() +"   UserName: "+user.getUsername());
		
		user.setFirstname("Balaram");
		user.setLastName("Sahoo");
		user.setUsername("balarams");
		user.setPassword("balarams");
		
		session.update(user);
		session.getTransaction().commit();
		if(argsession == null)
			session.close();
		
	}

}
