package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.beans.GoodsInfo;
import com.dao.GoodsInfoDao;
import com.utils.DBUtil;

public class GoodsInfoDaoImpl implements GoodsInfoDao {

	@Override
	public List<GoodsInfo> findGoodsInfosByStatus(int status) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<GoodsInfo> goodsInfos=new ArrayList<GoodsInfo>();
		try {
			conn=DBUtil.getConn();
			String sql="select * from letgo where status=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, status);
			rs=ps.executeQuery();
			while (rs.next()) {
				GoodsInfo goodsInfo=new GoodsInfo();
				goodsInfo.setId(rs.getInt("id"));
				goodsInfo.setGoodsName(rs.getString("goodsName"));
				goodsInfo.setGoodsUrl(rs.getString("goodsUrl"));
				goodsInfo.setStatus(status);
				goodsInfos.add(goodsInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, conn, ps);
		}
		return goodsInfos;
	}

}
