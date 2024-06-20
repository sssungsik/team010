package ksmart.mybatis.goods.controller;

import java.util.List;

import ksmart.mybatis.goods.service.GoodsService;
import ksmart.mybatis.member.dto.Member;
import ksmart.mybatis.member.mapper.MemberMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.mybatis.goods.dto.Goods;
import ksmart.mybatis.goods.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/goods")
public class GoodsController {
	
	private final GoodsMapper goodsMapper;
	private final MemberMapper memberMapper;
	private final GoodsService goodsService;


	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {

		goodsService.addGoods(goods);
		return "redirect:/goods/goodsList";
	}


	@GetMapping("/addGoods")
	public String addGoods(Model model) {

		List<Member> sellerList = memberMapper.getSellerList();
		model.addAttribute("title", "상품등록");
		model.addAttribute("sellerList", sellerList);

		return "admin/goods/addGoods";
	}
	
	@GetMapping("/goodsList")
	public String getGoodsList(Model model) {
		
		List<Goods> goodsList = goodsMapper.getGoodsList();
		
		log.info("goodsList: {}", goodsList);
		
		model.addAttribute("title", "상품목록조회");
		model.addAttribute("goodsList", goodsList);
		
		return "admin/goods/goodsList";
	}
	

}











