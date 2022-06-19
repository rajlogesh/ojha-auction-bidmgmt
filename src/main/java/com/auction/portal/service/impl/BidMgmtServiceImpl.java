package com.auction.portal.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.auction.portal.dao.BidMgmtRepository;
import com.auction.portal.entity.BidEntity;
import com.auction.portal.model.BidRequest;
import com.auction.portal.model.BidResponse;
import com.auction.portal.service.BidMgmtService;
import com.auction.portal.util.BidDetailsMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BidMgmtServiceImpl implements BidMgmtService{

	@Autowired
	MongoTemplate mongo;
	
	@Autowired
	BidDetailsMapper mapper;
	
	@Autowired
	BidMgmtRepository repository;
	
	@Override
	public BidResponse saveProductBid(BidRequest request) {
		logger.info("Inside Service");
		BidEntity entity = mapper.bidDetailsRequestMapper(request);
		BidEntity result  = repository.save(entity);
		BidResponse response = new BidResponse();
		logger.info("Data saved with bid id: {}", result.getId());
		response.setResponseID("123456");
		response.setResponseMsg("Data saved succefully");
		return response;
	}

	@Override
	public BidResponse deleteBidByProductId(String productId) {
		logger.info("Inside Service");
		repository.deleteByProductId(productId);
		BidResponse response = new BidResponse();
		logger.info("Data deleted for the bid id: {}", productId);
		response.setResponseID("123456");
		response.setResponseMsg("Data deleted succefully");
		return response;
	}

	@Override
	public BidResponse deleteBidById(String bidId) {
		logger.info("Inside Service");
		repository.deleteById(bidId);
		BidResponse response = new BidResponse();
		response.setResponseID("123456");
		response.setResponseMsg("Data deleted succefully");
		return response;
	}

	@Override
	public BidResponse getAllBids() {
		logger.info("Inside Service");
		List<BidEntity> result  = repository.findAll();
		BidResponse response = new BidResponse();
		response.setBidDetails(result);
		response.setResponseID("123456");
		response.setResponseMsg("Data fetched succefully");
		return response;
	}

	@Override
	public BidResponse getBidById(String bidId) {
		logger.info("Inside Service");
		BidEntity result  = repository.findById(bidId).orElseThrow(() -> new RuntimeException());
		BidResponse response = new BidResponse();
		logger.info("Data saved with bid id: {}", result.getId());
		response.setBidDetail(result);
		response.setResponseID("123456");
		response.setResponseMsg("Data fetched succefully");
		return response;
	}

	@Override
	public BidResponse getBidByProductId(String productId) {
		logger.info("Inside Service");
		List<BidEntity> result  = repository.findBidsByProductId(productId);
		BidResponse response = new BidResponse();
		response.setBidDetails(result);
		response.setResponseID("123456");
		response.setResponseMsg("Data fetched succefully");
		return response;
	}

	@Override
	public BidResponse getAllLatestBids() {
		logger.info("Inside Service");
		List<BidEntity> result  = repository.findAll();
		BidResponse response = new BidResponse();
		response.setBidDetails(result);
		response.setResponseID("123456");
		response.setResponseMsg("Data fetched succefully");
		return response;
	}

	@Override
	public BidResponse getLatestBidsByProductId(String productId) {
		logger.info("Inside Service");
		List<BidEntity> bids  = repository.findBidsByProductId(productId);
		Comparator<BidEntity> comparator = Comparator.comparing(BidEntity::getBidUpdtTms);
		BidEntity bid = bids.stream().filter(s->s.getBidUpdtTms() != null).max(comparator).get();
		List<BidEntity> list = new ArrayList<>();
		list.add(bid);
		BidResponse response = new BidResponse();
		response.setBidDetails(list);
		response.setResponseID("123456");
		response.setResponseMsg("Data fetched succefully");
		return response;
	}

}
