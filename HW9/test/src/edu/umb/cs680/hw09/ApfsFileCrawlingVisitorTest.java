package edu.umb.cs680.hw09;

import static org.junit.Assert.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import edu.umb.cs680.hw09.apfs.util.ApfsFileCrawlingVisitor;

public class ApfsFileCrawlingVisitorTest {
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

	@Test
	public void VerifyFilesRoot() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		root.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		LinkedList<ApfsFile> expected = new LinkedList<>();
		expected.add(x);
		expected.add(y);
		expected.add(a);
		expected.add(b);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void VerifyFilesHome() {
		ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
		home.accept(visitor);
		LinkedList<ApfsFile> actual = visitor.getFiles();
		LinkedList<ApfsFile> expected = new LinkedList<>();
		expected.add(a);
		expected.add(b);
		expected.add(c);
		assertArrayEquals(expected.toArray(), actual.toArray());
	}

}