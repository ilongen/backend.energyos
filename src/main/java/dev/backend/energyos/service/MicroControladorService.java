package dev.backend.energyos.service;

import com.influxdb.v3.client.InfluxDBClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class MicroControladorService {

    private final InfluxDBClient influxDBClient;

    public MicroControladorService(InfluxDBClient influxDBClient){
        this.influxDBClient = influxDBClient;
    }

    // errar uma virgula irá quebrar a query de insert no banco, cuidado!
    public void salvarMedicao(UUID microControlID,
                              double tensao,
                              double corrente,
                              double potencia,
                              double energia,
                              double frequencia) {

        String line = String.format(Locale.US,
                "microcontrolador_data,microControlID=%s tensao=%f,corrente=%f,potencia=%f,energia=%f,frequencia=%f",
                microControlID, tensao, corrente, potencia, energia, frequencia
        );

        influxDBClient.writeRecord(line);
    }
    public List<String> buscarMedicoes(UUID microControlID) {

        String query = String.format(
                "SELECT * FROM microcontrolador_data WHERE microControlID = '%s'",
                microControlID
        );

        var result = influxDBClient.query(query);

        List<String> data = new ArrayList<>();

        result.forEach(row -> data.add(row.toString()));

        return data;
    }
}