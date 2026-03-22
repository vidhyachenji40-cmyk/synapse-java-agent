package com.vidhya.ai;

import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class SynapseAgent {

    public String generateOptimizationScript() {
        String scalaScript = """
            // Optimized Synapse Partitioning Script
            val df = spark.read.format("csv").load("abfss://data@synapse.dfs.core.windows.net/")
            df.write.partitionBy("Year", "Month").mode("overwrite").saveAsTable("OptimizedSales")
            println("Optimization Complete for 5TB+ Dataset")
            """;

        try (FileWriter writer = new FileWriter("OptimizeSynapse.scala")) {
            writer.write(scalaScript);
            return "Success: Optimization script generated as OptimizeSynapse.scala";
        } catch (IOException e) {
            return "Error: Could not write the file: " + e.getMessage();
        }
    }
}