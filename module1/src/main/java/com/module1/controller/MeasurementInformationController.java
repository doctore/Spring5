package com.module1.controller;

import java.util.concurrent.CompletableFuture;

import com.module1.dto.MeasurementInformationDto;
import com.module1.service.MeasurementInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurementInformation")
public class MeasurementInformationController extends ParentController {

	@Autowired
	private MeasurementInformationService measurementInformationService;


	/**
	 * Manages the insertion of the given {@link MeasurementInformationDto}
	 *
	 * @param measurementInformation
	 *    {@link MeasurementInformationDto} with the Json information re
	 *
	 * @return true
	 */
	@PostMapping
	public CompletableFuture<Boolean> addMeasurementInformation (@RequestBody MeasurementInformationDto measurementInformation) {

		return CompletableFuture.supplyAsync (() -> measurementInformationService.addMeasurementInformation (measurementInformation)
		                                     ,taskExecutor);
	}

}
