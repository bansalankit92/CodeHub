package com.psl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.ankitbansal.model.SubmissionsModel;
import com.ankitbansal.util.IDBConnection;
import com.ankitbansal.util.JDBCConnectionImpl;


public class DAOCodehubImpl implements IDAOCodehub {
	IDBConnection db = new JDBCConnectionImpl();
	Connection conn = null;



	public List<SubmissionsModel> getSearchResult(String query, int page) {
		conn = db.getConection();
		Statement ps = null;

		List<SubmissionsModel> retList = new ArrayList<SubmissionsModel>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from submissions where MATCH(title,metadata,language) AGAINST('"+query+"'IN BOOLEAN MODE) limit 10 offset "+(page-1)*10+"");

			while (rs.next()) {
				SubmissionsModel b = new SubmissionsModel();
				b.setSubmision_id(rs.getInt("submission_id"));
				b.setTitle(rs.getString("title"));
				b.setMetadata(rs.getString("metadata"));
				b.setSource(rs.getString("source"));
				b.setStatus(rs.getString("status"));
				b.setLanguage(rs.getString("language"));
				
				retList.add(b);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}

	public Map<String, Integer> getTop5Lang() {
		conn = db.getConection();
		Statement ps = null;

		Map<String, Integer> retList = new LinkedHashMap<String, Integer>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select language,count(*) as cnt from submissions group by language order by count(*) desc");
			while (rs.next()&&retList.size()<5) {
				
				retList.put(rs.getString("language"),rs.getInt("cnt"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}

	public Map<String, Integer> getTop2Submissions() {
		conn = db.getConection();
		Statement ps = null;

		Map<String, Integer> retList = new LinkedHashMap<String, Integer>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select title,count(*) as cnt from submissions group by title order by count(*) desc");
			while (rs.next()&&retList.size()<=2) {
				
				retList.put(rs.getString("title"),rs.getInt("cnt"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}

	public int getTotalSubmissions() {
		conn = db.getConection();
		Statement ps = null;

int count = 0;
		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select count(*) as cnt from submissions");
			if (rs.next()) {
				
				count=(rs.getInt("cnt"));
				System.out.println("count");
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return count;
	}

	
	public List<SubmissionsModel> getSearchResultsFiltered(String query,
			String filter, int page) {
		conn = db.getConection();
		Statement ps = null;

		List<SubmissionsModel> retList = new ArrayList<SubmissionsModel>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from submissions where MATCH(title,metadata,language) AGAINST('"+query+"'IN BOOLEAN MODE) And status like '%"+filter+"%' limit 10 offset "+(page-1)*10+"");

			while (rs.next()) {
				SubmissionsModel b = new SubmissionsModel();
				b.setSubmision_id(rs.getInt("submission_id"));
				b.setTitle(rs.getString("title"));
				b.setMetadata(rs.getString("metadata"));
				b.setSource(rs.getString("source"));
				b.setStatus(rs.getString("status"));
				b.setLanguage(rs.getString("language"));
				
				retList.add(b);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}


	public List<SubmissionsModel> getSearchResultsFilteredAdv(String query,
			String filter1,String filter2, int page) {
		conn = db.getConection();
		Statement ps = null;

		List<SubmissionsModel> retList = new ArrayList<SubmissionsModel>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from submissions where MATCH(title,metadata,language) AGAINST('"+query+"'IN BOOLEAN MODE) And status like '%"+filter1+"%' or status like '%"+filter2+"%' limit 10 offset "+(page-1)*10+"");

			while (rs.next()) {
				SubmissionsModel b = new SubmissionsModel();
				b.setSubmision_id(rs.getInt("submission_id"));
				b.setTitle(rs.getString("title"));
				b.setMetadata(rs.getString("metadata"));
				b.setSource(rs.getString("source"));
				b.setStatus(rs.getString("status"));
				b.setLanguage(rs.getString("language"));
				
				retList.add(b);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}


	
	
	public Map<String, Integer> getSubmissionsPerLevel() {
		conn = db.getConection();
		Statement ps = null;

		Map<String, Integer> retList = new HashMap<String, Integer>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select count(*) as cnt from submissions where metadata like '%Easy%' group by 'Easy'");
			if (rs.next()) {
				
				retList.put("Easy",rs.getInt("cnt"));
			}
			
			ResultSet rs1 = ps.executeQuery("select count(*) as cnt from submissions where metadata like '%Medium%' group by 'Medium'");
			if (rs1.next()) {
				
				retList.put("Medium",rs1.getInt("cnt"));
			}
			ResultSet rs2 = ps.executeQuery("select count(*) as cnt from submissions where metadata like '%Hard%' group by 'Hard'");
			if (rs2.next()) {
				
				retList.put("Hard",rs2.getInt("cnt"));
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}
		
		
		return retList;
	}

	public List<SubmissionsModel> getSubmissions(int page) {
		conn = db.getConection();
		Statement ps = null;

		List<SubmissionsModel> retList = new ArrayList<SubmissionsModel>();

		try {
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery("select * from submissions limit 10 offset "+(page-1)*10+"");

			while (rs.next()) {
				SubmissionsModel b = new SubmissionsModel();
				b.setSubmision_id(rs.getInt("submission_id"));
				b.setTitle(rs.getString("title"));
				b.setMetadata(rs.getString("metadata"));
				b.setSource(rs.getString("source"));
				b.setStatus(rs.getString("status"));
				b.setLanguage(rs.getString("language"));
				
				retList.add(b);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			if (conn != null)
				db.closeConnection();
		}

		return retList;
	}

	

}
