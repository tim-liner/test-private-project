# iOS In-App Purchase Demo

This project demonstrates a simple Kotlin Spring Boot server that verifies iOS in-app purchase receipts. It exposes an endpoint that a client can call to verify a subscription receipt using Apple's `verifyReceipt` API.

## Building

This project uses Gradle. To build and run the tests:

```bash
./gradlew test
```

## Running

To start the application locally:

```bash
./gradlew bootRun
```

The server will start on port `8080`. The `/api/ios/verify-receipt` endpoint accepts a JSON body containing the base64 `receiptData`, optional shared-secret `password`, and a flag `isSandbox` to determine which Apple endpoint to use.
