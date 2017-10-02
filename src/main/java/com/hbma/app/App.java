package com.hbma.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbma.util.SessionUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session = SessionUtil.openSession();
        Transaction tx = null;
        try{
        	tx = session.getTransaction();
        	Stock stk = new Stock("1114", "VODA");
        	session.save(stk);
        }catch(Exception e){
        	if(tx!=null)tx.rollback();
        	e.printStackTrace();
        }finally {
			SessionUtil.closeSession(session);
		}
    }
}
