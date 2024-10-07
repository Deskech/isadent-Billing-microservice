package com.microservice.factura.Infraestructure.Events.Ocurrido;

import com.microservice.factura.Infraestructure.Events.Publicado.Dtos.QuotationPublishedEvent;
import com.microservice.factura.Infraestructure.Factories.Interfaces.PublishedQuotationFactory;
import com.microservice.factura.Infraestructure.Persistance.Query.Actualization.QueryQuotation;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * This is the Listener for the Quotations that has been stored in the Command line database
 */
@Component
public class QuotationOccurredListener {


    private final QueryQuotation queryQuotation;
    private final PublishedQuotationFactory publishedQuotationFactory;
    public QuotationOccurredListener(QueryQuotation queryQuotation, PublishedQuotationFactory publishedQuotationFactory) {

        this.publishedQuotationFactory = publishedQuotationFactory;
        this.queryQuotation = queryQuotation;
    }

    /**
     *
     * @param quotationPublishedEvent represents the String object of the Quotation stored in the command line database
     */
    @RabbitListener(queues = "cotizacionActualizadoQueue")
    void actualizarCotizacion(String quotationPublishedEvent) {
       try {
           // since we receive a string it is necessary to map it to the real object
          QuotationPublishedEvent cotizacionParaActualizar = publishedQuotationFactory.deserializeString(quotationPublishedEvent);
          //then we store the new quotation in the query line database
           queryQuotation.saveQuotation(cotizacionParaActualizar);

       } catch (Exception e) {
           throw new AmqpRejectAndDontRequeueException(e);
       }

    }
}
