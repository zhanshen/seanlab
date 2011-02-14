package com.seanxiaoxiao.mediamanager.test;

import static org.junit.Assert.*;
import java.io.File;

import org.junit.Test;

import com.seanxiaoxiao.mediamanager.Mp3Media;
import com.seanxiaoxiao.mediamanager.Mp3Repostitory;
import com.seanxiaoxiao.mediamanager.Repository;

public class Mp3MediaTest {

	@Test
	public void testMp3File() {
		File mediaFile = new File("./target/test-classes/王菲-催眠.mp3");
		Mp3Media mp3Media = new Mp3Media(mediaFile.getAbsolutePath());
		assertTrue(mp3Media.isExist());
	}
	
	@Test
	public void testMp3InfoID3v2() {
		File mediaFile = new File("./target/test-classes/王菲-催眠.mp3");
		Mp3Media mp3Media = new Mp3Media(mediaFile.getAbsolutePath());
		assertEquals("只爱陌生人", mp3Media.getAlbumName());
		assertEquals("王菲", mp3Media.getAuthorName());
	}
	
	@Test
	public void testMp3InfoID3v1() {
		File mediaFile = new File("./target/test-classes/The Cranberries(卡百利乐队)-Dreams.mp3");
		Mp3Media mp3Media = new Mp3Media(mediaFile.getAbsolutePath());
		assertEquals("经典中文歌曲英文版之五", mp3Media.getAlbumName());
	}
	
	@Test
	public void copyFileToRepo() {
		File sourceRoot = new File("F:\\KwDownload\\song");
		Repository<Mp3Media> mp3Repo = new Mp3Repostitory("F:\\media\\mp3");
		throwMediaToRepo(sourceRoot, mp3Repo);
	}
	
	private void throwMediaToRepo(File sourceFile, Repository<Mp3Media> repository) {
		File[] files = sourceFile.listFiles();
		for (File source : files) {
			if (source.isDirectory()) {
				throwMediaToRepo(source, repository);
			}
			else if (source.getName().endsWith(".mp3")) {
				Mp3Media media = new Mp3Media(source.getAbsolutePath());
				repository.throwMediaToReposotiry(media);
			}
		}
	}
}
