package com.example.iosiapdemo.service

import com.example.iosiapdemo.model.VerifyReceiptRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ReceiptService {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val restTemplate = RestTemplate()

    fun verifyReceipt(request: VerifyReceiptRequest): String {
        val url = if (request.isSandbox) {
            "https://sandbox.itunes.apple.com/verifyReceipt"
        } else {
            "https://buy.itunes.apple.com/verifyReceipt"
        }

        val body = mapOf(
            "receipt-data" to request.receiptData,
            "password" to request.password
        )

        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        val httpEntity = HttpEntity(body, headers)
        logger.info("Sending verifyReceipt request to $url")
        val response = restTemplate.postForEntity(url, httpEntity, String::class.java)
        return response.body ?: ""
    }
}
