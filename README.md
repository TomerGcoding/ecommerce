
# E-Commerce Backend System with RabbitMQ

## Author
- **Name:** Tomer Geva  
- **ID:** 318803681  

---

## Overview
This project implements a simplified backend system for an e-commerce platform using RabbitMQ. The system consists of two services:  
1. **Cart Service (Producer):** Accepts orders and broadcasts them to downstream services via RabbitMQ.  
2. **Order Service (Consumer):** Receives and processes order events, including calculating shipping costs and storing order details.

---

## API Endpoints

### Cart Service
- **Description:** Creates a new order and publishes the order details as an event to RabbitMQ.
- **Request Type:** POST  
- **URL:**  
  ```
  http://localhost:8080/create-order?orderId=ORD-12111&itemsNum=2
  ```
  Replace `ORD-12111` and `2` with the desired `orderId` and `itemsNum`.

---

### Order Service
- **Description:** Retrieves order details and calculates shipping costs.
- **Request Type:** GET  
- **URL:**  
  ```
  http://localhost:8081/order-details?orderId=ORD-12111
  ```
  Replace `ORD-12111` with the desired `orderId`.

---

## Running the Application
1. Start the **Cart Service**:
   ```bash
   docker-compose -f docker-compose-cart-service.yml up
   ```
   Wait until the RabbitMQ service and the `cart-service` are up and running.

2. Start the **Order Service**:
   ```bash
   docker-compose -f docker-compose-order-service.yml up
   ```

3. Test the services using Postman or any HTTP client:
   - Use the `POST` request to create an order via the `cart-service`.  
   - Use the `GET` request to retrieve order details via the `order-service`.  

4. Shut down both services:
   ```bash
   docker-compose -f docker-compose-order-service.yml down
   docker-compose -f docker-compose-cart-service.yml down
   ```

---

## Notes
- RabbitMQ Management Interface: `http://localhost:15672`  
  - **Username:** guest  
  - **Password:** guest  
- Ensure that all exposed ports (`8080`, `8081`, RabbitMQ ports) are available and not in use by other applications.
