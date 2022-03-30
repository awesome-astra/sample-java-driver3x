# Connect to Astra with Java Cassandra Drivers version 3.x

## 📦. Prerequisites [ASTRA]

- You should have an [Astra account](http://astra.datastax.com/)
- You should [Create and Astra Database](https://github.com/datastaxdevs/awesome-astra/wiki/Create-an-AstraDB-Instance)
- You should [Have an Astra Token](https://github.com/datastaxdevs/awesome-astra/wiki/Create-an-Astra-Token)
- You should [Download your Secure bundle](https://github.com/datastaxdevs/awesome-astra/wiki/Download-the-secure-connect-bundle)

## 📦. Prerequisites [Development Environment]

- You should install **Java Development Kit (JDK) 8**: Use the [reference documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) to install a **Java Development Kit**, Validate your installation with

```bash
java --version
```

- You should install **Apache Maven**: Use the [reference documentation](https://maven.apache.org/install.html) and validate your installation with

```bash
mvn -version
```

## 📦. Setup Project

- Please note that version **3.8+** is required to connect to Astra.

- Update your `pom.xml` file with the latest version of the 3.x libraries: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.datastax.cassandra/cassandra-driver-mapping/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.datastax.cassandra/cassandra-driver-mapping/)

```xml
<dependency>
  <groupId>com.datastax.cassandra</groupId>
  <artifactId>cassandra-driver-core</artifactId>
  <version>${latest3x}</version>
</dependency>
```

#### 🖥️. Sample Code (project [astra-driver3x](https://github.com/DataStax-Examples/astra-samples-java/tree/main/astra-driver3x))

```java
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class AstraDriver3x {    
 
 // Define inputs
 static final String ASTRA_ZIP_FILE = "<path_to_secureConnectBundle.zip>";
 static final String ASTRA_USERNAME = "<provide_a_clientId>";
 static final String ASTRA_PASSWORD = "<provide_a_clientSecret>";
 static final String ASTRA_KEYSPACE = "<provide_your_keyspace>";    
    
 public static void main(String[] args) {
  Logger logger = LoggerFactory.getLogger(AstraDriver3x.class);
  try(Cluster cluster = Cluster.builder()
    .withCloudSecureConnectBundle(new File(ASTRA_ZIP_FILE))
    .withCredentials(ASTRA_USERNAME, ASTRA_PASSWORD)
    .build() ) {
      Session session = cluster.connect(ASTRA_KEYSPACE);
      logger.info("[OK] Welcome to ASTRA. Connected to Keyspace {}", session.getLoggedKeyspace());
  }
  logger.info("[OK] Success");
  System.exit(0);
 }

}
```

## 🔗. Extra Resources
- [Multiple Standalone Classes using driver 3.x](https://github.com/DataStax-Examples/java-cassandra-driver-from3x-to4x/tree/master/example-3x/src/main/java/com/datastax/samples)
