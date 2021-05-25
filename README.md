# stock-app
Stock App - Personal Project

Users pick stocks/ETFs to follow our just get info on
Users can make accounts and look in on the list of stocks/ETFs they follow
Users can set an alert time to get alerted on a specific stock or even their whole follow-list 
--Alerts could be email or text
Stock data will come from finnhub:
https://finnhub.io/docs/api/quote 

# Back End
---------------------
Business Logic:
Java
Spring Data
Spring Security
MQ for alerting users (rabbitMq?)

Persistence:
Postgres

Front End:
Thymeleaf and CSS

Future Considerations:
Display changes in a stocks price over a period of time
 ex) AAPL is up 5% since 2 weeks ago. MSFT is down 2% since 3 days ago.
Create a Front End using Angular or React
