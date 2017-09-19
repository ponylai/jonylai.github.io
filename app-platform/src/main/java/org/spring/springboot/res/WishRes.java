package org.spring.springboot.res;

import java.util.List;

import org.spring.springboot.domain.Wish;

public class WishRes extends BaseRes{
	private List<Wish> wishList;
	private Wish wish;

	public List<Wish> getWishList() {
		return wishList;
	}

	public void setWishList(List<Wish> wishList) {
		this.wishList = wishList;
	}

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

}
