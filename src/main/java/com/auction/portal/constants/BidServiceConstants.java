package com.auction.portal.constants;

public class BidServiceConstants {

	public static final String BID_MGMT_CONTROLLER = "BID MANAGEMENT CONTROLLER";
	public static final String API_CONTEXT_ROOT = "/e-auction/api/v1";
	public static final String SAVE_PRODUCT_BID_URI = "/bid/add-bid";
	public static final String DELETE_BID_BY_ID_URI = "/bid/delete/{bidid}";
	public static final String DELETE_BID_BY_PRODUCTID_URI = "/bid/delete/product/{productid}";
	public static final String FETCH_ALL_BIDS_URI = "/bid/show-bids";
	public static final String FETCH_ALL_LATEST_BIDS_URI = "/bid/show-bids/latest";
	public static final String FETCH_BIDS_BY_ID_URI = "/bid/show-bid/{bidid}";
	public static final String FETCH_BID_BY_PRODUCTID_URI = "/bid/show-bids/product/{productid}";
	public static final String FETCH_LATEST_BID_BY_PRODUCTID_URI = "/bid/show-bids/latest/product/{productid}";
//	public static final String FETCH_STOCK_BY_RANGE_URI = "/get/stock/{companycde}/{startdate}/{enddate}";

}
