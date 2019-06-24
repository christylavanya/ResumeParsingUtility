package com.hsi.parsing.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsi.parsing.Util.ResumeParserConstant;
import com.hsi.parsing.exception.ResumeParsingException;
import com.hsi.parsing.model.CandidateDetails;
import com.hsi.parsing.service.CSVReaderServiceImpl;
import com.hsi.parsing.service.ConvertToMultipleCSVService;

@CrossOrigin
@RestController
@RequestMapping("/v1/")
public class ResumeParserController {

	@Autowired
	CSVReaderServiceImpl csvReader;

	@Autowired
	ConvertToMultipleCSVService convertToMultipleCSV;
	
	
	// ResumeParserConstant resumeParserConstant = new ResumeParserConstant() ;

	static Logger logger = Logger.getLogger(ResumeParserController.class.getName());

	/**
	 * This method will call from UI to convert multiple files to .CSV .doc to .CSV
	 * & .docx to .CSV & .pdf to CSV and all the converted files will store in /temp
	 * folder
	 * 
	 * @param filePath
	 * @return ResponseEntity
	 **/
	@PostMapping(value = ("/convertToCSV"))
	public ResponseEntity<String> convertToCSVFormat(@RequestBody() String filePath,
			HttpServletResponse response) throws IOException {
		try {
			logger.info(ResumeParserConstant.LOG_FOR_ENTRY_FOR_CONVERTCSVFORMAT_METHOD);
			convertToMultipleCSV.convertToCSV(filePath);
			return new ResponseEntity<>(ResumeParserConstant.SUCCESS_MSG_FOR_CSV_CREATE, HttpStatus.OK);
		} catch (ResumeParsingException resumeParsingException) {
			return new ResponseEntity<>(resumeParsingException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value = ("/hello"))
	public ResponseEntity<String> sayHello(HttpServletResponse response) throws IOException {
		try {
			logger.info(ResumeParserConstant.LOG_FOR_ENTRY_FOR_CONVERTCSVFORMAT_METHOD);
			//convertToMultipleCSV.convertToCSV(filePath);
			return new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (ResumeParsingException resumeParsingException) {
			return new ResponseEntity<>(resumeParsingException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * This method will call from UI to pick converted multiple .CSV files from
	 * /temp folder and all the converted files will store in /temp folder
	 * 
	 * @param filePath
	 * @return listOfCandidate Info
	 **/

	@PostMapping(value = ("/getCandidateDetails"))
	public ResponseEntity<List<CandidateDetails>> getCandidateDetails(@RequestBody() String filePath,
			HttpServletResponse response) throws IOException {
		try {
			logger.info(ResumeParserConstant.LOG_FOR_ENTRY_FOR_GETCANDIDATEDETAILS_METHOD);
			List<CandidateDetails> candidateDetailsFromCSVFile = csvReader.getCandidateDetailsFromCSVFile(filePath);
			return new ResponseEntity<>(candidateDetailsFromCSVFile, HttpStatus.OK);
		} catch (ResumeParsingException resumeParsingException) {
			return new ResponseEntity(resumeParsingException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
		
}
