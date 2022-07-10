package fold;

import fold.model.FoldFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.File;
import java.nio.file.Files;
import java.util.Objects;

public class ImporterExporterTest extends BaseFoldTest {
    @Test
    public void testLoadAndSaveFoldFile() throws Exception {
        File saveFile = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("fold/basic.fold")).getFile());

        FoldFile foldFile = importer.importFile(saveFile);

        File exportFile = File.createTempFile("export", ".fold");

        exporter.exportFile(exportFile, foldFile);

        String expected = Files.readString(saveFile.toPath());
        String actual = Files.readString(exportFile.toPath());
        JSONAssert.assertEquals(expected, actual, true);

        FoldFile foldFile2 = importer.importFile(exportFile);

        Assertions.assertEquals(foldFile, foldFile2);
    }
}
