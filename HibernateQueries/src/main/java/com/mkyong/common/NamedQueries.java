package com.mkyong.common;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mkyong.common.Stock;

public final class NamedQueries {
	
	public static Stock NamedQuerySelect(Session session){
		Query query = session.getNamedQuery("findStockByStockCode")
				.setParameter("stockCode", "4715");
		Stock stock = (Stock) query.getSingleResult();
		return stock;
	}
}
