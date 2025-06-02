package com.example.iosiapdemo.model

data class VerifyReceiptRequest(
    val receiptData: String,
    val password: String? = null,
    val isSandbox: Boolean = true
)
