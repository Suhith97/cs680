package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsDirectoryTest {
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

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void VerifyDERoot() {
		String[] expected = { "true", "DefaultOname", "175", "DefaultLMTime", "3" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void VerifyDEHome() {
		String[] expected = { "true", "DefaultOname", "135", "DefaultLMTime", "3" };
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void DirTestRoot() {
		assertTrue(root.isDirectory());
	}
	
	
	
	@Test
	public void AppendChildTestRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void AppendChildTestHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void CountChildTestRoot() {
		assertEquals(3, root.countChildren());;
	}
	

	
	@Test
	public void FileTestHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	
	
	@Test
	public void LinkTestHome() {
		assertSame(m, home.getLinks().get(0));
	}
	
	@Test
	public void LinkTestPictures() {
		assertSame(n, pictures.getLinks().get(0));
	}


}