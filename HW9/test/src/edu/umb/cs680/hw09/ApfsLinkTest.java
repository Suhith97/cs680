package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

public class ApfsLinkTest {
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
	
	private String[] linkToStringArray(ApfsLink l) {
		String[] linkInfo = { String.valueOf(l.isLink()), l.getOwnerName(), String.valueOf(l.getSize()),
						l.getLastModifiedTime(), l.getParent().getName(), l.getTarget().getName() };
		return linkInfo;
	}

	@Test
	public void VerifyLEofM() {
		String[] expected = { "true", "DefaultOname", "0", "DefaultLMTime", "home", "bin" };
		ApfsLink actual = m;
		assertArrayEquals(expected, linkToStringArray(actual));
	}
	
	

	@Test
	public void DirTestofM() {
		assertFalse(m.isDirectory());
	}
	
	@Test
	public void FileTestofM() {
		assertFalse(m.isFile());
	}
	
	@Test
	public void LinkTestofM() {
		assertTrue(m.isLink());
	}
	
	@Test
	public void TargetTestofM() {
		assertSame(bin, m.getTarget());
	}
	
	@Test
	public void VerifyLEofN() {
		String[] expected = { "true", "DefaultOname", "0", "DefaultLMTime", "pictures", "y" };
		ApfsLink actual = n;
		assertArrayEquals(expected, linkToStringArray(actual));
	}

}