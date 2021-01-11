
package com.zensar;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository {
	public boolean viewUser(String username,String password)
	{
		Connection conn=DBUtil.getMySqlDbConnection();
		boolean result=false;
		String sql="select * from login where username=? ";
		
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String pass=rs.getString("password");
				System.out.println(pass);
				if(pass.equalsIgnoreCase(password))
				result=true;
			}
		}catch(Exception e)
		{
			System.out.println("Eception occured "+e);
		}
		
		System.out.println(result);
		return result;
	}

}