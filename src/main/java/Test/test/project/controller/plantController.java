package Test.test.project.controller;

import Test.test.project.dto.plantDto;
import Test.test.project.entity.plantRepository;
import Test.test.project.entity.plantEntity;
import Test.test.project.service.plantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class plantController {
    @Autowired
    public static plantRepository plantRepository;
    public static void main(String args[]){
        plantRepository.save(new plantEntity(7L,"123"));


    }
//    private final plantService plantService;
//
//    public void write(plantDto plantDto){
//        plantService.savePlant(plantDto);
//    }








//    public static void arrayFun(JSONArray itemArray, String key) {
//        try {
//            JSONArray array = new JSONArray(itemArray); //JSONArray형식으로 파싱하기 위해 새로 선언해주며 eventArray를 집어 넣어준다.
//            int list_cnt = array.length(); //Json 배열 내 JSON 데이터 개수를 가져옴
//
//            //key의 value를 가져와 저장하기 위한 배열을 생성한다
//            String item[] = new String[list_cnt]; //decription 저장용
//
//            for (int i = 0; i < list_cnt; i++) { //JSONArray 내 json 개수만큼 for문 동작
//                JSONObject jsO = (JSONObject) array.get(i); //i번째 Json데이터를 가져옴
//                plantEntity entity = new plantEntity("123");
//                insert(entity);
////                item[i] = jsO.getString(key);  //cntntsNo(식물번호) 값을 배열에 저장
////                System.out.print("{" + item[i] + "}");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void xmlToJson(String str) {
//        try {
//            String xml = str;
//            JSONObject jObject = XML.toJSONObject(xml);
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.enable(SerializationFeature.INDENT_OUTPUT);
//            Object json = mapper.readValue(jObject.toString(), Object.class);
//            String output = mapper.writeValueAsString(json);
//            //json 데이터 원하는 값 추출
//            JSONObject jsonObject = new JSONObject(output);
//            JSONObject response = jsonObject.getJSONObject("response");
//            JSONObject body = response.getJSONObject("body");
//            JSONObject items = body.getJSONObject("items");
//            JSONArray item = items.getJSONArray("item");
//
//            arrayFun(item, "cntntsNo");
//
////                try {
////                    JSONArray array = new JSONArray(item); //JSONArray형식으로 파싱하기 위해 새로 선언해주며 eventArray를 집어 넣어준다.
////                    int list_cnt = array.length(); //Json 배열 내 JSON 데이터 개수를 가져옴
////
////                    //key의 value를 가져와 저장하기 위한 배열을 생성한다
////                    String getcntntsNo[] = new String[list_cnt]; //decription 저장용
////
////                    for (int i = 0; i < list_cnt; i++) { //JSONArray 내 json 개수만큼 for문 동작
////
////                        JSONObject jsO = array.getJSONObject(i); //i번째 Json데이터를 가져옴
////                        getcntntsNo[i] = jsO.getString("cntntsNo");  //cntntsNo(식물번호) 값을 배열에 저장
//////                    System.out.println(output);
////                        System.out.print("{"+getcntntsNo[i]+"}");
//////                        System.out.println(item.getJSONObject(i).getString("cntntsNo"));
////                    }
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
////            System.out.println(output);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args) throws IOException {
//
//        //모든 pageNo 검색해 xml을 json으로 바꿔주는 코드
//        String urlStr = "http://api.nongsaro.go.kr/service/garden/gardenList?apiKey=202212290SGQFNOOOQJTTHHYQIRA&pageNo=";
//        for (int i=1;i<23;i++){
//            String pageURL=urlStr.concat(String.valueOf(i));
//            URL url = new URL(pageURL);
//            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//
//            StringBuffer rs = new StringBuffer();
//            String result;
//
//            while ((result = bf.readLine()) != null) {
//                rs.append(result);
//            }
//            plantEntity entity = new plantEntity("123");
////            xmlToJson(rs.toString());
//        }
//    }
}
