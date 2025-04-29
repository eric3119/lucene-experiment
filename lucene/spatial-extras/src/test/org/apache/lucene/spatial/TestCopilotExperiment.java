package org.apache.lucene.spatial;

import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.spatial.prefix.tree.SpatialPrefixTreeFactory;
import org.apache.lucene.tests.util.LuceneTestCase;
import org.locationtech.spatial4j.context.SpatialContext;

public class TestCopilotExperiment extends LuceneTestCase {
    void testMakeSPTWithInvalidClassName_throwsException() {
        Map<String, String> args = new HashMap<>();
        args.put("prefixTree", "non.existent.ClassName");

        SpatialContext ctx = SpatialContext.GEO;

        Exception exception = assertThrows(Exception.class, () -> {
            SpatialPrefixTreeFactory.makeSPT(args, SpatialPrefixTreeFactory.class.getClassLoader(), ctx);
        });

        String message = exception.getMessage();
        assertTrue(message.contains("non.existent.ClassName"));
    }
}
