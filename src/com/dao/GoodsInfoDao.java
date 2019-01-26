package com.dao;

import java.util.List;

import com.beans.GoodsInfo;

public interface GoodsInfoDao {
	public List<GoodsInfo> findGoodsInfosByStatus(int status);
}
