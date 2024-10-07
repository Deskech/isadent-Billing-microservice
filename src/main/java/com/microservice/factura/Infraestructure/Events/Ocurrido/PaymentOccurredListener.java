package com.microservice.factura.Infraestructure.Events.Ocurrido;


import com.microservice.factura.Infraestructure.Events.Publicado.Dtos.PaymentPublishedEvent;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.PublishedPaymentMapper;
import com.microservice.factura.Infraestructure.Repository.Query.Actualization.QueryValuesActualization;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the listener of the payments that has been stored in the Command line database
 */
@Component
public class PaymentOccurredListener {
    private final QueryValuesActualization queryValuesActualization;
    private final PublishedPaymentMapper publishedPaymentMapper;
    public PaymentOccurredListener(QueryValuesActualization queryValuesActualization, PublishedPaymentMapper publishedPaymentMapper) {
        this.queryValuesActualization = queryValuesActualization;
        this.publishedPaymentMapper = publishedPaymentMapper;

    }

    /**
     *
     * @param publishedPayment represents the string object of the new payment that has been stored.
     *                      Must contain patient's bill monetary values and the patient's name
     */
    @Transactional
    @SneakyThrows
    @RabbitListener(queues = "abonoActualizadoQueue")

    public void alternatePayment(String publishedPayment) {
        // since we receive a string it is necessary to map it to the real object
        PaymentPublishedEvent paymentPublishedEvent = publishedPaymentMapper.create(publishedPayment);
        // then we use the jpa repository method to update ONLY the needed values ( patient's bill monetary values)
        queryValuesActualization.updateValuesActualization(paymentPublishedEvent
                        .getBillValues()
                        .getPaymentBill()
                        .getPaymentBill(),
                paymentPublishedEvent
                        .getBillValues()
                        .getPaymentCurrency(),
                paymentPublishedEvent
                        .getBillValues()
                        .getRemainingBalance()
                        .getRemainingPayment(),
                paymentPublishedEvent
                        .getBillValues()
                        .getRemainingBalanceCurrency(),
                paymentPublishedEvent.getPatientName());
    }

}
