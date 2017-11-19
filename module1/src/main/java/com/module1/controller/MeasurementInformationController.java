package com.module1.controller;

import java.util.concurrent.CompletableFuture;

import com.module1.Constants;
import com.module1.dto.MeasurementInformationDto;
import com.module1.service.MeasurementInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementInformationController extends ParentController {

	@Autowired
	private MeasurementInformationService measurementInformationService;


	/**
	 *    Get the given {@link MeasurementInformationDto} information and send it (using a Kafka producer)
	 * to the Kafka consumers that are currently listening
	 *
	 * @param measurementInformation
	 *    {@link MeasurementInformationDto} with the Json information re
	 *
	 * @return true
	 */
	@PostMapping("/insertMeasurementInformation")
	public CompletableFuture<Boolean> insertMeasurementInformation (@RequestBody MeasurementInformationDto measurementInformation) {

		return CompletableFuture.supplyAsync (() -> measurementInformationService.addNewMeasurementData (measurementInformation)
		                                     ,taskExecutor);
	}

}
