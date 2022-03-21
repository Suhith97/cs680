package edu.umb.cs680.hw04;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw04.LRUFileCache;

class LRUFileCacheTest {


	@Test
	public void  GETFILE1() throws IOException {
		
		LRUFileCache cache = new LRUFileCache(3);
		 Path path1 = Paths.get("Folder/file1");
			Path path2 = Paths.get("Folder/file2");
			Path path3  = Paths.get("Folder/file3.java");
			cache.fetch(path1);
			cache.fetch(path2);
			cache.fetch(path3);
		assertEquals(Files.readString(path1), cache.fetch(path1));
	}
	
	@Test
	public void  GETFILE2() throws IOException {

		LRUFileCache cache = new LRUFileCache(3);
		 Path path1 = Paths.get("Folder/file1");
			Path path2 = Paths.get("Folder/file2");
			Path path3  = Paths.get("Folder/file3.java");
			cache.fetch(path1);
			cache.fetch(path2);
			cache.fetch(path3);
		assertEquals(Files.readString(path2), cache.fetch(path2));
	}
	
	@Test
	public void GETFILE3() throws IOException {

		LRUFileCache cache = new LRUFileCache(3);
		 Path path1 = Paths.get("Folder/file1");
			Path path2 = Paths.get("Folder/file2");
			Path path3  = Paths.get("Folder/file3.java");
			cache.fetch(path1);
			cache.fetch(path2);
			cache.fetch(path3);
		assertEquals(Files.readString(path3), cache.fetch(path3));
	}
	
	
}