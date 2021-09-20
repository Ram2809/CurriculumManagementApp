package com.curriculum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curriculum.entity.Topic;
import com.curriculum.exception.BusinessServiceException;
import com.curriculum.exception.SubjectNotFoundException;
import com.curriculum.service.TopicService;
import com.curriculum.util.Response;

@RestController
@RequestMapping("api/topic")
@CrossOrigin("http://localhost:4200")
public class TopicController {
	@Autowired
	private TopicService topicServiceImpl;
	@PostMapping
	public ResponseEntity<Response> addTopic(@RequestBody Topic topicDetails)
	{
		Response response=new Response();
		ResponseEntity responseEntity=null;
		Topic topic=null;
		try {
			topic=topicServiceImpl.addTopic(topicDetails);
			response.setCode(200);
			response.setMessage("Topic details added successfully!");
			response.setData(topic);
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.OK);
		} catch (BusinessServiceException e) {
			response.setCode(404);
			response.setMessage(e.getMessage());
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@GetMapping("subject/{subjectCode}")
	public ResponseEntity<Response> getTopicBySubjectCode(@PathVariable("subjectCode") String subjectCode)
	{
		Response response=new Response();
		ResponseEntity responseEntity=null;
		List<Topic> topicsList=new ArrayList();
		try {
			topicsList=topicServiceImpl.getTopicBySubjectCode(subjectCode);
			if(!topicsList.isEmpty())
			{
				response.setCode(200);
				response.setMessage("Success!");
				response.setData(topicsList);
				responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.OK);
			}
			else
			{
				response.setCode(404);
				response.setMessage("No units found!");
				responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
			}
		} catch (BusinessServiceException e) {
			response.setCode(404);
			response.setMessage(e.getMessage());
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@GetMapping
	public ResponseEntity<Response> getTopicByUnitNo(@RequestParam("unitNo") String unitNo)
	{
		Response response=new Response();
		ResponseEntity responseEntity=null;
		Topic topic=null;
		try {
			topic=topicServiceImpl.getTopicByUnitNo(unitNo);
			response.setCode(200);
			response.setMessage("Success!");
			response.setData(topic);
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.OK);
		} catch (BusinessServiceException e) {
			response.setCode(404);
			response.setMessage(e.getMessage());
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@PutMapping("/{unitNo}")
	public ResponseEntity<Response> updateTopic(@PathVariable("unitNo") String unitNo,@RequestBody Topic topicDetails) 
	{
		Response response=new Response();
		ResponseEntity responseEntity=null;
		Topic topic=null;
		try {
			topic=topicServiceImpl.updateTopic(unitNo,topicDetails);
			response.setCode(200);
			response.setMessage("Topic details updated successfully!");
			response.setData(topic);
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.OK);
		} catch (BusinessServiceException e) {
			response.setCode(404);
			response.setMessage(e.getMessage());
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@GetMapping("/{unitNo}")
	public ResponseEntity<Response> getSubjectCode(@PathVariable("unitNo") String unitNo)
	{
		Response response=new Response();
		ResponseEntity responseEntity=null;
		String subjectCode=null;
		try {
			subjectCode=topicServiceImpl.getSubjectCode(unitNo);
			response.setCode(200);
			response.setMessage("Success!");
			response.setData(subjectCode);
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.OK);
		} catch (BusinessServiceException e) {
			response.setCode(404);
			response.setMessage(e.getMessage());
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	@DeleteMapping("/{unitNo}")
	public ResponseEntity<Response> deleteTopic(@PathVariable("unitNo") String unitNo)
	{
		Response response=new Response();
		ResponseEntity responseEntity=null;
		Topic topic=null;
		try {
			topic=topicServiceImpl.deleteTopic(unitNo);
			if(topic!=null)
			{
				response.setCode(200);
				response.setMessage("Topic details deleted successfully!");
				response.setData(topic);
				responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.OK);
			}
			else
			{
				response.setCode(500);
				response.setMessage("Internal Server Error");
				responseEntity = new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (BusinessServiceException e) {
			response.setCode(404);
			response.setMessage(e.getMessage());
			responseEntity=new ResponseEntity<Response>(response,new HttpHeaders(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
