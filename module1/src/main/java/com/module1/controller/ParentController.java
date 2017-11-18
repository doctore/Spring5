package com.module1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

/**
 * Parent class of all controllers
 */
public class ParentController {

    // Used to manage the requests in an asynchronous way
    @Autowired
    protected TaskExecutor taskExecutor;

}
