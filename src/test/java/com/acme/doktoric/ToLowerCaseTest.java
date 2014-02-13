package com.acme.doktoric;

import com.acme.doktoric.core.BaseMorphlineTest;
import com.acme.doktoric.core.TestBasedFileReader;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.kitesdk.morphline.api.AbstractMorphlineTest;
import org.kitesdk.morphline.api.Record;
import org.kitesdk.morphline.base.Fields;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Ricsi on 2014.02.13..
 */
public class ToLowerCaseTest extends BaseMorphlineTest {

    @Test
    public void testLowerCaseFunctionReturnLowerCasedString() throws Exception {
        morphline = createMorphline("test-morphlines/simpleToLower");
        Record record = new Record();
        record.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("input/simpleToLower"));
        assertTrue(morphline.process(record));
        Record expected = new Record();
        expected.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("expected/simpleToLower"));
        assertThat(expected, equalTo(collector.getRecords().get(0)));
    }

    @Test
    public void testLowerCaseFunctionWithMoreLineReturnLowerCasedString() throws Exception {
        morphline = createMorphline("test-morphlines/simpleToLower");
        Record record = new Record();
        record.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("input/simpleToLowerWithMoreLine"));
        assertTrue(morphline.process(record));
        Record expected = new Record();
        expected.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("expected/simpleToLowerWithMoreLine"));
        assertThat(expected, equalTo(collector.getRecords().get(0)));
    }
}
