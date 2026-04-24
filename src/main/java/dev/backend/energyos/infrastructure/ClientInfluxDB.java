package dev.backend.energyos.infrastructure;

import com.influxdb.v3.client.InfluxDBClient;

public final class ClientInfluxDB {
    public static void main(final String[] args) {

        String hostUrl = "https://us-east-1-1.aws.cloud2.influxdata.com";

        String token = System.getenv("INFLUXDB_TOKEN");

        if (token == null) {
            throw new RuntimeException("INFLUXDB_TOKEN não encontrado nas variáveis de ambiente");
        }

        char[] authToken = token.toCharArray();

        try (InfluxDBClient client = InfluxDBClient.getInstance(hostUrl, authToken, null)) {

            System.out.println("✅ Conectado com sucesso ao InfluxDB!");

        } catch (Exception e) {
            System.out.println("❌ Erro ao conectar:");
            e.printStackTrace();
        }
    }
}