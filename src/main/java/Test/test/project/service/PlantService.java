package Test.test.project.service;

import Test.test.project.entity.PlantEntity;
import Test.test.project.repository.PlantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;

    //list에서 받아온 식물번호들로 세부내용 검색
    public void getDtl(String item) throws IOException {
        String urlStr = "http://api.nongsaro.go.kr/service/garden/gardenDtl?apiKey=202212290SGQFNOOOQJTTHHYQIRA&cntntsNo=";
        String pageURL = urlStr.concat(item);
        URL url = new URL(pageURL);
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

        StringBuffer rs = new StringBuffer();
        String result1;

        while ((result1 = bf.readLine()) != null) {
            rs.append(result1);
        }
        try {
            String xml = rs.toString();
            JSONObject jObject = XML.toJSONObject(xml);
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            Object json = mapper.readValue(jObject.toString(), Object.class);
            String output = mapper.writeValueAsString(json);
            //json 데이터 원하는 값 추출
            JSONObject jsonObject = new JSONObject(output);
            JSONObject response = jsonObject.getJSONObject("response");
            JSONObject body = response.getJSONObject("body");
            JSONObject items = body.getJSONObject("item");

            String distbNm = items.getString("distbNm");
            if (distbNm.isEmpty()){
                distbNm ="NULL";
            }
            PlantEntity plant = new PlantEntity(distbNm);
            plantRepository.save(plant);
            String plntbneNm = items.getString("plntbneNm");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCntntsNo(JSONArray itemArray, String key) {
        try {
            //JSONArray형식으로 파싱하기 위해 새로 선언해주며 itemArray를 집어 넣어준다.
            JSONArray array = new JSONArray(itemArray);
            //Json 배열 내 JSON 데이터 개수를 가져옴
            int list_cnt = array.length();

            //key의 value를 가져와 저장하기 위한 배열을 생성한다
            String item[] = new String[list_cnt]; //decription 저장용

            //JSONArray 내 json 개수만큼 for문 동작
            for (int i = 0; i < list_cnt; i++) {
                //i번째 Json데이터를 가져옴
                JSONObject jsO = array.getJSONObject(i);
                //cntntsNo(식물번호) 값을 배열에 저장
                item[i] = jsO.getString(key);
                //cntntsNo를 인자값으로 getDtl함수실행(세부내용 받아오기)
                getDtl(item[i]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void start() throws IOException {

        //모든 pageNo 검색해 xml을 json으로 바꿔주는 코드
        String urlStr = "http://api.nongsaro.go.kr/service/garden/gardenList?apiKey=202212290SGQFNOOOQJTTHHYQIRA&pageNo=";
        for (int i=1;i<23;i++){
            String pageURL=urlStr.concat(String.valueOf(i));
            URL url = new URL(pageURL);
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            StringBuffer rs = new StringBuffer();
            String result;

            while ((result = bf.readLine()) != null) {
                rs.append(result);
            }

            try {
                String xml = rs.toString();
                JSONObject jObject = XML.toJSONObject(xml);
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                Object json = mapper.readValue(jObject.toString(), Object.class);
                String output = mapper.writeValueAsString(json);
                //json 데이터 원하는 값 추출
                JSONObject jsonObject = new JSONObject(output);
                JSONObject response = jsonObject.getJSONObject("response");
                JSONObject body = response.getJSONObject("body");
                JSONObject items = body.getJSONObject("items");
                JSONArray item = items.getJSONArray("item");

                getCntntsNo(item, "cntntsNo");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

