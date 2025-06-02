package com.example.iosiapdemo.controller

import com.example.iosiapdemo.model.VerifyReceiptRequest
import com.example.iosiapdemo.service.ReceiptService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ios")
class ReceiptController(private val receiptService: ReceiptService) {

    @PostMapping("/verify-receipt")
    fun verifyReceipt(@RequestBody request: VerifyReceiptRequest): ResponseEntity<String> {
        val result = receiptService.verifyReceipt(request)
        return ResponseEntity.ok(result)
    }
}
