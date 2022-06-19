package com.auction.portal.service;

import com.auction.portal.model.BidRequest;
import com.auction.portal.model.BidResponse;

public interface BidMgmtService {

	public BidResponse saveProductBid(BidRequest request);

	public BidResponse deleteBidByProductId(String ProductId);

	public BidResponse deleteBidById(String bidId);

	public BidResponse getAllBids();

	public BidResponse getBidById(String bidId);

	public BidResponse getBidByProductId(String ProductId);

	public BidResponse getAllLatestBids();

	public BidResponse getLatestBidsByProductId(String ProductId);

}
