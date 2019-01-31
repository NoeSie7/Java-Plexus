package com.mkyong.common;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.mkyong.common.Stock;

public final class HQLQueries {
	
	public static Stock SelectHQL(Session session){	
		Query query = session.createQuery("from Stock where stockCode = :code ");
		query.setParameter("code", "4715");
		Stock stock = (Stock) query.getSingleResult();
		return stock;
	}
	
	public static int UpdateHQL(Session session){	
		Query query = session.createQuery("update Stock set stockName = :stockName" +
				" where stockCode = :stockCode");
		query.setParameter("stockName", "PRUEBA");
		query.setParameter("stockCode", "4715");
		int result = query.executeUpdate();
		return result;
	}
	
	public static int DeleteHQL(Session session){	
		Query query = session.createQuery("delete Stock where stockCode = :stockCode");
		query.setParameter("stockCode", "4715");
		int result = query.executeUpdate();
		return result;
	}
	
	public static int InsertHQL(Session session){	
		Query query = session.createQuery("insert into Stock (stockId, stockCode, stockName)" +
    			" values (:stock_id, :stock_code, :stock_name)");
		query.setParameter(":stock_id", 2);
		query.setParameter(":stock_code", "4715");
		query.setParameter(":stock_name", "GENM");
		int result = query.executeUpdate();
		return  result;
	}
	
}
