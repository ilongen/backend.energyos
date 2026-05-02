package dev.backend.energyos.service;

import com.influxdb.v3.client.InfluxDBClient;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MicroControladorService {

    private final InfluxDBClient influxDBClient;

    public MicroControladorService(InfluxDBClient influxDBClient){
        this.influxDBClient = influxDBClient;
    }

    // errar uma virgula irá quebrar a query de insert no banco, cuidado!
    public void salvarMedicao(Long microControlID,
                              double tensao,
                              double corrente,
                              double potencia,
                              double energia,
                              double frequencia) {

        String line = String.format(Locale.US,
                "microcontrolador_data,microControlID=%d tensao=%f,corrente=%f,potencia=%f,energia=%f,frequencia=%f",
                microControlID, tensao, corrente, potencia, energia, frequencia
        );

        influxDBClient.writeRecord(line);
    }
}