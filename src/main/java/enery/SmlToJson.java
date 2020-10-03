package enery;

import org.openmuc.jsml.structures.SmlFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class SmlToJson {

    public SmlToJson() {
    }

    public JsonValues transform(SmlFile smlFile) {
        SmlFileWorker smlWorker = new SmlFileWorker();
        try {
            smlWorker.setSmlFile(smlFile);
        } catch (IOException e) {
            System.out.println("Exception on setSmlFile methode:" + e);
            e.printStackTrace();
        }
        return smlWorker.getSMLAsJson();
    }

}
