package com.datastax.astra;

import java.io.File;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class AstraDriver3x {
  public static void main(String[] args) {
    try(Cluster cluster = Cluster.builder()
     .withCloudSecureConnectBundle(new File("/tmp/scb.zip"))
     .withCredentials("client_id", "client_secret")
     .build()) {

       try(Session session = cluster.connect("demo_keyspace")) {
         System.out.println(session.getLoggedKeyspace());
       }
    }
  }
}
