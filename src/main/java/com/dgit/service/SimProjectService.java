package com.dgit.service;

import java.util.List;

import com.dgit.domain.SimProject;

public interface SimProjectService {
public List<SimProject> selectList() throws Exception;
	
	public int selectLastId() throws Exception;
	
	public SimProject selectByNo(int number) throws Exception;
	
	public int insert(SimProject simProject) throws Exception;
	
	public void update(SimProject simProject) throws Exception;
	
	public void delete(int number) throws Exception;
}
