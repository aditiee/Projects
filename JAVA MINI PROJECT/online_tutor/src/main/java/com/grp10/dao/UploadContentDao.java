package com.grp10.dao;

import java.io.InputStream;

import com.grp10.model.Contentmapping;

public interface UploadContentDao {

	public void uploadFile(Contentmapping content);
	
	public int getsubjectId();
}
