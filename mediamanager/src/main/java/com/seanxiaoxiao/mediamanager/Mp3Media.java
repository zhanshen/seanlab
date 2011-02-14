package com.seanxiaoxiao.mediamanager;

import java.io.File;
import java.io.IOException;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;
import org.springframework.util.StringUtils;

public class Mp3Media extends MediaType {

	private final static String ALBUMDIR_PATTERN_NOPUBLISHYEAR = "%s/%s/%s";
	
	private final File mp3File;

	
	private String albumName;
	
	private String title;
	
	private String publishYear;
	
	private String authorName;
	
	public String getAlbumName() {
		return albumName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPublishYear() {
		return publishYear;
	}
	
	public Mp3Media(String mp3Path) {
		this.mp3File = new File(mp3Path);
		parseFile();
	}

	public String toTargetRepoPath(Repository<?> repository) {
		if (!StringUtils.hasLength(albumName) || !StringUtils.hasLength(authorName)) {
			return repository.getUncategyPath();
		}
		return String.format(ALBUMDIR_PATTERN_NOPUBLISHYEAR, repository.getRepositoryRoot(), this.authorName, this.albumName);
	}
	
	@Override
	public String getMediaPath() {
		return mp3File.getAbsolutePath();
	}
	
	public boolean isExist() {
		return mp3File.exists();
	}
	
	private void parseFile() {
		try {
			MP3File mp3FileInfo = new MP3File(this.mp3File);
			AbstractID3v2 id3v2 = mp3FileInfo.getID3v2Tag();
			ID3v1 id3v1 = mp3FileInfo.getID3v1Tag();
			
			if (id3v2 != null) {
				this.albumName = id3v2.getAlbumTitle();
				this.authorName = id3v2.getLeadArtist();
				this.publishYear = id3v2.getYearReleased();
				this.title = id3v2.getSongTitle();
			}
			else {
				this.albumName = id3v1.getAlbumTitle();
				this.authorName = id3v1.getLeadArtist();
				this.publishYear = id3v1.getYearReleased();
				this.title = id3v1.getSongTitle();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TagException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Mp3Media [albumName=" + albumName + ", title=" + title
				+ ", publishYear=" + publishYear + ", authorName=" + authorName
				+ "]";
	}
	
}
