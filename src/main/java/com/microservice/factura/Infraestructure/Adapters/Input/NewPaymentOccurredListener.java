package com.microservice.factura.Infraestructure.Adapters.Input;


import com.microservice.factura.Application.Dtos.NewPaymentRequest;
import com.microservice.factura.Application.Services.CreateNewPayment;
import com.microservice.factura.Domain.Events.Ocurridos.PaymentOccurred;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.NewPaymentReqMapper;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * This is the payments events listener
 */
@Component
public class NewPaymentOccurredListener implements PaymentOccurred<String> {
    private final CreateNewPayment createNewPayment;

    private final NewPaymentReqMapper newPaymentReqMapper;
    public NewPaymentOccurredListener(CreateNewPayment createNewPayment, NewPaymentReqMapper newPaymentReqMapper) {
        this.createNewPayment = createNewPayment;

        this.newPaymentReqMapper = newPaymentReqMapper;
    }

    /**
     *
     * @param newPaymentRequest represents the object comming from the payment microservice
     */
   @RabbitListener(queues = "reportarAbonoFactura")
    @Override
    public void listenNewAbono(String newPaymentRequest) {
        try {
            //1. map the newPaymentRequest object to an application layer
            NewPaymentRequest newPaymentRequest2 = newPaymentReqMapper.crear(newPaymentRequest);
            //2. update and store the patient's bill new monetary values
            createNewPayment.darNuevosValores(newPaymentRequest2);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(e.getMessage());
        }
    }
}
