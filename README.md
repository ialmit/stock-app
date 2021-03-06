# stock-app
Stock App - Personal Project

Stock data will come from finnhub:
https://finnhub.io/docs/api/quote 

Users pick stocks/ETFs to follow our just get info on
Users can make accounts and look in on the list of stocks/ETFs they follow
Users can set an alert time to get alerted on a specific stock or even their whole follow-list 
--Alerts could be email or text
Users will have a "Recently Viewed" section which contains stocks/ETFs they searched for recently 
--Up to 5 stocks/ETFs will be in this section

# Business Logic:
- Java
- Spring MVC
- Spring Data JPA
- Spring Security

# Database:
- Postgres

# CI/CD:
- Jenkins

# Front End:
- Thymeleaf and CSS

# Deploy to AWS:
- EC2
- Tomcat

# Future Considerations:
- Display changes in a stocks price over a period of time
 - ex) AAPL is up 5% since 2 weeks ago. MSFT is down 2% since 3 days ago.
- Create a Front End using Angular or React
- Add MQ for alerting users
- Create a CI/CD pipeline using AWS native tools
