package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.fs.FSElement;

public class APFSTest {

	@Test
	public void FileSysRtrnNonNullVal() {
		assertNotNull(APFS.getApfs());
	}

	@Test
	public void FileSysRtrnIdenticalInstances() {
		APFS a1 = APFS.getApfs();
		APFS a2 = APFS.getApfs();
		assertSame(a1, a2);
	}
	
	@Test
	public void InitAndRootDirTest() {
		APFS apfs = APFS.getApfs();
		FSElement expected = apfs.init("apfs", 1000);
		ApfsDirectory actual = apfs.getRootDir();
		assertSame(expected, actual);
	}

}