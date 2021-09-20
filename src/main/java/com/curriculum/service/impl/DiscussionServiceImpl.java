package com.curriculum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.curriculum.entity.Discussion;
import com.curriculum.exception.BusinessServiceException;
import com.curriculum.exception.DatabaseException;
import com.curriculum.repository.DiscussionRepository;
import com.curriculum.service.DiscussionService;
@Service
public class DiscussionServiceImpl implements DiscussionService{
	@Autowired
	private DiscussionRepository discussionRepositoryImpl;
	@Override
	public Discussion addDiscussion(Discussion discussionDetails) throws BusinessServiceException {
		try {
			return discussionRepositoryImpl.addDiscussion(discussionDetails);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
	@Override
	public List<Discussion> getDiscussionByUnitNo(String unitNo) throws BusinessServiceException {
		try {
			return discussionRepositoryImpl.getDiscussionByUnitNo(unitNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
	@Override
	public Discussion updateDiscussion(Long questionNo,Discussion discussionDetails) throws BusinessServiceException {
		try {
			return discussionRepositoryImpl.updateDiscussion(questionNo,discussionDetails);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
	@Override
	public Discussion deleteDiscussion(Long questionNo) throws BusinessServiceException {
		try {
			return discussionRepositoryImpl.deleteDiscussion(questionNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
	@Override
	public Discussion getParticularDiscussion(Long questionNo) throws BusinessServiceException {
		try {
			return discussionRepositoryImpl.getParticularDiscussion(questionNo);
		} catch (DatabaseException e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}

}
