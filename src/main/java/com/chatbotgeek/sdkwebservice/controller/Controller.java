package com.chatbotgeek.sdkwebservice.controller;

import com.chatbotgeek.sdkwebservice.model.ExtensionRequest;
import com.chatbotgeek.sdkwebservice.model.ExtensionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.chatbotgeek.sdkwebservice.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class Controller {

	@Autowired
	IService svcService;
/*        @RequestMapping("/sendMessage")
    @PostMapping
    public ExtensionResult sendMessage(@RequestBody ExtensionRequest extensionRequest) {
        return svcService.sendMessage(extensionRequest);
    }
*/
    @RequestMapping("/postImage")
    @PostMapping
    public ExtensionResult postImage(@RequestBody ExtensionRequest extensionRequest) {
        return svcService.postImage(extensionRequest);
    }
    @RequestMapping("/getImageBase64")
    @PostMapping
    public ExtensionResult getImageBase64(@RequestBody ExtensionRequest extensionRequest) {
        return svcService.getImageBase64(extensionRequest);
    }
    @RequestMapping("/hi")
    @GetMapping
    public String hi() {
        return "hi";
    }
}
