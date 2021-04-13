/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatbotgeek.sdkwebservice.model;

/**
 *
 * @author 62878
 */
public class ParamBuilder {
    public  String writeParam(String value){
        StringBuilder sb = new StringBuilder();
        sb
                .append("{\"type\":\"text\",")
                .append("\"text\":\"" + value +"\"},");
        return sb.toString();
    }
}
