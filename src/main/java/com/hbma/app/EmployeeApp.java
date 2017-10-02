package com.hbma.app;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbma.util.SessionUtil;

public class EmployeeApp {
public static void main(String[] args) {
	Session session = SessionUtil.openSession();
	Transaction tx = null;
	try{
		tx=session.getTransaction();
		String hql = "FROM Employee e Where e.empNo BETWEEN :empNo1 AND :empNo2";
		
		TypedQuery<Employee> query = session.createQuery(hql).setParameter("empNo1", 10001).setParameter("empNo2",100001);
		List<Employee> list = query.getResultList();
		for(Employee emp : list){
			//System.out.println(emp.getEmpNo()+" "+emp.getFirstName()+" "+emp.getLastName()+" "+emp.getDateOfBirth());
		}
		System.out.println(list.size());
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		SessionUtil.closeSession(session);
	}
}
}
