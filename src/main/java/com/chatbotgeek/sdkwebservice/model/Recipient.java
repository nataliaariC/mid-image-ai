
package com.chatbotgeek.sdkwebservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author 62878
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipient {
    private String whatsapp_id;
    private String status;
    private String reason;

    public String getWhatsapp_id() {
        return whatsapp_id;
    }

    public void setWhatsapp_id(String whatsapp_id) {
        this.whatsapp_id = whatsapp_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
}
