package com.hbma.app.thread;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hbma.app.Emps;
import com.hbma.util.SessionFactoryUtil;
import com.hbma.util.SessionUtil;

public class RunnableThread implements Runnable{

	private String name;
	
	public RunnableThread(String threadName) {
		this.name = threadName;
	}
	
	public void run() {
		System.out.println("Thread running ."+this.name);
		int i = 0;
		
		while(i<3){
			try {
			deleteFromTable();
			i++;
			Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("run over "+i+" "+this.name);
		return;
	}
	
	private void deleteFromTable(){
		Session session = SessionUtil.openSession();
		try{
		Transaction tx = session.beginTransaction();
		String hql = "FROM Emps as emps ORDER BY emps.hireDate";
		Query<Emps> qry = session.createQuery(hql);
		qry.setMaxResults(1);
		List<Emps> rs = qry.getResultList();
		Integer emp_no = rs.get(0).getEmpNo();
		System.out.println("***********************************************************");
		System.out.println(this.name+" is deleting record : "+rs.get(0));
		System.out.println("***********************************************************");
		String hql2 = "DELETE Emps as emps where emps.empNo = :empNo";
		Query<Emps> qry2 = session.createQuery(hql2);
		qry2.setParameter("empNo", emp_no);
		int status = qry2.executeUpdate();
		if(status == 1){
			System.out.println(status);
		}else{
			System.out.println("Re-execute delete in thread "+this.name+" for no line was deletted");
			deleteFromTable();
		}
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			SessionUtil.closeSession(session);
		}
		return;
	}
	
	

}
