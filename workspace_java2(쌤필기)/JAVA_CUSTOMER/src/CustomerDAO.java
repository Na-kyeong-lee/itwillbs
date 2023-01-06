import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import sql.SqlMapClient;

public class CustomerDAO {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapClient.getSqlSession();
	
	// 조회
	public Vector select(Map<String, String> param) {
		SqlSession session = sqlSessionFactory.openSession();
		
		// "Customer.select" => namespace.id
		List<CustomerDTO> sqlData = session.selectList("Customer.select", param);
//		System.out.println(sqlData);
		Vector data = new Vector(); // 최종적으로 return할 데이터
		
		for(CustomerDTO dto : sqlData) {
			Vector rowData = new Vector(); // 하나의 Row를 생성
			
			rowData.add(dto.getIdx());
			rowData.add(dto.getName());
			rowData.add(dto.getAge());
			rowData.add(dto.geteMail());
			rowData.add(dto.getJumin());
			
			data.add(rowData);
		}
		
		session.close();
		
		return data;
	}
	
	public boolean insert(CustomerDTO dto) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("Customer.insert", dto);
		session.commit();
		session.close();
		return insertCnt > 0 ? true : false;
	}
	
	public boolean delete(String idx) {
		SqlSession session = sqlSessionFactory.openSession();
		int deleteCnt = session.delete("Customer.delete", idx);
		session.commit();
		session.close();
		return deleteCnt > 0 ? true : false;
	}
	
	
	
	
}
