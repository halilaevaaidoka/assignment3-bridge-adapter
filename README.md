
# Photography Delivery System

**Student:** Aida Khalila  
**Assignment 3:** Bridge & Adapter Design Patterns  
**Language:** Java 26  
**Build Tool:** Maven

## 1. Project Description

Photography Delivery System is a Java application that demonstrates the Bridge and Adapter design patterns in one integrated system.

The application supports different photo delivery types and delivery services.

## 2. Bridge Pattern

The Bridge pattern separates photo delivery types from delivery implementations.

### Components

- Abstraction: PhotoDelivery
- Refined Abstractions: SinglePhotoDelivery, AlbumDelivery
- Implementor: DeliveryService
- Concrete Implementors: CloudDeliveryService, EmailDeliveryService, LegacyDeliveryAdapter

The abstraction uses the DeliveryService interface, allowing delivery implementations to change independently.

## 3. Adapter Pattern

The Adapter pattern integrates an existing legacy photo service into the new delivery system.

### Components

- Target: DeliveryService
- Adaptee: LegacyPhotoService
- Adapter: LegacyDeliveryAdapter

LegacyDeliveryAdapter converts the deliver() call into the legacy sendOldPhoto() call.

The adapter also acts as the third Bridge implementation.

## 4. Dynamic Implementor Selection

DeliveryServiceSelector dynamically selects the delivery service based on the input:

- cloud → CloudDeliveryService
- email → EmailDeliveryService
- legacy → LegacyDeliveryAdapter

The client can switch implementations without modifying the abstraction classes.

## 5. Project Structure

src/main/java/
- kz.aida/Main.java
- kz.aida.photography.abstraction/
- kz.aida.photography.implementor/
- kz.aida.photography.adapter/
- kz.aida.photography.legacy/
- kz.aida.photography.selection/

src/test/java/
- kz.aida.photography/DeliveryServiceSelectorTest.java
- kz.aida.photography/BridgeAdapterTest.java

## 6. How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 26 is configured.
3. Reload Maven dependencies.
4. Run Main.java.

## 7. Expected Output

Cloud delivery: PHOTO-101 to Aida
Email delivery: ALBUM-2026 to Assiya
Legacy delivery: OLD-001 to Aida
Legacy delivery: ALBUM-2026-GALLERY to Aida

## 8. Testing

JUnit 5 is used for testing.

DeliveryServiceSelectorTest verifies:
- Cloud selection
- Email selection
- Legacy Adapter selection
- Invalid delivery type handling

BridgeAdapterTest verifies:
- Single photo delivery with Cloud
- Album delivery with Email
- Bridge integration with Legacy Adapter

Run all tests using:

mvn test

## 9. UML Diagram

The UML diagram illustrates the Bridge and Adapter components and their relationships.

## 10. Conclusion

The project demonstrates how Bridge separates abstractions from implementations and how Adapter integrates an incompatible legacy service.

Both patterns work together in one application.
