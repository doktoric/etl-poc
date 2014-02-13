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
public class CapitalizeTest extends BaseMorphlineTest {

    @Test
    public void testCapitalizeFunctionReturnLowerCasedString() throws Exception {
        morphline = createMorphline("test-morphlines/simpleCapitalize");
        Record record = new Record();
        record.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("input/simpleCapitalize"));
        assertTrue(morphline.process(record));
        Record expected = new Record();
        expected.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("expected/simpleCapitalize"));
        assertThat(expected, equalTo(collector.getRecords().get(0)));
    }

    @Test
    public void testCapitalizeFunctionWithMoreLineReturnLowerCasedString() throws Exception {
        morphline = createMorphline("test-morphlines/simpleCapitalize");
        Record record = new Record();
        record.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("input/simpleCapitalizeWithMoreLine"));
        assertTrue(morphline.process(record));
        Record expected = new Record();
        expected.put(Fields.MESSAGE, TestBasedFileReader.getFileContent("expected/simpleCapitalizeWithMoreLine"));
        assertThat(expected, equalTo(collector.getRecords().get(0)));
    }
}
