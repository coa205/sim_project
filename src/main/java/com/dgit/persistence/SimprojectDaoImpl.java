package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.SimProject;

@Repository
public class SimprojectDaoImpl implements SimProjectDao {

	@Autowired
	private SqlSession session;
	
	private static final String namespace = "com.dgit.persistence.SimProjectDao";
	
	@Override
	public List<SimProject> selectList() throws Exception {
		return session.selectList(namespace+".selectList");
	}

	@Override
	public int selectLastId() throws Exception {
		return session.selectOne(namespace+".selectLastId");
	}

	@Override
	public SimProject selectByNo(int number) throws Exception {
		return session.selectOne(namespace+".selectByNo", number);
	}

	@Override
	public int insert(SimProject simProject) throws Exception {
		return session.insert(namespace+".insert", simProject);
	}

	@Override
	public void update(SimProject simProject) throws Exception {
		session.update(namespace+".update", simProject);
	}

	@Override
	public void delete(int number) throws Exception {
		session.delete(namespace+".delete", number);
	}

}
