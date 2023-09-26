package com.it.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.it.utils.QrCodePromptpay;

@RestController
public class QrcodeController {
 @Autowired
 private QrCodePromptpay QrCodeUtils;
 @GetMapping("/generate-to-base64")
 public ResponseEntity<String> generateQrcodeTobase64(@RequestParam(name="amount") BigDecimal amount)throws IOException,WriterException{
	 String base64Res = QrCodeUtils.generateQrcodetobase64(amount);
	 return ResponseEntity.ok(base64Res);
 }
 @GetMapping("/generate-to-byte-array")
 public ResponseEntity<byte[]> generateQrcodeToByteArray(@RequestParam(name="amount") BigDecimal amount )throws IOException,WriterException{
	 byte[] byteRes = QrCodeUtils.generateQrcodeToByteArray(amount);
	 return ResponseEntity.ok(byteRes);
 }
}
