import org.junit.Test;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.tools.shell.Global;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import static org.apache.commons.io.IOUtils.closeQuietly;

/**
 * User: alexkasko
 * Date: 5/15/16
 */
public class WiltonRhinoTest {

    @Test
    public void test() throws Exception {
        Context cx = Context.enter();
        cx.setOptimizationLevel(-1);
        Global gl = new Global();
        gl.init(cx);
        {
            InputStream is = null;
            try {
                is = new FileInputStream("js/wilton.js");
                Reader re = new InputStreamReader(is, "UTF-8");
                cx.evaluateReader(gl, re, "wilton.js", -1, null);
            } finally {
                closeQuietly(is);
            }
        }
        {
            InputStream is = null;
            try {
                is = WiltonRhinoTest.class.getResourceAsStream("/wilton_test.js");
                Reader re = new InputStreamReader(is, "UTF-8");
                cx.evaluateReader(gl, re, "wilton_test.js", -1, null);
            } finally {
                closeQuietly(is);
            }
        }
    }
}