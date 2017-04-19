package com.xatu.util;

/**
 * ��Ÿ��ֱ����Ϣ�������޸�
 * 
 * @author zsl
 *
 */
public class TableInfo {

	// ����
	public final static String[] tableName = { "tb_manage", "tb_user", "tb_attractions", "tb_announce", "tb_message",
			"td_hotel", "tb_car", "td_activity" };
	// ������
	public final static String[] urlName = { "manage", "user", "attraction", "announce", "message", "hotel", "car",
			"activity" };
	// �û���ͷ
	public final static String userTableHead[] = { "id", "user_name", "password", "phone" };
	// ����Ա��ͷ
	public final static String manageTableHead[] = { "id", "name", "password" };
	// �����ͷ
	public final static String announceTableHead[] = { "id", "title", "content", "time" };
	// ����ͷ
	public final static String carTableHead[] = { "id", "time", "contact_phone", "name", "contact_name", "prices",
			"address" };
	// �Ƶ��ͷ
	public final static String hotelTableHead[] = { "id", "time", "contact_phone", "name", "contact_name", "prices",
			"address" };
	// servlet ����
	public final static String servletName[] = { "ManagesServlet", "UserServlet", "AttractionServlet",
			"AnnounceServlet", "MessagesServlet", "HotelsServlet", "CarServlet", "ActivitysServlet" };

	// ���԰��ͷ
	public final static String attractionTableHead[] = { "id", "name", "info", "see_num", "query_num", "ticket_prices",
			"address" };
	// ���԰��ͷ
	public final static String messageTableHead[] = { "id", "user_id", "content", "agree_num", "disagree_num", "time",
			"address" };
	// ���԰��ͷ
	public final static String activityTableHead[] = { "id", "name", "number", "prices", "info", "one", "two", "three",
			"four", "five", "six", "seven" };

	public final static String oneToSeven[] = { "one", "two", "three", "four", "five", "six", "seven" };
}
