package com.auction.portal.model;

import lombok.Data;

@Data
public class BidRequest {

	private String productId;
	private String userId;
	private Double bidAmount;

}
