package ksmart.mybatis.goods.service;

import ksmart.mybatis.goods.dto.Goods;
import ksmart.mybatis.goods.mapper.GoodsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class GoodsService {
    private final GoodsMapper goodsMapper;

    public void addGoods(Goods goods) {
        log.info("등록 전 goods:{}", goods);
        goodsMapper.addGoods(goods);
        String goodsCode = goods.getGoodsCode();
        log.info("등록 후 goods:{}", goods);
    }

    public List<Goods> getGoodsList() {
        return goodsMapper.getGoodsList();
    }
}
