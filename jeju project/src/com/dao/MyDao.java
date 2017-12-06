package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static common.JDBCTemplate.*;

import com.dto.MyDto;

public class MyDao {
	//NUM NUMBER PRIMARY KEY,
//	NAME VARCHAR2(50) NOT NULL,
//	TITLE VARCHAR2(2000) NOT NULL,
//	CONTENT VARCHAR2(4000) NOT NULL,
//	DDATE DATE NOT NULL

	public List<MyDto> selectAll(){
		Connection con = getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		List<MyDto> res = new ArrayList<>();
		String sql = "SELECT ROWNUM AS RW, A.* FROM(SELECT * FROM TEST ORDER BY GROUPNO DESC,GROUPSQ)A";
		
		try {
			System.out.println("03");
			
			stmt = con.createStatement();
			System.out.println("04");
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MyDto dto = new MyDto();
				
				dto.setNum(rs.getInt(2));
				dto.setGroupNo(rs.getInt(3));
				dto.setGroupSq(rs.getInt(4));
				dto.setTitleTab(rs.getInt(5));
				dto.setName(rs.getString(6));
				dto.setTitle(rs.getString(7));
				dto.setContent(rs.getString(8));
				dto.setDate(rs.getDate(9));
				res.add(dto);
				
			}
			System.out.println("fffff"+res.get(0).getDate());
			
			
		} catch (SQLException e) {
			System.out.println("03/04 error");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
		
		
	}
	
	public int insert(MyDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		String sql = "INSERT INTO TEST VALUES(TESTSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,'dd',?,?,SYSDATE)";

	
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			System.out.println("03.query");
			System.out.println("04.query db insert :" + sql);
			res = pstm.executeUpdate();

			if(res> 0) {
				Commit(con);
				
			}
				
		} catch (SQLException e) {
			Rollback(con);
			e.printStackTrace();
			System.out.println("3/4 error");
		} finally {

		Close(pstm, con);
		
		}

		return res;

	}
	public List<MyDto> page(int pageNum){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MyDto> list = new ArrayList<MyDto>();
		
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM AS RNUM FROM (SELECT * FROM TEST order by ROWNUM desc) A WHERE ROWNUM <= ?*5) WHERE RNUM >= ?*5-4";
	
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, pageNum);
			pstm.setInt(2, pageNum);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				MyDto dto = new MyDto();
				
				dto.setNum(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setDate(rs.getDate(5));
				list.add(dto);
				
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Close(rs, pstm, con);
			
		}
		
		
		
		return list;
	}
	public MyDto selectOne(int Num) {
		
		Connection con =getConnection();
		PreparedStatement pstm=null;
		ResultSet rs = null;
		MyDto res=new MyDto();
		
		String sql = "SELECT * FROM TEST WHERE NUM=? ORDER BY NUM";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, Num);
			rs = pstm.executeQuery();
			while(rs.next()) {
				res.setNum(rs.getInt(1));
				res.setGroupNo(rs.getInt(2));
				res.setGroupSq(rs.getInt(3));
				res.setTitleTab(rs.getInt(4));
				res.setName(rs.getString(5));
				res.setTitle(rs.getString(6));
				res.setContent(rs.getString(7));
				res.setDate(rs.getDate(8));
			}
			if(res.getNum()>0) {
				Commit(con);
				
			}
			
			
		} catch (SQLException e) {
			Rollback(con);
			
			e.printStackTrace();
		}finally {
			Close(rs, pstm, con);
		}
		
		return res;
		
	}
	
	public int update(int groupNo,int groupSq) {
		Connection con=getConnection();
		PreparedStatement pstm =null;
		int res =0;
		String sql ="UPDATE TEST SET GROUPSQ = GROUPSQ+1 WHERE GROUPNO =? AND GROUPSQ > ?";
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, groupNo);
			pstm.setInt(2, groupSq);
			res=pstm.executeUpdate();
			if(res>0) {
				Commit(con);
			}
		} catch (SQLException e) {
			Rollback(con);
			e.printStackTrace();
		}finally {
			Close(pstm, con);
		}
		return res;
	
	}
	public int insertAnswer(MyDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res= 0;
		String sql = "INSERT INTO TEST VALUES(TESTSQ.NEXTVAL,?,?,?,?,?,?,SYSDATE)";
		
		try {
			
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, dto.getGroupNo());
			pstm.setInt(2, dto.getGroupSq()+1);
			pstm.setInt(3, dto.getTitleTab()+1);
			pstm.setString(4, dto.getName());
			pstm.setString(5, dto.getTitle());
			pstm.setString(6, dto.getContent());
			
			res=pstm.executeUpdate();
			if(res>0) {
				Commit(con);
			}
		} catch (SQLException e) {
			Rollback(con);
			e.printStackTrace();
		}finally {
			Close(pstm, con);
		}
		
		
		
		return res;
	}
	public int delete(int num) {
		Connection con = getConnection();
		String sql = "DELETE FROM TEST WHERE NUM=?";
		PreparedStatement pstm = null;
		
		int rs = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, num);
			
			rs=pstm.executeUpdate();
			if(rs>0) {
				Commit(con);
			}
			
		} catch (SQLException e) {
			Rollback(con);
			e.printStackTrace();
		}finally {
			Close(pstm, con);
		}
	
		return rs;
		
	}

	public int update(MyDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = "UPDATE TEST SET TITLE=?,CONTENT=?,DDATE=SYSDATE WHERE NUM=?";
		int res = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getNum());
			res= pstm.executeUpdate();
			if(res > 0) {
				Commit(con);
			}
		} catch (SQLException e) {
			Rollback(con);
			e.printStackTrace();
		}
		
		return res;
	}
	
	
	
	
}
