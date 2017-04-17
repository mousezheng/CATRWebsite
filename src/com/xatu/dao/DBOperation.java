package com.xatu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xatu.util.StringChage;

/**
 * ���ݿ����
 * 
 * @author zsl
 *
 */
public class DBOperation {
	/**
	 * ��ʼ��
	 */
	private static DBOperation myDB = new DBOperation();

	public static DBOperation getMyDB() {
		return myDB;
	}

	// ��������
	private String driver = "com.mysql.jdbc.Driver";
	// Ҫ���ʵ����ݿ������
	private String url = "jdbc:mysql://127.0.0.1:3306/catrwebsite";
	// mysql �����û��� ����
	private String password = "1486145487";
	private String user = "root";
	private Connection dbConn = null;

	private DBOperation() {
		try {
			// ��������
			Class.forName(driver);
			// �������ݿ�
			dbConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
		} catch (SQLException e) {
			System.out.println("���ݿ����Ӵ���!");
		}
	}

	/**
	 * ����û��Ƿ���ڣ�ͨ���û���������м�� �û����������ֻ����룬Ҳ�������û���
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean userIsExist(String name, String password) {
		String sqlStr = "select id from tb_user where(user_name = ? or phone = ? and password = ?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, name);
			statement.setString(2, name);
			statement.setString(3, password);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("�û���֤�ɹ�");
				return true;
			} else {
				System.out.println("�û���֤ʧ��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��½sql���ִ�г���");
		}
		return false;
	}

	/**
	 * ����Ա�Ƿ����
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean managerIsExist(String name, String password) {
		String sqlStr = "select id from tb_manage where(name = ? and password = ?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("����Ա��֤�ɹ�");
				return true;
			} else {
				System.out.println("������֤ʧ��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����Ա��½sql���ִ�г���");
		}
		return false;
	}

	/**
	 * �жϵ绰�����Ƿ���� ��ֹͬһ���û�ע������
	 * 
	 * @param phone
	 * @param name
	 * @return
	 */
	public boolean phoneIsExist(String phone, String name) {
		String sqlStr = "select id from tb_user where(phone = ? or user_name = ?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, phone);
			statement.setString(2, name);
			ResultSet rs = statement.executeQuery();

			if (!rs.next()) {
				System.out.println("�ֻ������ڿ���ע��");
				return true;
			} else {
				System.out.println("�ֻ��Ŵ����޷�ע��");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ֻ��Ų�ѯsql���ִ�г���");
		}
		return false;
	}

	/**
	 * �û�ע�ᣬ���ڲ�����Ϣ�ǿ�Ϊ�յģ����Ե�������ע�ắ��
	 * 
	 * @param name
	 * @param password
	 * @param phone
	 * @param headImgPath
	 */
	public void userRegistered(String name, String password, String phone, String headImgPath) {
		String sqlStr = "insert into tb_user(id,user_name,password,phone,photo)  values(null,?,?,?,?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, name);
			statement.setString(2, password);
			statement.setString(3, phone);
			statement.setString(4, headImgPath);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ע���sql������");
			e.printStackTrace();
		}
		System.out.println(name + "ע��ɹ���");
	}

	/**
	 * �޸�����
	 * 
	 * @param name
	 * @param password
	 * @param newPassword
	 * @return
	 */
	public boolean changePassword(String name, String password, String newPassword) {
		if (this.userIsExist(name, password)) { // ����������ȷ
			String sqlStr = "update tb_user set password = ? where user_name = ? and password = ?";
			try {
				PreparedStatement statement = dbConn.prepareStatement(sqlStr);
				statement.setString(1, newPassword);
				statement.setString(2, name);
				statement.setString(3, password);
				int sign = statement.executeUpdate();
				if (sign == 1) {
					return true;
				}
			} catch (SQLException e) {
				System.out.println("�����޸�SQL������");
				e.printStackTrace();
			}

		} else {
			return false;
		}
		return false;
	}

	/**
	 * ������Ϣ�����ݱ�ͷ��������Ϣ���м���
	 * 
	 * @param tableHead
	 * @param tableName
	 * @return
	 */
	public List<String[]> select(String[] tableHead, String tableName) {
		List<String[]> strList = new ArrayList<>();
		// ����sql���
		StringBuffer sql = new StringBuffer("select ");
		sql.append(tableHead[0]);
		for (int i = 1; i < tableHead.length; i++) {
			sql.append("," + tableHead[i]);
		}
		sql.append(" from " + tableName);
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			System.out.println("sqlִ�����");
			// �������ҽ��
			while (rs.next()) {
				String temp[] = new String[tableHead.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = rs.getString(i + 1);
				}
				strList.add(temp);
			}
			System.out.println(tableName + "  ���ѯ��ϣ�");
		} catch (SQLException e) {
			System.out.println(tableName + "  ���ѯ��������!");
			e.printStackTrace();
		}
		return strList;
	}

	/**
	 * ���������������ݣ�Ҳ֧�ֶ���ѯ
	 * 
	 * @param tableHead
	 * @param tableName
	 * @param tableName2
	 * @param whereStr
	 * @return
	 */
	public List<String[]> selectWhere(String[] tableHead, String tableName, String tableName2, String whereStr) {
		List<String[]> strList = new ArrayList<>();
		// ����sql���
		StringBuffer sql = new StringBuffer("select ");
		sql.append(tableHead[0]);
		for (int i = 1; i < tableHead.length; i++) {
			sql.append("," + tableHead[i]);
		}
		sql.append(" from " + tableName);
		if (tableName2 != null) {
			sql.append("," + tableName2);
		}
		sql.append("  where " + whereStr);
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			ResultSet rs = statement.executeQuery();
			System.out.println("sqlִ�����");
			// �������ҽ��
			while (rs.next()) {
				String temp[] = new String[tableHead.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = rs.getString(i + 1);
				}
				strList.add(temp);
			}
			System.out.println(tableName + "  ���ѯ��ϣ�");
		} catch (SQLException e) {
			System.out.println(tableName + "  ���ѯ��������!");
			e.printStackTrace();
		}
		return strList;
	}

	/**
	 * ����һ������Ҫ��Ϊ����Ϣ��ѯ��������Ϣ�Լ�������Ϣ��
	 * 
	 * @param tableHead
	 * @param tableName
	 * @param whereStr
	 * @return
	 */
	public String[] selectOne(String[] tableHead, String tableName, String whereStr) {
		String[] strList = new String[tableHead.length];
		// ����sql���
		StringBuffer sql = new StringBuffer("select ");
		sql.append(tableHead[0]);
		for (int i = 1; i < tableHead.length; i++) {
			sql.append("," + tableHead[i]);
		}
		sql.append(" from " + tableName);
		sql.append("  where " + whereStr + "");
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			System.out.println("sqlִ�����");
			// �������ҽ��
			if (rs.next()) {
				for (int i = 0; i < tableHead.length; i++) {
					strList[i] = rs.getString(i + 1);
				}
			}
			// System.out.println("==============" + strList[0]);
			System.out.println(tableName + "  ���ѯ��ϣ�");
		} catch (SQLException e) {
			System.out.println(tableName + "  ���ѯ��������!");
			e.printStackTrace();
		}
		return strList;
	}

	/**
	 * ���򣬾����ȶ�����
	 * 
	 * @return
	 */
	public String[] select4DESC() {
		String sql = "select name from tb_attractions order by query_num DESC limit 4";
		String[] name = new String[4];
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				for (int i = 0; i < 4; i++) {
					name[i] = rs.getString(1);
					rs.next();
				}
			}
		} catch (SQLException e) {
			System.out.println("select4DESC() " + "����");
			e.printStackTrace();
		}

		return name;
	}

	/**
	 * ģ������
	 * 
	 * @param tableHead
	 * @param tableName
	 * @param string
	 * @return
	 */
	public List<String[]> selectLike(String[] tableHead, String tableName, String string) {
		List<String[]> strList = new ArrayList<>();
		// ����sql���
		StringBuffer sql = new StringBuffer("select ");
		sql.append(tableHead[0]);
		for (int i = 1; i < tableHead.length; i++) {
			sql.append("," + tableHead[i]);
		}
		sql.append(" from " + tableName);
		sql.append("  where " + string);
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			ResultSet rs = statement.executeQuery();
			System.out.println("sqlִ�����");
			// �������ҽ��
			while (rs.next()) {
				String temp[] = new String[tableHead.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = rs.getString(i + 1);
				}
				strList.add(temp);
			}
			System.out.println(tableName + "  ���ѯ��ϣ�");
		} catch (SQLException e) {
			System.out.println(tableName + "  ���ѯ��������!");
			e.printStackTrace();
		}
		return strList;
	}

	/**
	 * ����id
	 * 
	 * @param tableName
	 * @param inputHead
	 * @param outHead
	 * @param inputText
	 * @return
	 */
	public String getIdString(String tableName, String inputHead, String outHead, String inputText) {
		String sql = "select " + outHead + " from " + tableName + " where " + inputHead + "='" + inputText + "'";
		String out = null;
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			System.out.println("��ѯִ�����");
			// �������ҽ��
			if (rs.next()) {
				out = rs.getString(1);
				// System.out.println(""+out);
				System.out.println("getIdString" + "  ������ϣ�");
			} else {
				System.out.println("û�鵽��");
			}
		} catch (SQLException e) {
			System.out.println(tableName + "  ���ѯ��������!");
			e.printStackTrace();
		}
		return out;
	}

	/**
	 * ������¼
	 * 
	 * @param object
	 * @param strs
	 * @param tableHeads
	 * @param tableName
	 * @return
	 */
	public boolean insert(Object object, String[] strs, String[] tableHeads, String tableName) {
		StringBuffer sql = new StringBuffer("insert into " + tableName + "(");
		sql.append(tableHeads[0]);
		for (int i = 1; i < tableHeads.length; i++) {
			sql.append("," + tableHeads[i]);
		}
		sql.append(") ");
		sql.append("values(");
		sql.append(strs[0]);
		for (int i = 1; i < strs.length; i++) {
			sql.append("," + strs[i]);
		}
		sql.append(") ");

		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			System.out.println(sql);
			if (statement.executeUpdate() == 1) {
				System.out.println("����ɹ���");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("insert �����ˣ�");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * ���/����������һ
	 * 
	 * @param string
	 * @param string2
	 */
	public void queryplus(String seeOrQuery, String id,String tableName) {
		String sql = "update "+tableName+" set " + seeOrQuery + "=" + seeOrQuery + "+1 " + " where id='" + id + "'";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			System.out.println(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���¼�¼
	 * 
	 * @param tableName
	 * @param info
	 * @param whereStr
	 * @return
	 */
	public boolean updateTable(String tableName, String[] tableHead, String[] info, String whereStr) {
		StringBuffer sql = new StringBuffer("update " + tableName + " set ");
		for (int i = 0; i < info.length; i++) {
			if (!info[i].equals("null")) {
				sql.append(tableHead[i] + " = '" + (info[i]) + "' ,");
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" where " + whereStr);
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			System.out.println(sql);
			if (statement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(tableName + "updateTable  ��������������������");
			e.printStackTrace();
		}
		return false;
	}

}
