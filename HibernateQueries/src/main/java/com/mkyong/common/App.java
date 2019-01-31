package com.mkyong.common;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mkyong.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args ){
        System.out.println("Maven + Hibernate + PostgreSQL");
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tx = null;

        try{
        	tx = session.beginTransaction();
        	tx.setTimeout(5);

        	/* HQL Queries */
            HQLQueries(session);

        	tx.commit();
        }catch(RuntimeException e){
        	try{
        		tx.rollback();
        	}catch(RuntimeException rbe){
        		System.out.println("Couldn’t roll back transaction");
        	}
        	throw e;
        }
//        finally{
//        	if(session!=null){
//        		session.close();
//        	}
//        }
        
     
        
        /* 	Criteria Queries */
        CriteriaQueries(session);
        
        /* NativeSQL Queries */
        NativeSQLQueries(session);
        
        /* Named Queries */
        NamedQueries(session);
    }
    
    private static void NamedQueries(Session session) {
    	System.out.println("Consultas de NamedQueries: ");
    	Stock stock = NamedQueries.NamedQuerySelect(session);
    	if (stock != null){
      		System.out.println(printStock(stock));
        }else{
          	System.out.println("No hay stock con el código 4715");
        }
	}

	private static void NativeSQLQueries(Session session) {
		System.out.println("Consultas de NativeSQLQueries: ");
    	String stockCode = NativeSQLQueries.NativeQuerySelect(session);
    	if (!stockCode.isEmpty()){
        	System.out.println("El código recuperado es: " + stockCode);
        }else{
        	System.out.println("No hay stock con el código 4715");
        }
	}

	private static void CriteriaQueries(Session session){
		System.out.println("Consultas de CriteriaQueries: ");
		Stock stock = CriteriaQueries.CriteriaQuerySelect(session);
		if (stock != null){
    		System.out.println(printStock(stock));
        }else{
        	System.out.println("No hay stock con el código 4715");
        }
    }
    
    private static void HQLQueries(Session session){
    	System.out.println("Consultas de HQLQueries: ");
//    	int result = HQLQueries.DeleteHQL(session);
//      if (result == 0){
//        	System.out.println("Error al borrar");
//        }else{
//        	System.out.println("Borrado correcto");
//        }
//        
//        result = HQLQueries.InsertHQL(session);
//        if (result == 0){
//        	System.out.println("Error al insertar");
//        }else{
//        	System.out.println("Inserción correcta");
//        }
        
        String name = "PRUEBA";
        int result = HQLQueries.UpdateHQL(session);
        if (result == 0){
        	System.out.println("Error al actualizar");
        }else{
        	System.out.println("Actualización correcta");
        } 
         
        Stock stock = HQLQueries.SelectHQL(session);
        if (stock != null){
    		System.out.println(printStock(stock));
        }else{
        	System.out.println("No hay stock con el código 4715");
        }
    }
    
	private static String printStock(Stock stock){
		String textStock = "";
		textStock += "Stock id: " + stock.getStockId();
		textStock += "\nStock code: " + stock.getStockCode();
		textStock += "\nStock name: " + stock.getStockName();
		return textStock;
	}
}
