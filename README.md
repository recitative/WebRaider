# WebRaider

> [!WARNING]
> The author is not responsible for your actions. This program is intended for educational purposes only and should be used by professionals.

WebRaider is a powerful tool for load testing websites. It allows users to simulate multiple requests to a target site to evaluate its performance under stress and understand how it behaves under heavy traffic conditions.

## Features

- Simulate multiple concurrent users to test website performance.
- Monitor response times and server behavior under load.
- Support for various HTTP methods (GET, POST, PUT, DELETE, etc.).
- Detailed reporting of HTTP status codes, response times, and error rates.

## Installation

1. Clone the repository:

bash
   git clone https://github.com/recitative/WebRaider.git


2. Install dependencies:

bash
   cd WebRaider
   pip install -r requirements.txt


## Usage

Run the following command to start a load test:

bash
python webraider.py --url http://example.com --users 100 --duration 60


## HTTP Status Codes

For a detailed list of HTTP status codes, see [HTTP_STATUS_CODES.md](HTTP_STATUS_CODES.md).

## Authors

- [Sma1lo_](https://github.com/Sma1lo) - Main Developer

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contributing

We welcome contributions! Please see our [CONTRIBUTING.md](CONTRIBUTING.md) for more details.