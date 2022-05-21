package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.ApfsDirectory;
import edu.umb.cs680.hw14.ApfsFile;
import edu.umb.cs680.hw14.ApfsLink;

public class ApfsFileTest {
	private static ApfsDirectory root, apps, bin, home, pictures;

	private static ApfsFile x,y,a,b,c;
	
	private static ApfsLink m, n;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		x = new ApfsFile(apps, "x", 15, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		y = new ApfsFile(bin, "y", 25, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		a = new ApfsFile(pictures, "a", 35, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		b = new ApfsFile(pictures, "b", 45, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		c = new ApfsFile(home, "c", 55, LocalDateTime.now(), "DefaultOname", "DefaultLMTime");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "DefaultOname", "DefaultLMTime", y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
	}
	
	private String[] fileToStringArray(ApfsFile f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getOwnerName(), String.valueOf(f.getSize()),
							f.getLastModifiedTime(), f.getParent().getName() };
		return fileInfo;
	}

	
	@Test
	public void VerifyFEofA() {
		String[] expected = { "true", "DefaultOname", "35", "DefaultLMTime", "pictures" };
		ApfsFile actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void DirTestOfB() {
		assertFalse(b.isDirectory());
	}
	
	@Test
	public void FileTestofB() {
		assertTrue(b.isFile());
	}
	
	@Test
	public void LinkTestofB() {
		assertFalse(b.isLink());
	}
	

	@Test
	public void VerifyFEofX() {
		String[] expected = { "true", "DefaultOname", "15", "DefaultLMTime", "apps" };
		ApfsFile actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

}