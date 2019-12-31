package com.zhangtao.senior1.week1.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangtao.senior1.week1.domain.Brand;
import com.zhangtao.senior1.week1.domain.Goods;
import com.zhangtao.senior1.week1.domain.GoodsKind;

public interface GoodsService {

	PageInfo selectGoods(Goods goods, int pageNum, int pageSize);

	List<Brand> selectBrands();

	List<GoodsKind> selectGoodskinds();

	int add(Goods goods);

	List<Goods> selectOne(Integer gid);

	int delOne(int gid);

	int delAll(int[] gid);

	Goods toUpdate(int gid);

	int update(Goods goods);
	
}
