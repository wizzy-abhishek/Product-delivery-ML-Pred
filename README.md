# 🚚 Delivery — Spring Boot Backend

The backend service for an e-commerce delivery platform. Handles vendor registration, product management, and integrates with the ML microservice to provide **AI-powered delivery date predictions** with probability breakdowns.

---

## 🏗️ Project Structure

```
com.ecom.delivery
├── controller
│   ├── ProductController          # Product endpoints
│   └── VendorRegisterController   # Vendor registration endpoints
├── dto
│   ├── registration
│   │   ├── AddressDTO
│   │   ├── ProductAdditionRequestDTO
│   │   └── VendorRegistrationDTO
│   └── response
│       ├── DeliveryPredictionResponse   # ML model response mapping
│       └── ProductResponseDTO
├── entity
│   ├── enums
│   │   ├── ProductCategory        # STANDARD / DELICATE
│   │   ├── ProductType
│   │   └── Weight                 # Weight bucket enum
│   ├── Address
│   ├── Buyer
│   ├── Product
│   └── Vendor
├── repo
│   ├── AddressRepo
│   ├── BuyerRepo
│   ├── ProductRepo
│   └── VendorRepo
└── service
    ├── ProductService             # Interface
    ├── VendorService              # Interface
    └── impl
        ├── DeliveryPredictionService  # Calls Flask ML microservice
        ├── ProductServiceImpl
        └── VendorServiceImpl
```

---

## 🛠️ Tech Stack

| Component | Technology |
|---|---|
| Framework | Spring Boot |
| Language | Java |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| ML Integration | RestTemplate → Flask API |
| Build Tool | Maven |

---

## ⚙️ Configuration

### `application.yml`
```yaml
spring:
  application:
    name: delivery

  datasource:
    url: jdbc:postgresql://localhost:5432/ecom_delivery
    username: postgres
    password: ${PASSWORD}
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

ml_model: http://127.0.0.1:5000/predict
```

Set the database password as an environment variable — never hardcode it:
```bash
export PASSWORD=your_postgres_password
```

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- PostgreSQL running locally on port `5432`
- Flask ML microservice running on port `5000`

### Setup

**1. Create the database**
```sql
CREATE DATABASE ecom_delivery;
```

**2. Set environment variable**
```bash
export PASSWORD=your_postgres_password
```

**3. Start the Flask ML service first**
```bash
cd Delivery_prediction
source venv/bin/activate
python app.py
```

**4. Run Spring Boot**
```bash
./mvnw spring-boot:run
```

---

## 📡 API Endpoints

### Vendor
| Method | Endpoint | Description |
|---|---|---|
| POST | `/vendor/register` | Register a new vendor with address |

### Product
| Method | Endpoint | Description |
|---|---|---|
| POST | `/product/add` | Add a product and get delivery prediction |
| GET | `/product/{id}` | Get product details |

---

## 🤖 ML Integration

`DeliveryPredictionService` calls the Flask ML microservice internally whenever a delivery prediction is needed. Spring sends shipment details and receives back a probability-based delivery window.

**Request sent to Flask:**
```json
{
  "pickup_prefix": 20,
  "delivery_prefix": 81,
  "product_category": "DELICATE",
  "weight_bucket": "Medium Parcel"
}
```

**Response from Flask:**
```json
{
  "predicted_day": 3,
  "weather_used": "SUNNY",
  "top_3_days": [
    { "day": 3, "probability": 60.0 },
    { "day": 2, "probability": 21.4 },
    { "day": 4, "probability": 17.2 }
  ]
}
```

This response is mapped into `DeliveryPredictionResponse` and returned to the client.

---

## 🗄️ Database Schema

Hibernate auto-generates tables on startup via `ddl-auto: update`. Core entities are `Vendor`, `Buyer`, `Product`, and `Address` — all linked relationally via JPA mappings.

---

## 🔭 Future Improvements

- [ ] Add Spring Security for vendor authentication
- [ ] Add order tracking entity and endpoints
- [ ] Cache ML predictions for repeated pincode pairs (Redis)
- [ ] Switch from `RestTemplate` to `WebClient` for async ML calls
- [ ] Add Swagger/OpenAPI documentation
