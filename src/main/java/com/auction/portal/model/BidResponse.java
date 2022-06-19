package com.auction.portal.model;

import java.util.List;

import com.auction.portal.entity.BidEntity;

import lombok.Data;

@Data
public class BidResponse extends SuccessResponse {

	private String id;
	private List<BidEntity> bidDetails;
	private BidEntity bidDetail;
	
}
