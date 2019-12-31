package com.zhangtao.senior1.week1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangtao.senior1.week1.dao.GoodsMapper;
import com.zhangtao.senior1.week1.domain.Brand;
import com.zhangtao.senior1.week1.domain.Goods;
import com.zhangtao.senior1.week1.domain.GoodsKind;
import com.zhangtao.senior1.week1.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public PageInfo selectGoods(Goods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list =goodsMapper.selectGoods(goods);
		return new PageInfo<Goods>(list);
	}

	@Override
	public List<Brand> selectBrands() {
		
		return goodsMapper.selectBrands();
	}

	@Override
	public List<GoodsKind> selectGoodskinds() {
		
		return goodsMapper.selectGoodskinds();
	}

	@Override
	public int add(Goods goods) {
		
		return goodsMapper.add(goods);
	}

	@Override
	public List<Goods> selectOne(Integer gid) {
		return goodsMapper.selectOne(gid);
	}

	@Override
	public int delOne(int gid) {
		
		return goodsMapper.delOne(gid);
	}

	@Override
	public int delAll(int[] gid) {
		int i= goodsMapper.delAll(gid);
		return i;
	}

	@Override
	public Goods toUpdate(int gid) {
		
		return goodsMapper.toUpdate(gid);
	}

	@Override
	public int update(Goods goods) {
		
		return goodsMapper.update(goods);
	}

	
}
