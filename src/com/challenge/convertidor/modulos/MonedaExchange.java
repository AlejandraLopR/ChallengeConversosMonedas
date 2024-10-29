package com.challenge.convertidor.modulos;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record MonedaExchange(@SerializedName("base_code") String result, @SerializedName("conversion_rates") Map<String, Double> conversion_rates) {
}
