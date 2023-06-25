package test;

import java.sql.*;
import java.util.*;

public class EmployeeCurdDAO {
	public int k = 0;
	public Connection con = DBConnection.getCon();

	public int insertData(Employee e) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");
			ps.setString(1, e.geteId());
			ps.setString(2, e.geteName());
			ps.setString(3, e.geteDesg());
			ps.setDouble(4, e.geteSal());
			k = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return k;
	}

	public ArrayList<Employee> al = new ArrayList<Employee>();

	public ArrayList<Employee> readData() {
		try {
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();
				e.seteId(rs.getString(1));
				e.seteName(rs.getString(2));
				e.seteDesg(rs.getString(3));
				e.seteSal(rs.getDouble(4));
				al.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public int updateData(Employee e) {
		try {
			PreparedStatement ps = con.prepareStatement("update emp set ename=?,edesg=?,esal=? where eid=?");
			ps.setString(1, e.geteName());
			ps.setString(2, e.geteDesg());
			ps.setDouble(3, e.geteSal());
			ps.setString(4, e.geteId());
			k = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return k;

	}

	public int deleteData(String id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from emp where eid=?");
			ps.setString(1, id);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
	
	

}
