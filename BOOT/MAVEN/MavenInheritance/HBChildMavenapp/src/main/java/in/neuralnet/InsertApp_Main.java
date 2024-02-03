package in.neuralnet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.neuralnet.Model.Employee;
import in.neuralnet.util.HibernateUtil;

public class InsertApp_Main {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		 boolean flag = true;
		
		 session = HibernateUtil.getSession();
		 
		 if(session !=null)
		 {
			 transaction = session.beginTransaction();
			 {
				 try {
					if(transaction != null)
					 {
						 Employee emp = new Employee();
						 emp.setEmp_id(3);
						 emp.setEmp_name("Sarat");
						 emp.setEmp_sal(76727.8);
						 
						 session.save(emp);
						  flag = true;
					 }
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 finally
				 { 
					 if(flag == true)
					 {
						 transaction.commit();
					 }
					 else
					 {
						 transaction.rollback();
					 }
					 HibernateUtil.closeSession(session);
					 
				 }
			 }
		 }

		 
	}

}
