package com.chatbotgeek.sdkwebservice.service;

import com.chatbotgeek.sdkwebservice.model.ExtensionRequest;
import com.chatbotgeek.sdkwebservice.model.ExtensionResult;
import com.chatbotgeek.sdkwebservice.model.ParamBuilder;
import com.chatbotgeek.sdkwebservice.model.Recipient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatbotgeek.sdkwebservice.property.AppProperties;
import com.ea.async.Async;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;

import okhttp3.MediaType;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class ServiceImp implements IService {

    private static SecureRandom random = new SecureRandom();

    /**
     * different dictionaries used
     */
    private final static Logger logger = Logger.getLogger(ServiceImp.class);
    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^*_=+-/";
    private static final String PATH = "E:\\IT_Operation\\Groups\\";
    public static final String OUTPUT = "output";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final String KEY = "log4j.appender.file.File";

    @Autowired
    AppProperties appProperties;

    private String getBase64(String token, String id) {
        String result = "";
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get(appProperties.getUrlKataImage() + id)
                    .header("Authorization", token)
                    .asString();
            InputStream is = response.getRawBody();
//            OutputStream os = new FileOutputStream("C:\\tmp\\gambar1.jpg");
//            byte[] b = new byte[2048];
//            int length;
//            while ((length = is.read(b)) != -1) {
//                os.write(b, 0, length);
//            }
//            is.close();
//            os.close();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = is.read(buffer, 0, buffer.length)) != -1) {
                baos.write(buffer, 0, read);
            }
            baos.flush();
            result = Base64.encodeBase64String(baos.toByteArray());
        } catch (Exception e) {
        }
        return result;
    }

    public ExtensionResult getImageBase64(ExtensionRequest extensionRequest) {
        ExtensionResult er = new ExtensionResult();
        Map<String, String> output = new HashMap<>();
        String id = extensionRequest.getId();
        String token = getToken();
        String base64 = getBase64(token, id);
        output.put("image", base64);
        er.setValue(output);
        return er;
    }

    private String getToken() {
        String token = "";
        try {
            String body = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", appProperties.getKataUsername(), appProperties.getKataPassword());
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post(appProperties.getUrlKataLogin())
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asString();
            JSONObject jObj = new JSONObject(response.getBody());
            token = "Bearer " + jObj.getString("access_token");
        } catch (Exception ex) {
        }
        return token;
    }

    public ExtensionResult postImage(ExtensionRequest extensionRequest) {
        ExtensionResult er = new ExtensionResult();
        Map<String, String> output = new HashMap<>();
        String id = extensionRequest.getId();
        String latitude = extensionRequest.getLatitude();
        String longitude = extensionRequest.getLongitude();
        String phone = extensionRequest.getPhone();
        
        String customer_id = extensionRequest.getCustomer_id();
        String token = getToken();
        String base64 = getBase64(token, id);
        JSONObject json = new JSONObject();
        Unirest.setTimeouts(0, 0);
        JSONObject obj = new JSONObject();
        obj.put("image", base64);
        obj.put("latitude", latitude);
        obj.put("longitude", longitude);
        obj.put("phone", phone);
        obj.put("customer_id", customer_id);
       
       // obj.append("id", id);
        System.out.println(obj.toString());
        String suc = "Terimakasih foto yang Anda kirim sudah tersimpan";
        String fail = "Maaf foto yang anda kirimkan tidak sesuai !";
        try {
            HttpResponse<String> response = Unirest.post("http://ec2-3-0-26-91.ap-southeast-1.compute.amazonaws.com:8080/detectObject")
                    .header("Content-Type", "application/json")
                    .body(obj.toString())
                    .asString();
            System.out.println(response.getBody());
           json = new JSONObject(response.getBody());
           JSONArray arr = json.getJSONArray("prediction");
            
           
           if (arr.length() == 0) {
                System.out.println(fail);
            } else {
                System.out.println(suc);
            }
            
        } catch (UnirestException ex) {
            java.util.logging.Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        //output.put("image", base64);
        output.put("result", suc);
        er.setValue(output);
        return er;
    }
}
