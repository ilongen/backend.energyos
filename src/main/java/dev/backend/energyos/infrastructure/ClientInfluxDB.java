package dev.backend.energyos.infrastructure;

import com.influxdb.v3.client.InfluxDBClient;

public final class ClientInfluxDB {
    public static void main(final String[] args) throws Exception {
        String hostUrl = "https://us-east-1-1.aws.cloud2.influxdata.com";
        char[] authToken = System.getenv("INFLUXDB_TOKEN").toCharArray();

        try (InfluxDBClient client = InfluxDBClient.getInstance(hostUrl, authToken, null)) {

        }
    }
}
