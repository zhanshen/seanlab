package com.seanxiaoxiao.mediamanager;

public abstract class Repository<T extends MediaType> {

	public abstract String getRepositoryRoot();
	
	public abstract String getUncategyPath();
	
	public abstract void throwMediaToReposotiry(T mediaType);
}
