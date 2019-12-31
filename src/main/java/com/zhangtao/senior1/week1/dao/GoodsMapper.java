package com.zhangtao.senior1.week1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangtao.senior1.week1.domain.Brand;
import com.zhangtao.senior1.week1.domain.Goods;
import com.zhangtao.senior1.week1.domain.GoodsKind;

public interface GoodsMapper {
//查询列表
	List<Goods> selectGoods(Goods goods);

	List<Brand> selectBrands();

	List<GoodsKind> selectGoodskinds();

	int add(Goods goods);

	List<Goods> selectOne(@Param("gid")Integer gid);
	@Delete("delete from  tb_goods  where gid=#{gid}")
	int delOne(@Param("gid")int gid);
	
	int delAll(@Param("gid")int[] gid);
	@Select("select * from tb_goods where gid =#{gid}")
	Goods toUpdate(int gid);
	@Update("update tb_goods set gname=#{gname},ename=#{ename},bid=#{bid},kid=#{kid},size=#{size},price=#{price},num=#{num},tab=#{tab},pic=#{pic} where gid=#{gid}")
	int update(Goods goods);
	
}
