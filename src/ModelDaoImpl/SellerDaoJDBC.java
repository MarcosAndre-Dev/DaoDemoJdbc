package ModelDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ModelDao.SellerDao;
import ModelEntities.Department;
import ModelEntities.Seller;
import db.DB;
import db.DbException;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn	;
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller FindById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT seller.Id, seller.Name, seller.Email, seller.BirthDate, seller.BaseSalary, "
			  + "seller.DepartmentId AS DepId, "
			  + "department.Name AS DepName "
			  + "FROM seller "
			  + "INNER JOIN department "
			  + "ON seller.DepartmentId = department.Id "
			  + "WHERE seller.Id = ?"
			);

			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Department dep = instantiateDepartment (rs);				
				Seller obj = instantiateSeller(rs, dep);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		return obj;
	}


	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		 	Department dep = new Department();
			dep.setId(rs.getInt("DepId"));
			dep.setName(rs.getString("DepName"));
			return dep;

	}


	@Override
	public List<Seller> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Seller> FindByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				    "SELECT seller.*, seller.DepartmentId AS DepId, department.Name AS DepName "
				  + "FROM seller "
				  + "INNER JOIN department ON seller.DepartmentId = department.Id "
				  + "WHERE seller.DepartmentId = ? "
				  + "ORDER BY seller.Name"
				);


			st.setInt(1, department.getId());
			rs = st.executeQuery();
			
	List<Seller> list = new ArrayList<>();
	Map<Integer, Department> map = new HashMap<>();

			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
 				Seller obj = instantiateSeller(rs, dep);
				list.add(obj);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
