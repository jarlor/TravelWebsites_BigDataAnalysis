package DataProcess.CountWordbyLocal.GetData;

import DataToHbase.HotelComment;
import DataToHbase.SaveData;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GCJL
 * @date 2021/5/7 14:59
 */
public class getData {
    public static List<String> getDataFromLocal() throws IOException {
        InputStream resourceAsStream = SaveData.class.getClassLoader().getResourceAsStream("comment.txt");
        String readFileToString = IOUtils.toString(resourceAsStream, "UTF-8");
        List<HotelComment> result = JSONObject.parseArray(readFileToString, HotelComment.class);

        String content = null;
        String rowkey = null;

        ArrayList<String> value = new ArrayList<>();

        for (HotelComment comment : result) {
            content = comment.getContent();
            value.add(content);
        }
        return value;


    }
}
