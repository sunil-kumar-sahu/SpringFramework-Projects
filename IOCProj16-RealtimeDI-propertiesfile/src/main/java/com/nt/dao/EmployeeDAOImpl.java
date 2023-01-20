package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String EMP_INSERT_QUERY="INSERT INTO REALTIMEDI_SPRING_EMPLOYEE VALUES(SP_ENO_SEQ.NEXTVAL,?,?,?,?,?)";
	//HAS-A property
	private DataSource ds; 
	
	//alt+shift+s,o
	public EmployeeDAOImpl(DataSource ds) {
		System.out.println("EmployeeDAOImpl:1-Param Constructor");
		this.ds = ds;
	}

	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		System.out.println("EmployeeDAOImpl.InsertEmployee()");
		try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(EMP_INSERT_QUERY);	
				){
			//set values to Query params
			ps.setString(1,bo.getEname());
			ps.setString(2, bo.getDesg());
			ps.setFloat(3, bo.getBasicSalary());
			ps.setFloat(4, bo.getGrossSalary());
			ps.setFloat(5, bo.getNetSalary());
			//execute the Query
			int result = ps.executeUpdate();
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		throw se;//exception rethrowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;//exception rethrowing
		}
		
		return 0;
	

	
	

	/*@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
	     //get pooled JDBC con object
			con=ds.getConnection();
		//create PreparedStatement object having query as the pre-compiled SQL query
			ps=con.prepareStatement(EMP_INSERT_QUERY);
			//set values to query params
			ps.setString(1,bo.getEname());
			ps.setString(2, bo.getDesg());
			ps.setFloat(3, bo.getBasicSalary());
			ps.setFloat(4, bo.getGrossSalary());
			ps.setFloat(5, bo.getNetSalary());
			//execute the Query
			 result=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
		throw se;//exception rethrowing
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally {
		//close jdbc objs
			try {
			if(ps!=null)
				ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
		}
		return result;*/
	}

}
