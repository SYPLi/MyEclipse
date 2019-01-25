package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.GoodsInfo;
import com.dao.GoodsInfoDao;
import com.dao.impl.GoodsInfoDaoImpl;

/**
 * Servlet implementation class GoodsInfoServlet
 */
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		GoodsInfoDao goodsInfoDao=new GoodsInfoDaoImpl();
		List<GoodsInfo> goodsInfos=null;
		switch (flag) {
		case "1":
			goodsInfos=goodsInfoDao.findGoodsInfosByStatus(1);
			request.setAttribute("status", 1);
			break;
		case "2":
			goodsInfos=goodsInfoDao.findGoodsInfosByStatus(2);
			request.setAttribute("status", 2);
			break;
		}
		request.setAttribute("goodsInfos", goodsInfos);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

}
