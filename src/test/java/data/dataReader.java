package data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class dataReader {

    public List<HashMap<String, String>> getJsaonDatamap() throws IOException {

        String JasonData = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//data//purchaseOrder.json"), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
      List<HashMap<String,String>> data =  mapper.readValue(JasonData, new TypeReference<List<HashMap<String,String>>>() {
        });
      return data;
    }
}
