package com.chatbotgeek.sdkwebservice.service;

import com.chatbotgeek.sdkwebservice.model.ExtensionRequest;
import com.chatbotgeek.sdkwebservice.model.ExtensionResult;

public interface IService {
    ExtensionResult getImageBase64 (ExtensionRequest extensionRequest);
    ExtensionResult postImage(ExtensionRequest extensionRequest);

}
