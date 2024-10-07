package com.microservice.factura.Infraestructure.Persistance.CommandLine;

import com.microservice.factura.Domain.Models.CommandLine.ValueObjects.ImprovementPlan;
import com.microservice.factura.Domain.Repository.CommandLine.WriteBillRepository;
import com.microservice.factura.Infraestructure.Mappers.Interfaces.DentalProceduresMapper;
import com.microservice.factura.Infraestructure.Repository.CommandLine.WriteBillJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this is the write bill domain repository implementation
 */
@Component
public class WriteBillImpl implements WriteBillRepository {
    private final WriteBillJpaRepository writeBillJpaRepository;
    private final DentalProceduresMapper<ImprovementPlan> dentalProceduresMapper;

    public WriteBillImpl(WriteBillJpaRepository writeBillJpaRepository, DentalProceduresMapper<ImprovementPlan> dentalProceduresMapper) {
        this.writeBillJpaRepository = writeBillJpaRepository;
        this.dentalProceduresMapper = dentalProceduresMapper;
    }

    /**
     *
     * @param dentalProcedures represents the list of dental procedures and prices that needs to be stored
     * @param patientName represents the patient's name so that the repository knows where to store it
     */
    @Override
    public void saveDentalProcedures(List<ImprovementPlan> dentalProcedures, String patientName) {

        writeBillJpaRepository.saveDentalProcedures(dentalProceduresMapper.toJson(dentalProcedures), patientName);
    }
}
