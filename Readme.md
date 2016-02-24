# EMiL - Rosetta integration plugin

A microservice retrieving data from Rosetta, returning JSON or XML based on HTTP content negotiation (default: JSON).

Usage:

    GET http://hostname/IE12345

    { 
      "objectId": "IE12345",
      "files": [
        { "fileId": "FL12312.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12312&dps_func=stream" },
        { "fileId": "FL12313.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12313&dps_func=stream" },
        { "fileId": "FL12314.iso", "type": "ISO", "url": "http://rosetta-hostname/delivery/DeliveryManagerServlet?dps_pid=FL12314&dps_func=stream" }
      ]
    }
