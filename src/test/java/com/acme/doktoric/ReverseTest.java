package com.acme.doktoric;

import com.acme.doktoric.core.BaseMorphlineTest;
import com.acme.doktoric.core.TestBasedFileReader;
import org.junit.Test;
import org.kitesdk.morphline.api.Record;
import org.kitesdk.morphline.base.Fields;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Ricsi on 2014.02.13..
 */
public class ReverseTest extends BaseMorphlineTest {

    @Test
    public void testReverseFunctionReturnLowerCasedString() throws Exception {
        morphline = createMorphline("test-morphlines/simpleReverse");
        Record record = new Record();
        record.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("input/simpleReverse"));
        assertTrue(morphline.process(record));
        Record expected = new Record();
        expected.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("expected/simpleReverse"));
        assertThat(expected, equalTo(collector.getRecords().get(0)));
    }

    @Test
    public void testReverseFunctionWithMoreLineReturnLowerCasedString() throws Exception {
        morphline = createMorphline("test-morphlines/simpleReverse");
        Record record = new Record();
        record.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("input/simpleReverseWithMoreLine"));
        assertTrue(morphline.process(record));
        Record expected = new Record();
        expected.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("expected/simpleReverseWithMoreLine"));
        assertThat(expected, equalTo(collector.getRecords().get(0)));
    }
}
