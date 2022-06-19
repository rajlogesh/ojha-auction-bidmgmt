package com.auction.portal.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.auction.portal.entity.BidEntity;

public interface BidMgmtRepository extends MongoRepository<BidEntity, String> {

	@Query(value = "{'productId' : '?0'}", delete = true)
	public void deleteByProductId(String productId);

	@Query(value = "{'productId' : '?0'}")
	public List<BidEntity> findBidsByProductId(String productId);

	@Query(value = "{'productId' : '?0'}")
	public List<BidEntity> findLatestBidsByProductId(String productId);

	//public List<BidEntity> findAllLatestBids();
}
