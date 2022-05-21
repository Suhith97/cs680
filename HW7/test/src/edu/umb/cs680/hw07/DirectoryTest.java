package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class DirectoryTest {
	private static Directory root, apps, bin, home, pictures;
	
	private static File x, y, a, b,c;
	
	private static Link m, n;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root = new Directory(null, "root", 0, LocalDateTime.now());
		apps = new Directory(root, "apps", 0, LocalDateTime.now());
		bin = new Directory(root, "bin", 0, LocalDateTime.now());
		home = new Directory(root, "home", 0, LocalDateTime.now());
		pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
		x = new File(apps, "x", 15, LocalDateTime.now());
		y = new File(bin, "y", 25, LocalDateTime.now());
		a = new File(pictures, "a", 35, LocalDateTime.now());
		b = new File(pictures, "b", 45, LocalDateTime.now());
		c = new File(home, "c", 55, LocalDateTime.now());
		m = new Link(home, "m", 0, LocalDateTime.now(), bin);
		n = new Link(pictures, "n", 0, LocalDateTime.now(), y);
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

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void VerifyDERoot() {
		String[] expected = { "true", "root", "175", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	

	
	@Test
	public void DirTestRoot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void FileTestRoot() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void LinkTestRoot() {
		assertFalse(root.isLink());
	}
	
	
	
	@Test
	public void CountCtestHome() {
		assertSame(3, home.countChildren());
	}
	
	
	
	@Test
	public void SubDirTestHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
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
	public void LinkTestPicture() {
		assertSame(n, pictures.getLinks().get(0));
	}
	


}
