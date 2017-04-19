package com.xatu.util;

/**
 * 存放个种表的信息，方便修改
 * 
 * @author zsl
 *
 */
public class TableInfo {

	// 表名
	public final static String[] tableName = { "tb_manage", "tb_user", "tb_attractions", "tb_announce", "tb_message",
			"td_hotel", "tb_car", "td_activity" };
	// 链接名
	public final static String[] urlName = { "manage", "user", "attraction", "announce", "message", "hotel", "car",
			"activity" };
	// 用户表头
	public final static String userTableHead[] = { "id", "user_name", "password", "phone" };
	// 管理员表头
	public final static String manageTableHead[] = { "id", "name", "password" };
	// 公告表头
	public final static String announceTableHead[] = { "id", "title", "content", "time" };
	// 车表头
	public final static String carTableHead[] = { "id", "time", "contact_phone", "name", "contact_name", "prices",
			"address" };
	// 酒店表头
	public final static String hotelTableHead[] = { "id", "time", "contact_phone", "name", "contact_name", "prices",
			"address" };
	// servlet 单子
	public final static String servletName[] = { "ManagesServlet", "UserServlet", "AttractionServlet",
			"AnnounceServlet", "MessagesServlet", "HotelsServlet", "CarServlet", "ActivitysServlet" };

	// 留言板表头
	public final static String attractionTableHead[] = { "id", "name", "info", "see_num", "query_num", "ticket_prices",
			"address" };
	// 留言板表头
	public final static String messageTableHead[] = { "id", "user_id", "content", "agree_num", "disagree_num", "time",
			"address" };
	// 留言板表头
	public final static String activityTableHead[] = { "id", "name", "number", "prices", "info", "one", "two", "three",
			"four", "five", "six", "seven" };

	public final static String oneToSeven[] = { "one", "two", "three", "four", "five", "six", "seven" };
}
