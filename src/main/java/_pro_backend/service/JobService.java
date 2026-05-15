package _pro_backend.service;


import _pro_backend.entity.Job;

import java.util.List;

public interface JobService {

    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(int id);
}