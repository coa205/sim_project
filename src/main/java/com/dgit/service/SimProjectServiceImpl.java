package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.SimProject;
import com.dgit.persistence.SimProjectDao;

@Service //루트 컨텍스트에 Service를 인식 할 수 있도록 함
public class SimProjectServiceImpl implements SimProjectService {
	
	@Autowired
	private SimProjectDao dao;

	@Override
	public List<SimProject> selectList() throws Exception {
		return dao.selectList();
	}

	@Override
	public int selectLastId() throws Exception {
		return dao.selectLastId();
	}

	@Override
	public SimProject selectByNo(int number) throws Exception {
		return dao.selectByNo(number);
	}

	@Override
	public int insert(SimProject simProject) throws Exception {
		return dao.insert(simProject);
	}

	@Override
	public void update(SimProject simProject) throws Exception {
		dao.update(simProject);
	}

	@Override
	public void delete(int number) throws Exception {
		dao.delete(number);
	}

}
