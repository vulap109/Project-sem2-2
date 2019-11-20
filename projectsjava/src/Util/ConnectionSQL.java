package Util;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionSQL {

//	private static String url = FileHelper.getAppConnectionString(new File("."));
//	private static String url = "jdbc:sqlserver://localhost;databaseName=ProjectSem2;user=sa ;password=02008718";
        private static String url = "jdbc:sqlserver://ProjectSem2.mssql.somee.com;packetsize=4096;user=chaunoon_SQLLogin_1;password=yrdjdkvkw8";
	public ConnectionSQL() {
		// TODO Auto-generated constructor stub
	}

	public static final Connection Connect() {
		try {
			Connection conn;
    			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static final ResultSet CallProc(String storeName) {
		try {
			// khong truyen tham so
			CallableStatement state = Connect().prepareCall("{ call " + storeName + "}");
			return state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static final ResultSet CallProc(String storeName, String[] parameters) {
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			return state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * goi thu tuc de thuc thi truyen tham so de delete
	 * 
	 * @param storeName
	 * @param parameters
	 * @return
	 */
	public static final boolean CallProcExec(String storeName, String[] parameters) {
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			return state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * tra ve 1 gia tri
	 * 
	 * @param storeName
	 * @param parameters
	 * @return
	 */
	public static final Object CallProcScala(String storeName, String[] parameters) {
		Object obj = null;
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			state.registerOutParameter(1, java.sql.Types.JAVA_OBJECT);
			state.execute();
			obj = state.getObject(parameters.length + 1);
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch blok
			e.printStackTrace();
		}

		return obj;

	}

	public static final ResultSet Query(String strQuery) {
		Statement stmt;
		try {
			stmt = Connect().createStatement();
			ResultSet rs = stmt.executeQuery(strQuery);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static final ResultSet Query(String strQuery, String[] params) {
		PreparedStatement stmt;
		try {
			stmt = Connect().prepareStatement(strQuery);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static final int Create(String query, String[] arrParameter) {

		// thuc hien cau truy van
		PreparedStatement state;
		try {
			state = Connect().prepareStatement(query);
			for (int i = 0; i < arrParameter.length; i++) {
				state.setString(i + 1, arrParameter[i]);
			}
			int rs = state.executeUpdate();
			return rs;// result execute line
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
