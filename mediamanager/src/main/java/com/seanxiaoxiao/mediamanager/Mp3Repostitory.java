package com.seanxiaoxiao.mediamanager;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;


public class Mp3Repostitory extends Repository<Mp3Media> {

	private final String mp3RepoRoot;
	
	private final String mp3UncategoryPath;
	
	public Mp3Repostitory(String mp3RepoRoot) {
		this.mp3RepoRoot = mp3RepoRoot;
		this.mp3UncategoryPath = FilenameUtils.concat(this.mp3RepoRoot, "unknown");
	}
	
	@Override
	public String getRepositoryRoot() {
		return mp3RepoRoot;
	}

	@Override
	public String getUncategyPath() {
		return mp3UncategoryPath;
	}
	
	public void throwMediaToReposotiry(Mp3Media mp3MediaFile) {
		String targetDir = mp3MediaFile.toTargetRepoPath(this);
		File targetAlbumDir = new File(targetDir);
		try {
			FileUtils.moveFileToDirectory(new File(mp3MediaFile.getMediaPath()), targetAlbumDir, true);
		} catch (Exception e) {
			//This could hardly happen.
		}
	}
}

