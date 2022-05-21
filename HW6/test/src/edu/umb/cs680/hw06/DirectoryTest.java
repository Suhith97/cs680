package edu.umb.cs680.hw06;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.Directory;
import edu.umb.cs680.hw06.File;

public class DirectoryTest {
	private static Directory root, apps, bin, home, pictures;
	
	private static File x, y, a, b,c;
	
	

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
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		pictures.appendChild(a);
		pictures.appendChild(b);
	}

	private String[] dirToStringArray(Directory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getName(), String.valueOf(d.getTotalSize()),
				String.valueOf(d.getCreationTime()), String.valueOf(d.countChildren()) };
		return dirInfo;
	}

	@Test
	public void VerifyDEroot() {
		String[] expected = { "true", "root", "175", String.valueOf(root.getCreationTime()), "3" };
		Directory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void VerifyDEhome() {
		String[] expected = { "true", "home", "135", String.valueOf(home.getCreationTime()), "2" };
		Directory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void DtestWithroot() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void AppendCtestwithroot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void AppendCtestwithHome() {
		assertSame(home, c.getParent());
	}
	
	@Test
	public void CountCtestwithroot() {
		assertEquals(3, root.countChildren());;
	}
	
	@Test
	public void CountCtestwithHome() {
		assertSame(2, home.countChildren());
	}
	
	@Test
	public void getSubDirectoriesTestingWithRoot() {
		Directory[] expected = new Directory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		Directory[] actual = new Directory[3];
		LinkedList<Directory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void GetSubDirtestwithRoot() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void GetFiletestwithHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void GetFileTestwithPic() {
		File[] expected = new File[2];
		expected[0] = a;
		expected[1] = b;
		File[] actual = new File[2];
		LinkedList<File> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	

}