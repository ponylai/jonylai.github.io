package org.spring.springboot.service;

import org.spring.springboot.domain.Wish;

import java.util.List;

/**
 * 城市业务逻辑接口类
 *
 * Created by jony.lai on 07/02/2017.
 */
public interface WishService {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<Wish> findAllWish();

    /**
     * 根据城市 ID,查询城市信息
     *
     * @param id
     * @return
     */
    Wish findWishById(Long id);

    /**
     * 新增城市信息
     *
     * @param city
     * @return
     */
    Long saveWish(Wish wish);

    /**
     * 更新城市信息
     *
     * @param city
     * @return
     */
    Long updateWish(Wish wish);

    /**
     * 根据城市 ID,删除城市信息
     *
     * @param id
     * @return
     */
    Long deleteWish(Long id);
}
