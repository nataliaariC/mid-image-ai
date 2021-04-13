/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatbotgeek.sdkwebservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 62878
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtensionResult implements Serializable {

    private static final long serialVersionUID = 1768303005374821099L;
    private Map<String, String> info;
    private Map<String, List<Recipient>> result;
    private Map<String, String> value;

    public Map<String, String> getValue() {
        return value;
    }

    public void setValue(Map<String, String> value) {
        this.value = value;
    }

    public Map<String, List<Recipient>> getResult() {
        return result;
    }

    public void setResult(Map<String, List<Recipient>> result) {
        this.result = result;
    }

    public Map<String, String> getInfo() {
        return info;
    }

    public void setInfo(Map<String, String> info) {
        this.info = info;
    }

    

}
