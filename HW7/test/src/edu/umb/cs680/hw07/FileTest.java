package edu.umb.cs680.hw07;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw07.Directory;
import edu.umb.cs680.hw07.File;
import edu.umb.cs680.hw07.Link;

public class FileTest {
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
	
	private String[] fileToStringArray(File f) {
		String[] fileInfo = { String.valueOf(f.isFile()), f.getName(), String.valueOf(f.getSize()),
				String.valueOf(f.getCreationTime()), f.getParent().getName() };
		return fileInfo;
	}

	@Test
	public void VerifyFEofX() {
		String[] expected = { "true", "x", "15", String.valueOf(x.getCreationTime()), "apps" };
		File actual = x;
		assertArrayEquals(expected, fileToStringArray(actual));
	}
	
	@Test
	public void VerifyFEofA() {
		String[] expected = { "true", "a", "35", String.valueOf(a.getCreationTime()), "pictures" };
		File actual = a;
		assertArrayEquals(expected, fileToStringArray(actual));
	}

	@Test
	public void DirTestofB() {
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

}