FROM maven:3.9.12-eclipse-temurin-21
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    curl

RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | \
    gpg --dearmor -o /usr/share/keyrings/google.gpg

RUN echo "deb [signed-by=/usr/share/keyrings/google.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google.list

RUN apt-get update && apt-get install -y google-chrome-stable
WORKDIR /app
 
COPY . .
 
RUN mvn clean install -DskipTests
 
CMD ["mvn","-Dtest=runner.TestRunner","test"]