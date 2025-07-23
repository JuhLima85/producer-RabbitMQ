package br.com.juh.producer.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // Exchanges
    public static final String EXG_NAME_MARKETPLACE = "marketplace.direct";
    // Filas
    public static final String QUEQUE_PRODUCT_LOG = "product.log";
    // Routing key
    public static final String RK_PRODUCT_LOG = "product.log";

    // Retorna a Fila
    @Bean
    public Queue queue(){
        return new Queue(QUEQUE_PRODUCT_LOG, false, false, false);
    }

    // Retorna a Exchange
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXG_NAME_MARKETPLACE, false, false);
    }

    // Retorna o bindig entre o produce.log e a Exchange. Informamos a fila, qual a Exchange e com
    // qual Routing key queremos definir esse binding
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(RK_PRODUCT_LOG);
    }

}
