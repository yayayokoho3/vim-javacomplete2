package kg.ash.javavi.searchers;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.io.File;
import java.util.List;

public class SourceFileVisitorTest {

    @Test
    public void testCorrect() {
        SourceFileVisitor visitor = new SourceFileVisitor("foo.bar.Baz");
        visitor.visitFile(new File("src/foo/bar/Baz.java").toPath(), null);

        Assert.assertEquals("src/foo/bar/Baz.java", visitor.getTargetFile());

        visitor = new SourceFileVisitor("Baz");
        visitor.visitFile(new File("src/foo/bar/Baz.java").toPath(), null);

        Assert.assertEquals("src/foo/bar/Baz.java", visitor.getTargetFile());
    }

    @Test
    public void testEmptyClassname() {
        SourceFileVisitor visitor = new SourceFileVisitor("");
        visitor.visitFile(new File("src/foo/bar/Baz.java").toPath(), null);

        Assert.assertEquals(null, visitor.getTargetFile());
    }

    @Test
    public void testSimilarPackageShouldNotBeFound() {
        SourceFileVisitor visitor = new SourceFileVisitor("foo.baz.Baz");
        visitor.visitFile(new File("src/foo/bar/Baz.java").toPath(), null);

        Assert.assertEquals(null, visitor.getTargetFile());
    }
    
}