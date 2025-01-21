# Spring Boot WebSocket Chat Application

This is a simple chat application built using Spring Boot and WebSocket. The application allows users to join a chat room, send messages, and receive messages in real-time.

## Features

- Real-time messaging using WebSocket
- User join and leave notifications
- Simple and intuitive UI

## Technologies Used

- Java
- Spring Boot
- WebSocket
- Maven
- HTML/CSS/JavaScript

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/chat-application.git
   cd chat-application
   ```

2. Build the project using Maven:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

4. Open your browser and navigate to `http://localhost:8080`.

## Project Structure

- `src/main/java/com/olaaref/chat/controller/ChatController.java`: Handles WebSocket messages for sending chat messages and adding users.
- `src/main/java/com/olaaref/chat/config/WebSocketEventListener.java`: Listens for WebSocket disconnection events and processes them.
- `src/main/resources/static/index.html`: The main HTML file for the chat application.
- `src/main/resources/static/js/main.js`: JavaScript file for handling WebSocket connections and UI interactions.
- `src/main/resources/static/css/main.css`: CSS file for styling the chat application.

## Usage

1. Open the application in your browser.
2. Enter a username to join the chat room.
3. Start sending messages and see them appear in real-time.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [SockJS](https://github.com/sockjs/sockjs-client)
- [STOMP](https://stomp.github.io/)
