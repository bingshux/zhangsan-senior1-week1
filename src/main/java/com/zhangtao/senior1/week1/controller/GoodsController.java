package com.zhangtao.senior1.week1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhangtao.senior1.week1.domain.Brand;
import com.zhangtao.senior1.week1.domain.Goods;
import com.zhangtao.senior1.week1.domain.GoodsKind;
import com.zhangtao.senior1.week1.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("selectGoods")
	public String selectGoods(Goods goods,@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "3")int pageSize,Model m) {
		
		PageInfo<Goods> info =goodsService.selectGoods(goods,pageNum,pageSize);
		m.addAttribute("g", goods);
		m.addAttribute("info", info);
		
		return "goodsList";
	}
	//去添加页面
	@GetMapping("/add")
	public String add() {
		return "goodsAdd";
	}
	//查找所有的品牌
	@PostMapping("selectBrands")
	@ResponseBody
	public List<Brand> selectBrands(){
		return goodsService.selectBrands();
	}
	
	//查所有种类
	@PostMapping("selectGoodskinds")
	@ResponseBody
	public List<GoodsKind> selectGoodskinds(){
		return goodsService.selectGoodskinds();
	}
	//添加数据
	@PostMapping("add")
	@ResponseBody
	public boolean add(Goods goods,MultipartFile file) throws IllegalStateException, IOException {
		if(file!=null&& !file.isEmpty()) {
			String path="D:\\io3\\";
			String oldFileName = file.getOriginalFilename();
			String fileName=UUID.randomUUID()+oldFileName.substring(oldFileName.lastIndexOf("."));
			
			File file2 = new File(path+fileName);
			file.transferTo(file2);
			goods.setPic("/io3/"+fileName);
		}
			
			return goodsService.add(goods)>0;
	}

	//详情查询
	@RequestMapping("/xiangqing")
	
	public String selectOne(@RequestParam("gid")Integer gid,Model m) {
		System.out.println(gid+"aaaaaaaaaaaaaaaaaa");
		List<Goods> list = goodsService.selectOne(gid);
		m.addAttribute("list", list);
		return "xiangqing";
				
	}
	//删除
	@RequestMapping("delOne")
	@ResponseBody
	public boolean delOne(int gid) {
		return goodsService.delOne(gid)>0;
	}
	//批量删除
	@RequestMapping("delAll")
	@ResponseBody
	public boolean delAll(@RequestParam("gid")int[] gid) {
		
		return goodsService.delAll(gid)>0;
	}
	//回显
	@RequestMapping("toUpdate")
	public String toUpdate(Model m, @RequestParam("gid")int gid) {
		Goods g = goodsService.toUpdate(gid);
		m.addAttribute("g", g);
		return "update";
	}
	//修改
	@RequestMapping("update")
	@ResponseBody
	public boolean update(Goods goods,MultipartFile file) throws IllegalStateException, IOException {
		if(file!=null&& !file.isEmpty()) {
			String path="D:\\io3\\";
			String oldFileName = file.getOriginalFilename();
			String fileName=UUID.randomUUID()+oldFileName.substring(oldFileName.lastIndexOf("."));
			
			File file2 = new File(path+fileName);
			file.transferTo(file2);
			goods.setPic("/io3/"+fileName);
		}
			
			return goodsService.update(goods)>0;
	}

}
