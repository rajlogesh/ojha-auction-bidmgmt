package com.auction.portal.util;

import java.util.Date;

import com.auction.portal.entity.BidEntity;
import com.auction.portal.model.BidRequest;

public class BidDetailsMapper {

	public BidEntity bidDetailsRequestMapper(BidRequest request) {
		BidEntity entity = new BidEntity();
		entity.setProductId(request.getProductId());
		entity.setBidAmount(request.getBidAmount());
		entity.setUserId(request.getUserId());
		entity.setBidUpdtTms(new Date());
		return entity;
	}
}
