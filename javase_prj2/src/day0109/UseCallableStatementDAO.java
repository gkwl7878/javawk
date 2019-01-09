package day0109;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import kr.co.sist.connection.GetConnetion;

/**
 * Procedure�� ����� CRUD
 * 
 * @author owner
 */
public class UseCallableStatementDAO {
	
	private static UseCallableStatementDAO ucs_dao;
	
	private UseCallableStatementDAO() {
	}
	
	public static UseCallableStatementDAO getInstance() {
		if(ucs_dao== null) {
			ucs_dao = new UseCallableStatementDAO();
		}//end if
		return ucs_dao;
	}//getInstance
	
	/**
	 * test_proc ���̺��� �����ȣ, �����, ����,������ �߰��ϴ� ��
	 * 
	 * @param tpvo
	 * @return
	 * @throws SQLException
	 */
	public String insertProc(TestProcVO tpvo) throws SQLException {
		String resultMsg = "";

		Connection con = null;
		CallableStatement cstmt = null;

		try {
			// 1.
			// 2.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String pass = "tiger";
			con = GetConnetion.getInstance().getConn(url, id, pass);
			// 3. ���ν��� ���ఴü ���
			cstmt = con.prepareCall(" { call insert_test_proc(?,?,?,?,?,?) } ");
			// 4. ���ε� ������ �� �ֱ�
				//in parameter
				cstmt.setInt(1, tpvo.getEmpno());
				cstmt.setString(2, tpvo.getEname());
				cstmt.setInt(3, tpvo.getSal());
				cstmt.setString(4, tpvo.getJob());
				//out parameter :���ν����� ó���� ����� ������ ���������� ����
				cstmt.registerOutParameter(5, Types.VARCHAR );
				cstmt.registerOutParameter(6, Types.NUMERIC);
			
			// 5.
				
				cstmt.execute();
				//���ν����� ����� �� out parameter�� ������ �� ���
				resultMsg = cstmt.getString(5);
				int cnt = cstmt.getInt(6);
				System.out.println(cnt);
				System.out.println(resultMsg);
				
		} finally {
			// 6.
			if (cstmt != null) {
				cstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return resultMsg;

	}// insertProc
	
	
	
	public static void main(String[] args) {
		UseCallableStatementDAO u = new UseCallableStatementDAO();
		TestProcVO tp = new TestProcVO(1112,9000,"������","������");
		try {
			u.insertProc(tp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}