package terminal.bank.accountdatas.operationsdatas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class SaveDatas {

    public void jsonFiles(DatasRercording datasRecording) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writing = new FileWriter(datasRecording.name() + ".json");
        writing.write(gson.toJson(datasRecording));
        writing.close();

    }
    //SaveDatas saveDatas = new SaveDatas();
    //saveDatas.jsonFiles(myDatas);
}
