# Clinic Scheduling Server

Welcome to the Clinic Scheduling Server, a backend API for managing appointments and scheduling in a clinic setting.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
  - [Endpoints](#endpoints)
- [Contributing](#contributing)

## Introduction

The Clinic Scheduling Server is a RESTful API built to facilitate appointment scheduling and management within a clinic. It provides endpoints for creating, updating, and deleting appointments, as well as retrieving appointment information.

## Features

- Create new appointments with client details and preferred time slots.
- Update and cancel existing appointments.
- Retrieve a list of all appointments or appointments for a specific client.
- Flexible configuration for appointment slots and working hours.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 11 or higher
- Apache Maven
- MySQL or another relational database

### Installation

1. Clone this repository to your local machine.
2. Configure the database settings in the `application.properties` file.
3. Build the project using Maven: `mvn clean install`
4. Run the server: `java -jar target/demo-0.0.1-SNAPSHOT.jar`

### Configuration

- Database settings can be configured in the `src/main/resources/application.properties` file.
- Working hours, appointment duration, and other scheduling settings can be adjusted in the configuration files.

## Usage

### Endpoints
Example: Appointment Entity
- `GET /appointments`: Get a list of all appointments.
- `GET /appointments/{appointmentId}`: Get details of a specific appointment.
- `POST /appointments`: Create a new appointment.
- `PUT /appointments/{appointmentId}`: Update an existing appointment.
- `DELETE /appointments/{appointmentId}`: Cancel an appointment.

For detailed information about all available endpoints, request examples, and responses, please refer to the OpenAPI specification at 
`http://localhost:8080/swagger-ui/index.html` after running the server

## Contributing

Contributions to the Clinic Scheduling Server project are welcome! Please follow the [Contribution Guidelines](CONTRIBUTING.md) to get started.

