package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Wish;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * Created by jony.lai on 07/02/2017.
 */
public interface WishDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<Wish> findAllWish();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    Wish findWishById(@Param("id") Long id);

    Long saveWish(Wish wish);

    Long updateWish(Wish wish);

    Long deleteWish(Long id);
}
