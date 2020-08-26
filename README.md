
### FAQ - how to execute tests

#### local execution as usual via any IDE or from command line

all test
    
    mvn clean compile test site
 
specific class name
    
    mvn clean compile test site -Dtest=[className]
    e.g. mvn clean compile test site -Dtest=LoginPageTests
    
run with properties

    e.g. mvn clean compile test site -Dtest=LoginPageTests -Dtest.driver.touse=chrome -Dtest.host=http://site.com -Dtest.hub=http://myhub:4444/wd/hub

parallel mode via mvn, the same as above

    comment / uncomment configuration section under maven-surefire-plugin 

### You can find a report if site option including for mvn here-> 
    target/site/surefire-report.html 
    mvn clean compile test site --> report is expected
    mvn clean compile test      --> report is NOT expected
    
 
##### The following properties could be used in tests:
* test.hub - define hub url; def = "http://localhost:4444/wd/hub"
* test.host - define domain to test; def = "http://automationpractice.com"
* test.driver.touse - define a browser to use; def - "CHROME"