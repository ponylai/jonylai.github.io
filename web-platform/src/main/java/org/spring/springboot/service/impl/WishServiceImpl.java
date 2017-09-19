package org.spring.springboot.service.impl;


import org.spring.springboot.dao.WishDao;
import org.spring.springboot.domain.Wish;
import org.spring.springboot.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 *
 * Created by jony.lai on 07/02/2017.
 */
@Service
public class WishServiceImpl implements WishService {

    @Autowired
    private WishDao wishDao;

    public List<Wish> findAllWish(){
        return wishDao.findAllWish();
    }

    public Wish findWishById(Long id) {
        return wishDao.findWishById(id);
    }

    public Long saveWish(Wish wish) {
        return wishDao.saveWish(wish);
    }

    public Long updateWish(Wish wish) {
        return wishDao.updateWish(wish);
    }

    public Long deleteWish(Long id) {
        return wishDao.deleteWish(id);
    }

}
