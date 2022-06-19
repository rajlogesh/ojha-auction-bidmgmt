package com.auction.portal.controller;

import static com.auction.portal.constants.BidServiceConstants.API_CONTEXT_ROOT;
import static com.auction.portal.constants.BidServiceConstants.BID_MGMT_CONTROLLER;
import static com.auction.portal.constants.BidServiceConstants.DELETE_BID_BY_ID_URI;
import static com.auction.portal.constants.BidServiceConstants.DELETE_BID_BY_PRODUCTID_URI;
import static com.auction.portal.constants.BidServiceConstants.FETCH_ALL_BIDS_URI;
import static com.auction.portal.constants.BidServiceConstants.FETCH_ALL_LATEST_BIDS_URI;
import static com.auction.portal.constants.BidServiceConstants.FETCH_BIDS_BY_ID_URI;
import static com.auction.portal.constants.BidServiceConstants.FETCH_BID_BY_PRODUCTID_URI;
import static com.auction.portal.constants.BidServiceConstants.FETCH_LATEST_BID_BY_PRODUCTID_URI;
import static com.auction.portal.constants.BidServiceConstants.SAVE_PRODUCT_BID_URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.portal.model.BidRequest;
import com.auction.portal.model.BidResponse;
import com.auction.portal.service.BidMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = API_CONTEXT_ROOT, produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
		MediaType.APPLICATION_JSON_VALUE })
@Tag(name = BID_MGMT_CONTROLLER)
public class BidMgmtController {

	@Autowired
	BidMgmtService service;

	@Operation(summary = SAVE_PRODUCT_BID_URI, description = "This API is used to save the Bid made by the Buyers on a product")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Bid is made successfully") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping(SAVE_PRODUCT_BID_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> saveProductBid(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@Parameter(name = "BidRequest", description = "Request Body", required = true) @RequestBody BidRequest request) {
		logger.info("Bid Management service started");
		BidResponse response = service.saveProductBid(request);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = DELETE_BID_BY_PRODUCTID_URI, description = "This API is used to delete the bids made on a product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Bids of a product are  deleted successfully") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@DeleteMapping(DELETE_BID_BY_PRODUCTID_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> deleteBidByProductId(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@Parameter(name = "productid", description = "productid", required = true) @PathVariable(name = "productid", required = true) String productId) {
		logger.info("Bid Management service started");
		BidResponse response = service.deleteBidByProductId(productId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = DELETE_BID_BY_ID_URI, description = "This API is used to delete the bid made by the customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Bid deleted successfully") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@DeleteMapping(DELETE_BID_BY_ID_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> deleteBidById(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@Parameter(name = "bidid", description = "BidId", required = true) @PathVariable(name = "bidid", required = true) String bidId) {
		logger.info("Bid Management service started");
		logger.info("Bid Id Passed: {}", bidId);
		BidResponse response = service.deleteBidById(bidId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = FETCH_BID_BY_PRODUCTID_URI, description = "This API is used to fetch all the bids of a product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved bids of a product") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(FETCH_BID_BY_PRODUCTID_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> getBidByProductId(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@Parameter(name = "productid", description = "productid", required = true) @PathVariable(name = "productid", required = true) String productId) {
		logger.info("Bid Management service started");
		BidResponse response = service.getBidByProductId(productId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = FETCH_LATEST_BID_BY_PRODUCTID_URI, description = "This API is used to fetch all the bids of a product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successfully retrieved bids of a product") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(FETCH_LATEST_BID_BY_PRODUCTID_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> getLatestBidsByProductId(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@Parameter(name = "productid", description = "productid", required = true) @PathVariable(name = "productid", required = true) String productId) {
		logger.info("Bid Management service started");
		BidResponse response = service.getLatestBidsByProductId(productId);
		return ResponseEntity.ok(response);
	}

	@Operation(summary = FETCH_ALL_BIDS_URI, description = "This API is used to retreive all bids")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved bids") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(FETCH_ALL_BIDS_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> getAllBids(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken) {
		logger.info("Bid Management service started");
		BidResponse response = service.getAllBids();
		return ResponseEntity.ok(response);
	}

	@Operation(summary = FETCH_ALL_LATEST_BIDS_URI, description = "This API is used to retreive all bids")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved bids") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(FETCH_ALL_LATEST_BIDS_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> getAllLatestBids(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken) {
		logger.info("Bid Management service started");
		BidResponse response = service.getAllLatestBids();
		return ResponseEntity.ok(response);
	}

	@Operation(summary = FETCH_BIDS_BY_ID_URI, description = "This API is used to retreive bid based on ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved bid") })
	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping(FETCH_BIDS_BY_ID_URI)
	@Parameters({ @Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) })
	public ResponseEntity<BidResponse> getBidById(
			@Parameter(name = "HTTP_AUTH_TOKEN", description = "JWT token header", required = false) @RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@Parameter(name = "BidId", description = "bidid", required = true) @PathVariable(name = "bidid", required = true) String bidId) {
		logger.info("Bid Management service started");
		BidResponse response = service.getBidById(bidId);
		return ResponseEntity.ok(response);
	}

}
