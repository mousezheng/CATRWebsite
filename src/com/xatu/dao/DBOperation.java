package com.xatu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作
 * 
 * @author zsl
 *
 */
public class DBOperation {
	/**
	 * 初始化
	 */
	private static DBOperation myDB = new DBOperation();

	public static DBOperation getMyDB() {
		return myDB;
	}

	// 驱动名称
	private String driver = "com.mysql.jdbc.Driver";
	// 要访问的数据库的链接
	private String url = "jdbc:mysql://127.0.0.1:3306/catrwebsite";
	// mysql 配置用户名 密码
	private String password = "1486145487";
	private String user = "root";
	private Connection dbConn = null;

	private DBOperation() {
		try {
			// 加载驱动
			Class.forName(driver);
			// 链接数据库
			dbConn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败！");
		} catch (SQLException e) {
			System.out.println("数据库连接错误!");
		}
	}

	public boolean userIsExist(String name, String password) {
		String sqlStr = "select id from tb_user where(user_name = ? or phone = ? and password = ?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, name);
			statement.setString(2, name);
			statement.setString(3, password);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("用户验证成功");
				return true;
			} else {
				System.out.println("用户验证失败");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("登陆sql语句执行出错");
		}
		return false;
	}

	public boolean managerIsExist(String name, String password) {
		String sqlStr = "select id from tb_manage where(name = ? and password = ?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, name);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				System.out.println("管理员验证成功");
				return true;
			} else {
				System.out.println("管理验证失败");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("管理员登陆sql语句执行出错");
		}
		return false;
	}

	public boolean phoneIsExist(String phone, String name) {
		String sqlStr = "select id from tb_user where(phone = ? or user_name = ?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sqlStr);
			statement.setString(1, phone);
			statement.setString(2, name);
			ResultSet rs = statement.executeQuery();

			if (!rs.next()) {
				System.out.println("手机不存在可以注册");
				return true;
			} else {
				System.out.println("手机号存在无法注册");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("手机号查询sql语句执行出错");
		}
		return false;
	}

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
			System.out.println("注册的sql语句出错！");
			e.printStackTrace();
		}
		System.out.println(name + "注册成功！");
	}

	public boolean changePassword(String name, String password, String newPassword) {
		if (this.userIsExist(name, password)) { // 密码输入正确
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
				System.out.println("密码修改SQL语句错误！");
				e.printStackTrace();
			}

		} else {
			return false;
		}
		return false;
	}

	public List<String[]> select(String[] tableHead, String tableName) {
		List<String[]> strList = new ArrayList<>();
		// 构建sql语句
		StringBuffer sql = new StringBuffer("select ");
		sql.append(tableHead[0]);
		for (int i = 1; i < tableHead.length; i++) {
			sql.append("," + tableHead[i]);
		}
		sql.append(" from " + tableName);
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			ResultSet rs = statement.executeQuery();
			System.out.println("sql执行完毕");
			// 解析查找结果
			while (rs.next()) {
				String temp[] = new String[tableHead.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = rs.getString(i + 1);
				}
				strList.add(temp);
			}
			System.out.println(tableName + "  表查询完毕！");
		} catch (SQLException e) {
			System.out.println(tableName + "  表查询出问题了!");
			e.printStackTrace();
		}
		return strList;
	}

	public List<String[]> selectWhere(String[] tableHead, String tableName, String tableName2, String whereStr) {
		List<String[]> strList = new ArrayList<>();
		// 构建sql语句
		StringBuffer sql = new StringBuffer("select ");
		sql.append(tableHead[0]);
		for (int i = 1; i < tableHead.length; i++) {
			sql.append("," + tableHead[i]);
		}
		sql.append(" from " + tableName);
		sql.append("," + tableName2);
		sql.append("  where " + whereStr);
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql.toString());
			System.out.println(sql.toString());
			ResultSet rs = statement.executeQuery();
			System.out.println("sql执行完毕");
			// 解析查找结果
			while (rs.next()) {
				String temp[] = new String[tableHead.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = rs.getString(i + 1);
				}
				strList.add(temp);
			}
			System.out.println(tableName + "  表查询完毕！");
		} catch (SQLException e) {
			System.out.println(tableName + "  表查询出问题了!");
			e.printStackTrace();
		}
		return strList;
	}

	public String[] selectOne(String[] tableHead, String tableName, String whereStr) {
		String[] strList = new String[tableHead.length];
		// 构建sql语句
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
			System.out.println("sql执行完毕");
			// 解析查找结果
			if (rs.next()) {
				for (int i = 0; i < tableHead.length; i++) {
					strList[i] = rs.getString(i + 1);
				}
			}
//			System.out.println("==============" + strList[0]);
			System.out.println(tableName + "  表查询完毕！");
		} catch (SQLException e) {
			System.out.println(tableName + "  表查询出问题了!");
			e.printStackTrace();
		}
		return strList;
	}

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
			System.out.println("select4DESC() " + "出错！");
			e.printStackTrace();
		}

		return name;
	}

	public List<String[]> selectLike(String[] tableHead, String tableName, String string) {
		List<String[]> strList = new ArrayList<>();
		// 构建sql语句
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
			System.out.println("sql执行完毕");
			// 解析查找结果
			while (rs.next()) {
				String temp[] = new String[tableHead.length];
				for (int i = 0; i < temp.length; i++) {
					temp[i] = rs.getString(i + 1);
				}
				strList.add(temp);
			}
			System.out.println(tableName + "  表查询完毕！");
		} catch (SQLException e) {
			System.out.println(tableName + "  表查询出问题了!");
			e.printStackTrace();
		}
		return strList;
	}

	public String getIdString(String tableName, String inputHead, String outHead, String inputText) {
		String sql = "select " + outHead + " from " + tableName + " where " + inputHead + "='" + inputText + "'";
		String out = null;
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			System.out.println("查询执行完毕");
			// 解析查找结果
			if (rs.next()) {
				out = rs.getString(1);
				// System.out.println(""+out);
				System.out.println("getIdString" + "  解析完毕！");
			} else {
				System.out.println("没查到！");
			}
		} catch (SQLException e) {
			System.out.println(tableName + "  表查询出问题了!");
			e.printStackTrace();
		}
		return out;
	}

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
				System.out.println("插入成功！");
				return true;
			}
		} catch (SQLException e) {
			System.out.println("insert 出错了！");
			e.printStackTrace();
		}

		return false;
	}

}
